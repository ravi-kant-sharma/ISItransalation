package impl;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.commons.jcr.JcrUtil;
import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.*;
import org.oasis.xliff.core_12.*;
import service.GenericService;
import utill.ISITransConstants;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.io.File;
import java.util.*;

import javax.jcr.query.Query;
import javax.xml.bind.Unmarshaller;

/**
 * Created by ttnd on 25/4/16.
 */

public class GenericServiceImpl implements GenericService {

    @org.apache.felix.scr.annotations.Reference
    ResourceResolverFactory resolverFactory;

    @org.apache.felix.scr.annotations.Reference
    ResourceResolver resourceResolver;


    /**
     *
     * @param pathID path of the resource
     * @param depth pageItself, entire hierarchy, immediate child
     * @param sourceLanguage
     * @param targetLanguage
     * @param resourceResolver
     */
    @Override
    public void generateXlfFromPage(String pathID,String depth, String sourceLanguage, String targetLanguage, ResourceResolver resourceResolver){
        Properties properties = new Properties();
        Map<String,List<String>> validPropertiesMap = new HashMap<String, List<String>>();
        try {
            properties.load(new FileInputStream(new java.io.File("/home/ttnd/Idea-Workspace/ISITransalation/ServerSide/src/test/resources/component-path.properties")));
            Set<String> propertyKeys = properties.stringPropertyNames();
            for (String key : propertyKeys){
                List<String> valueList = Arrays.asList(((String[])properties.get(key).toString().split(";")));
                validPropertiesMap.put(key,valueList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        Resource resource = resourceResolver.getResource(pathID);
        String sourcePath = resource.getPath();

        Xliff xliff = new Xliff();
        xliff.setVersion("1.0");
        Header header = new Header();
        Body body = new Body();

        org.oasis.xliff.core_12.File file = new org.oasis.xliff.core_12.File();
        file.setOriginal(resource.getPath());
        file.setSourceLanguage(sourceLanguage);
        file.setTargetLanguage(targetLanguage);

        xliff.getAnyAndFile().add(file);
        xliff.getAnyAndFile().add(header);
        xliff.getAnyAndFile().add(body);

        Page page = resource.adaptTo(Page.class);

        processValueMapForTransUnit(validPropertiesMap,resource,resource.getValueMap(),body);

        try {
            JAXBContext contextObj = JAXBContext.newInstance(Xliff.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(xliff, new FileOutputStream("generated_xlf.xlf"));
        }catch (JAXBException je){
            je.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    public void generatePageFromXlf(String filePath,ResourceResolver resourceResolver) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Xliff.class);
            Unmarshaller unmarshaller = contextObj.createUnmarshaller();
            String sourceLanguage = "";
            String targetLanguage = "";
            String sourcePath = "";
            List<Object> transUnits=null;

            File f = new File(filePath);

            Xliff xliffObj = (Xliff)unmarshaller.unmarshal(f);
            List anyAndFile = xliffObj.getAnyAndFile();
            for (Object anf : anyAndFile){
                if(anf instanceof org.oasis.xliff.core_12.File){
                    sourceLanguage = ((org.oasis.xliff.core_12.File) anf).getSourceLanguage();
                    targetLanguage = ((org.oasis.xliff.core_12.File) anf).getTargetLanguage();
                    sourcePath = ((org.oasis.xliff.core_12.File) anf).getOriginal();
                }
                if(anf instanceof Body){
                    transUnits = ((Body) anf).getGroupOrTransUnitOrBinUnit();
                }
                boolean isRootPage = !(sourcePath.contains(sourceLanguage)) && sourcePath.endsWith(sourceLanguage);
                String targetPath = isRootPage ? sourcePath.substring(sourcePath.lastIndexOf("/")) + targetLanguage : sourcePath.replace("/" + sourceLanguage + "/", "/" + targetLanguage + "/");
                Node destNode;
                Resource resource = resourceResolver.getResource(targetPath);
                destNode = resource != null ? resource.adaptTo(Node.class) : createTargetJcrPath(resourceResolver, targetPath);
                if (destNode != null) {
//                    def languageProps = resourceResolver.getResource(ISITransConstants.LANGUAGE_CONFIGURATION)?.adaptTo(ValueMap) ?: [:]
//                    String aemTargetLanguage = languageProps.find { key, val -> val.equals(targetLanguage) }?.key ?: targetLanguage.replace("-", "_")
                    updatePageProperties(destNode, sourcePath,transUnits, resourceResolver, sourceLanguage, null, null);
                }

            }



        }catch (JAXBException je){
            je.printStackTrace();
        }
    }

    private void updatePageProperties(Node destinationNode,String sourcePath, List<Object> transUnits, ResourceResolver resourceResolver, String srcLang, String targetLang, String jobId) {
        Session session;
//        String sourcePath = pageBodyRecords["pg-path"].@'src-path'
        try {
            session = resourceResolver.adaptTo(Session.class);
            Node contentNode= null ;
            boolean nodeExists = destinationNode.hasNode(JcrConstants.JCR_CONTENT);
            if (nodeExists) {
                contentNode = destinationNode.getNode(JcrConstants.JCR_CONTENT);
            } else {
                contentNode = JcrUtil.copy(resourceResolver.getResource(sourcePath+"/"+JcrConstants.JCR_CONTENT).adaptTo(Node.class), destinationNode, null);
                if (contentNode.hasNode(ISITransConstants.SKIP_NODE)) {
                    contentNode.getNode(ISITransConstants.SKIP_NODE).remove();
                }
            }
//            pageBodyRecords["pg-meta"]["element"]?.each {
//                String propName = it.@name.text()
//                        contentNode.setProperty(propName, it.text());
//            }
//            pageBodyRecords["pg-nodes"]["pg-node"]?.each {
//                String nodePath = it.@'node-loc'.text()
//                Node currentNode = createTargetNodeIfNotPresent(nodePath, srcLang, targetLang, resourceResolver)
//                it["node-props"]["element"].each { nodeProperty ->
//                        currentNode.setProperty(nodeProperty.@name?.text(), nodeProperty.text())
//                }
//            }

            for(Object transUnit : transUnits){
                String nodePath = ((TransUnit) transUnit).getId();
                nodePath  = nodePath.substring(0,nodePath.lastIndexOf("/"));
                String propertyName = nodePath.substring(nodePath.lastIndexOf("/"));
//                Source source = ((TransUnit) transUnit).getSource();
                Target target = ((TransUnit) transUnit).getTarget();
                Node currentNode = createTargetNodeIfNotPresent(nodePath, srcLang, targetLang, resourceResolver);
                currentNode.setProperty(propertyName,(String[])target.getContent().toArray());
            }

            if (!nodeExists) {
                contentNode.setProperty(ISITransConstants.TRANSLATED_TO, "");
                contentNode.setProperty(ISITransConstants.TRANSLATION_PROP_NAME, ISITransConstants.NOT_TRANSLATED);
                contentNode.setProperty(ISITransConstants.LAST_TRANSLATED_DATE, "");
            }
            contentNode.setProperty(ISITransConstants.TRANSLATED_FROM, srcLang);
            Node srcNode = resourceResolver.getResource(sourcePath+"/"+JcrConstants.JCR_CONTENT).adaptTo(Node.class);
            String existingLang = srcNode.hasProperty(ISITransConstants.TRANSLATED_TO) ? srcNode.getProperty(ISITransConstants.TRANSLATED_TO).toString() : "";
            if (existingLang != null) {
                existingLang = existingLang.matches(".*\\b${targetLang}\\b.*") ? existingLang : existingLang + ",${targetLang}";
            }
            srcNode.setProperty(ISITransConstants.TRANSLATED_TO, existingLang != null ? existingLang: targetLang);
            srcNode.setProperty(ISITransConstants.TRANSLATION_PROP_NAME, ISITransConstants.TRANSLATED);
            Resource jobResource = resourceResolver.getResource(jobId);
            copyCompletedItemToSeparateHierarchy(jobResource.getChild(sourcePath.replace("\\", "-")), resourceResolver, new GregorianCalendar(jobResource.adaptTo(ValueMap.class).get(JcrConstants.JCR_CREATED)));

            if (jobResource != null && !jobResource.listChildren().hasNext()) {
                jobResource.adaptTo(Node.class).remove();
            }
            session.save();
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    /**
     *
     * @param item
     * @param resourceResolver
     */
    private void copyCompletedItemToSeparateHierarchy(Resource item, ResourceResolver resourceResolver, Calendar creationDate) throws PersistenceException, RepositoryException {
        String nodePathToCreate = item != null ? item.getPath(): item.getPath().replaceAll(ISITransConstants.JOBS_CONFIGURATION_PATH, ISITransConstants.COMPLETED_JOB_PATH);
        if (nodePathToCreate != null) {
            String pathWithDatePrefix = generateDatePathPrefix(nodePathToCreate.substring(nodePathToCreate.lastIndexOf("/")), creationDate);
            Resource resource = ResourceUtil.getOrCreateResource(resourceResolver, pathWithDatePrefix, "", "", true);
            Node parentNode = resource.adaptTo(Node.class);
            if (!parentNode.hasProperty(ISITransConstants.TRANSLATION_START_DATE)) {
                ValueMap parentSourceNodeProps = item.getParent().adaptTo(ValueMap.class);
                parentNode.setProperty(ISITransConstants.TRANSLATION_START_DATE, creationDate);
                parentNode.setProperty("jobNiceName", parentSourceNodeProps.get("jobNiceName").toString());
                parentNode.setProperty("jobEndDate",  parentSourceNodeProps.get("jobEndDate").toString());
            }
            Node childNode = JcrUtil.copy(item.adaptTo(Node.class), parentNode, null);
            childNode.setProperty(ISITransConstants.JOB_STATUS_VARIABLE, ISITransConstants.TRANSLATED);
            if(item != null){
                item.adaptTo(Node.class).remove();
            }
        }
    }

    private String generateDatePathPrefix(String nodePath, Calendar calendar) {
        String pathAfterRoot = nodePath.substring(ISITransConstants.COMPLETED_JOB_PATH.length());
        String datePath = ISITransConstants.COMPLETED_JOB_PATH + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + pathAfterRoot;
        return datePath;
    }

    /**
     *
     * @param nodePath
     * @param srcLang
     * @param targetLang
     * @param resourceResolver
     */
    private Node createTargetNodeIfNotPresent(String nodePath, String srcLang, String targetLang, ResourceResolver resourceResolver) {
        Resource sourceResource = resourceResolver.getResource(nodePath);
        String targetNodePath = sourceResource.getPath().replace(srcLang, targetLang);
        Node currentNode = resourceResolver.getResource(targetNodePath) != null ? resourceResolver.getResource(targetNodePath).adaptTo(Node.class) : null;
        Node tempNode = currentNode;
        if (tempNode != null) {
            Resource nodeToCopy = sourceResource;
            sourceResource = sourceResource.getParent();
            boolean tempNodeExists = false;
            while (!tempNodeExists) {
                targetNodePath = sourceResource.getPath().replace(srcLang, targetLang);
                tempNode = resourceResolver.getResource(targetNodePath) != null ? resourceResolver.getResource(targetNodePath).adaptTo(Node.class) : null;
                if (tempNode != null) {
                    try {
                        currentNode = JcrUtil.copy(nodeToCopy.adaptTo(Node.class), tempNode, null);
                    } catch (RepositoryException e) {
                        e.printStackTrace();
                    }
                    tempNodeExists = true;
                } else {
                    nodeToCopy = sourceResource;
                    sourceResource = sourceResource.getParent();
                }
            }
        }
        return currentNode;
    }

    private Node createTargetJcrPath(ResourceResolver resourceResolver, String targetPath) {
        Session session;
        Node destinationNode = null;
        try {
            session = resourceResolver.adaptTo(Session.class);
            destinationNode = JcrUtil.createPath(targetPath, NameConstants.NT_PAGE, session);
            session.save();
        }
        catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
        return destinationNode;
    }

    private void addNewTransUnit(String transUnitId,String content,Body body){
        TransUnit transUnit = new TransUnit();
        transUnit.setId(transUnitId);

        Source source = new Source();
        source.getContent().add(content);
        transUnit.setSource(source);

        Target target = new Target();

        body.getGroupOrTransUnitOrBinUnit().add(transUnit);
    }

    private void processValueMapForTransUnit(Map propertiesMap,Resource resource, ValueMap valueMap,Body body){
        String resourceType = resource.getResourceType();
        if(propertiesMap.containsKey(resourceType)){
            Set<String> keySet = valueMap.keySet();
            List<String> propertyValues = (List<String>) propertiesMap.get(resourceType);
            for(String key : keySet){
                if(propertyValues.contains(key)){
                    String transId = resource.getPath() + "/@"+key;
                    addNewTransUnit(transId,(String)valueMap.get(key),body);
                }
            }

        }
        Iterator<Resource> childrenItr = resource.listChildren();
        while(childrenItr.hasNext()){
            Resource childResource = childrenItr.next();
            processValueMapForTransUnit(propertiesMap,childResource,childResource.getValueMap(),body);
        }
    }

}
