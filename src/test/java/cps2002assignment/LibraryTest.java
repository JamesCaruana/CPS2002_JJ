package cps2002assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.*;

public class LibraryTest {
    
    static Library l;
    static User u0, u1;

    @Before
    public void setUp() throws Exception {
        l = new Library();
        u0 = new User("John", "Cena", 1, "515-808-2362");
        u1 = new User("Leslie", "Carabott", 26, "79230696");
    }

    @After
    public void tearDown() throws Exception {
        l = null;
    }

    @Test
    public void testGetAllUsers() throws Exception {
        Vector<User> vu = new Vector<User>();
        Assert.assertEquals(vu,l.getAllUsers());
    }
}
