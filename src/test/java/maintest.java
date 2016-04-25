
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Main myUnit;

    @Before
    public void setUp() {
        myUnit = new Main();
    }
    
    @After
    public void tearDown() {
        myUnit = null;
    }

    @Test
    public void testConcatenate() {
        
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo", result);
    }
    
    @Test
    public void testConcatenate2() {
        
        String result = myUnit.concatenate("one", "three");
        assertEquals("onethree", result);
    }
}
