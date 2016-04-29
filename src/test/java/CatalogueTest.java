import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.*;

/**
 * Created by James on 29/04/2016.
 */
public class CatalogueTest {

    static Catalogue c;
    
    
    @Before
    public void setUp() throws Exception {
        c = new Catalogue();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBookList() throws Exception {
        Vector<Book> b = new Vector<Book>();
        Assert.assertEquals(b, c.getBookList());
    }
    
}