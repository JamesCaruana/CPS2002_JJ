
package Tests;

import CPS2002Assignment.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterestedBookTest {
    
    static Book b;
    @Before
    public void setUp() throws Exception {
        b = new Book(2,12, "The Hitchhiker's Guide to the Galaxy" , "Douglas Adams", Genre.SCIENCE_FICTION,1979,1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getInterestedBook() throws Exception {
        InterestedBook ib1 = new InterestedBook(b,99);
        assertEquals(b,ib1.getInterestedBook());
    }

    @Test
    public void getQueueNo() throws Exception {
        InterestedBook ib1 = new InterestedBook(b,99);
        assertEquals(99,ib1.getQueueNo());
    }

}
