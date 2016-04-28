import impl.GenericServiceImpl;
import integration.api.*;
import junit.framework.TestCase;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.cxf.common.i18n.Exception;
import org.oasis.xliff.core_12.Ex;
import service.GenericService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ttnd on 19/4/16.
 */
public class PlunetTransalationTest extends TestCase {
    PlunetAPIService plunetService;
    PlunetAPI plunetApi;

    DataRequest30Service dataRequest30Service;
    DataRequest30 dataRequest30Api;

    RequestDocText25Service requestDocText25Service;
    RequestDocText25 requestDocText25Api;

    DataOrder30Service dataOrder30Service;
    DataOrder30 dataOrder30Api;

    String sourceText = "Hello World";
    int requestIdInput = 0;

    public void setUp(){
        plunetService = new PlunetAPIService();
        plunetApi = plunetService.getPlunetAPIPort();

        dataRequest30Service = new DataRequest30Service();
        dataRequest30Api = dataRequest30Service.getDataRequest30Port();

        requestDocText25Service = new RequestDocText25Service();
        requestDocText25Api = requestDocText25Service.getRequestDocText25Port();

        dataOrder30Service = new DataOrder30Service();
        dataOrder30Api = dataOrder30Service.getDataOrder30Port();
    }

    public void testTranslateInputFlow(){
        String uuid = plunetApi.login("******","******");
        System.out.println(uuid);
        RequestIN requestInput = new RequestIN();
        requestInput.setBriefDescription("Testing the flow");
        requestInput.setSubject("Test Flow");

        IntegerResult requestId = dataRequest30Api.insert2(uuid,requestInput);
        requestIdInput = requestId.getData();
        System.out.println("RequestId="+requestIdInput);
        dataRequest30Api.addLanguageCombination(uuid,"en","fr",requestId.getData());

        IntegerResult sourceFileId = requestDocText25Api.insert(uuid,requestId.getData());
        System.out.println("Source File Id="+sourceFileId.getData());
        requestDocText25Api.setSourceText(uuid,sourceText);
        requestDocText25Api.setCustomerTextID(uuid, 1);
        requestDocText25Api.update(uuid);

        dataRequest30Api.orderRequest(uuid,requestId.getData());

        plunetApi.logout(uuid);
    }

    public void testTranslateOutputFlow(){
        String uuid = plunetApi.login("******","*****");

        IntegerArrayResult requestResult = requestDocText25Api.getAllByRequestID(uuid,32);
        System.out.println(requestResult.getData());
        for(int id : requestResult.getData()){
            requestDocText25Api.fetch(uuid,id);
            StringResult resultText = requestDocText25Api.getTargetText(uuid,"fr");
            System.out.println(resultText.getData());
        }
        plunetApi.logout(uuid);
    }

    public void testTranslateInputFileFlow() throws DatatypeConfigurationException {
        String uuid = plunetApi.login("******", "*****");
        System.out.println(uuid);
        RequestIN requestInput = new RequestIN();
        requestInput.setBriefDescription("Testing the flow");
        requestInput.setSubject("Test Flow with File");

        IntegerResult requestId = dataRequest30Api.insert2(uuid, requestInput);
        requestIdInput = requestId.getData();
        System.out.println("RequestId=" + requestIdInput);
        dataRequest30Api.addLanguageCombination(uuid, "en", "fr", requestId.getData());
        XMLGregorianCalendar calendarDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2016,03,21,330);
        dataRequest30Api.setDeliveryDate(uuid, calendarDate, requestIdInput);
        String filepath = "/home/ttnd/Idea-Workspace/ISITransalation/ServerSide/src/test/resources/sample.xlf";
        dataRequest30Api.copyDocumentToSourceFolder(uuid, "en", filepath, requestIdInput);
        IntegerResult order = dataRequest30Api.orderRequest(uuid, requestId.getData());
        System.out.println("Order Id =" + order.getData());

        plunetApi.logout(uuid);
    }


    public void testTranslateOutputFileFlow() throws IOException{
        String uuid = plunetApi.login("*****","******");
        RequestResult requestResult = dataRequest30Api.getRequestObject(uuid,34);
        int orderId = requestResult.getData().getOrderID();
        System.out.println("OrderId="+orderId);
        StringArrayResult result = dataOrder30Api.getDocumentsWithinFinalFolder(uuid,orderId);
        System.out.println(result.getData());
        for(String filePath : result.getData()){
            HttpClient client = new HttpClient();
            String importUrl = filePath;

            HttpMethod method = new GetMethod(importUrl);
            // Provide custom retry handler is necessary
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));

            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed: " + method.getStatusLine());
            }
            // Read the response body.
            byte[] responseBody = method.getResponseBody();
            // Deal with the response.
            System.out.println(new String(responseBody));
        }
        plunetApi.logout(uuid);
    }

    public void testGetOrderStatus(){
        String uuid = plunetApi.login("*******","******");
        IntegerResult orderStatusResult = dataOrder30Api.getItemStatus(uuid,"en","fr",66);
        int status = orderStatusResult.getData();
        System.out.println(status);
        plunetApi.logout(uuid);
    }

    public void testXlfGeneration(){
        GenericService genericService = new GenericServiceImpl();
        genericService.generateXlfFromPage(null,null,null,null,null);

    }

//    public void testXlfGroovy(){
//        private String generateXMLFromPage(String pathID, String sourceLanguage, String targetLanguage, ResourceResolver resourceResolver) throws
//        java.lang.Exception {
//            Resource resource = resourceResolver.getResource(pathID)
//            String sourcePath = resource.path
//            boolean isRootPage = !(sourcePath.contains("/${sourceLanguage}/")) && sourcePath.endsWith("/${sourceLanguage}")
//            String targetPath = isRootPage ? StringUtil.getSubString(sourcePath, sourcePath.lastIndexOf("/")) + "/${targetLanguage}" : sourcePath.replace("/" + sourceLanguage + "/", "/" + targetLanguage + "/")
//            final String query = "SELECT * FROM [nt:base] AS nodes WHERE ISDESCENDANTNODE([" + resource.path + "/jcr:content]) "
//            Iterator<Resource> result = resource.resourceResolver.findResources(query, Query.JCR_SQL2);
//            log.info "resource path is " + resource.getPath()
//            def properties = resource.getChild(JcrConstants.JCR_CONTENT)?.adaptTo(ValueMap) ?: [:]
//            def writer = new StringWriter()
//            def xml = new MarkupBuilder(writer)
//            log.info "xml builder started"
//            xml.'root' {
//                "pg-path"("src-lang": "${sourceLanguage}", "target-lang": "${targetLanguage}", "src-path": sourcePath, "target-path": targetPath)
//                "pg-meta" {
//                    "element"(name: JcrConstants.JCR_TITLE, type: "text", title: "Title", "${properties[JcrConstants.JCR_TITLE] ?: ""}")
//                    "element"(name: "subTitle", title: "Subtitle", type: "text", "${properties["subtitle"] ?: ""}")
//                    "element"(name: "navTitle", title: "Navtitle", type: "text", "${properties["navTitle"] ?: ""}")
//                    "element"(name: "description", title: "Description", type: "text", "${properties[JcrConstants.JCR_DESCRIPTION] ?: ""}")
//                    "element"(name: "pageTitle", title: "Pagetitle", type: "text", "${properties["pageTitle"] ?: ""}")
//                }
//                "pg-nodes" {
//                    result.each { Resource currentResource ->
//                        if (currentResource.resourceType in fetchAllKeys()) {
//                            List propertiesToAdd = getCompProperties(currentResource.resourceType)
//                            def valueMap = currentResource.adaptTo(ValueMap) ?: [:]
//                            "pg-node"(nodeName: currentResource.name, "node-resType": currentResource.resourceType, "node-loc": currentResource.path) {
//                                "node-props" {
//                                    valueMap.each { key, value ->
//                                        if (key in propertiesToAdd) {
//                                            "element"(name: key, title: key?.capitalize(), type: "html", value)
//                                        }
//
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//            log.info "xml builder done"
//            return writer.toString()
//        }
//    }
}
