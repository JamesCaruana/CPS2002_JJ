/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class maintest {
    
    public maintest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    main myUnit;

    @Before
    public void setUp() {
        myUnit = new main();
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
