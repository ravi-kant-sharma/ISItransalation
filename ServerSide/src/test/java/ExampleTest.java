import com.day.cq.wcm.api.Page;
import impl.GenericServiceImpl;
import io.wcm.testing.mock.aem.junit.AemContext;
import junit.framework.TestCase;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.testing.resourceresolver.MockResourceResolver;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import service.GenericService;

import javax.jcr.query.Query;
import java.io.File;
import java.util.Iterator;

/**
 * Created by ttnd on 26/4/16.
 */
public class ExampleTest{

    @Rule
    public final AemContext context = new AemContext(ResourceResolverType.RESOURCERESOLVER_MOCK);

    @Before
    public void setUp() throws Exception {
        context.load().json("/sample-data.json", "/content/sample/en");
        context.load().json("/company-data.json","/content/geometrixx/en/company");
    }


    @Test
    public void testSomething() {
        ResourceResolver resourceResolver = context.resourceResolver();
        Resource resource = resourceResolver.getResource("/content/geometrixx/en/company");
//        final String query = "SELECT * FROM [nt:base] AS nodes WHERE ISDESCENDANTNODE([" + resource.getPath()+ "/jcr:content]) ";
//        Iterator<Resource> result = resource.getResourceResolver().findResources(query, Query.JCR_SQL2);
//        System.out.println("Result="+result);
//        Page page = resource.adaptTo(Page.class);
//        System.out.println(page.getPath());
//        System.out.println(page.getTitle());
//        System.out.println(resource.getResourceType());
//        ValueMap map = resource.getValueMap();
//        System.out.println(map.get("jcr:primaryType"));
//         Resource r =  page.getContentResource();
//        System.out.println(r.getResourceType());
//        ValueMap m = r.getValueMap();
//        System.out.println(m.get("jcr:primaryType"));
        Iterable<Resource> children = resource.getChildren();
//        System.out.println(children);
        for(Resource s : children){
            System.out.println("children="+s.getName());
            Iterable<Resource> children1 = s.getChildren();

            for(Resource s1 : children1){
                System.out.println("children1-Name="+s1.getName());
                System.out.println("children1-ResourceType="+s1.getResourceType());
                System.out.println("children1-Path="+s1.getPath());
            }
        }
        // further testing
    }

    @Test
    public void testXlfGeneration(){
        GenericService service = new GenericServiceImpl();
        ResourceResolver resourceResolver = context.resourceResolver();
        service.generateXlfFromPage("/content/geometrixx/en/company","","en","fr",resourceResolver);
    }

    @Test
    public void textPageGenerationFromXlf(){

        GenericService service = new GenericServiceImpl();
        service.generatePageFromXlf("/home/ttnd/Idea-Workspace/ISITransalation/ServerSide/src/test/resources/translated_xlf.xlf");
    }


}
