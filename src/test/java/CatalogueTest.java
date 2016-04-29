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
    static Book b0, b1, b2;

    @Before
    public void setUp() throws Exception {
        c = new Catalogue();
        b0 = new Book(0,"A Game Of Thrones" , "George R.R. Martin",Genre.FANTASY,1996,1);
        b1 = new Book(1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        //b2 = new Book(2,"The Hitchhiker's Guide to the Galaxy" , "Douglas Adams",Genre.SCIENCE_FICTION,1979,1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBookList() throws Exception {
        Vector<Book> b =  new Vector<Book>();
        Assert.assertEquals(b, c.getBookList());
    }
    
}