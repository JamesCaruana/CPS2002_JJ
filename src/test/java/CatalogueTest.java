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
    
    @Test
    public void testAddBook() throws Exception {
        Vector<Book> vb = new Vector<Book>();
        Book b0 = new Book(0,"A Game Of Thrones" , "George R.R. Martin",Genre.FANTASY,1996,1);
        vb.add(b0);
        c.addBook(b0);
        Assert.assertEquals(vb,c.getBookList());
    }
    
}