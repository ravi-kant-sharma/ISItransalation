import integration.api.PlunetAPI;
import integration.api.PlunetAPIService;
import junit.framework.TestCase;

/**
 * Created by ttnd on 19/4/16.
 */
public class PlunetAPITest extends TestCase{
    PlunetAPIService plunetService;
    PlunetAPI plunetApi;

    public PlunetAPITest(){
        plunetService = new PlunetAPIService();
        plunetApi = plunetService.getPlunetAPIPort();
    }


    public void testLogin(){
        String uuid = plunetApi.login("******","*****");
        System.out.println(uuid);
        assertNotNull(uuid);
    }

    public void testLogout(){

    }
}
