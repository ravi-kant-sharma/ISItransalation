package service;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * Created by ttnd on 25/4/16.
 */
public interface GenericService {

    void generateXlfFromPage(String pathID, String depth,String sourceLanguage, String targetLanguage, ResourceResolver resourceResolver);

    void generatePageFromXlf(String filePath);
}
