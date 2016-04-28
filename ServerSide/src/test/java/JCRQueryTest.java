import org.junit.Test;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.core.TransientRepository;

/**
 * Created by ttnd on 27/4/16.
 */
public class JCRQueryTest {

    @Test
    public void testQuery() throws  Exception{
        // Create a Session
        Repository repository = new TransientRepository();
        repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
        Session session = repository.login(new SimpleCredentials("admin","admin".toCharArray()));



        //Building and Executing the Query
        QueryManager queryManager = session.getWorkspace().getQueryManager();
        String sqlStatement = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/geometrixx/en/company])";
        Query query = queryManager.createQuery(sqlStatement, "JCR-SQL2");
        QueryResult result = query.execute();




        //Doing Something with the nodes returned.. Printing the paths
        NodeIterator iterator = result.getNodes();
        while (iterator.hasNext()) {
            System.out.println(((Node) iterator.next()).getPath());
        }
    }
}
