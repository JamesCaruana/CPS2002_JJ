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
    
    @Test
    public void testAddUser() throws Exception {
        Vector<User> vu = new Vector<User>();
        vu.add(u0);
        l.addUser(u0);
        Assert.assertEquals(vu,l.getAllUsers());
    }

    @Test (expected = UserNotUniqueException.class)
    public void testUserNotUniqueException() throws Exception {
        User u3 = new User("James", "Caruana", 1,"123423");
        l.addUser(u0);
        l.addUser(u3);
    }
    
    @Test
    public void testRemoveUser() throws Exception {
        Vector<User> vu = new Vector<User>();
        vu.add(u0);
        l.addUser(u0);
        l.addUser(u1);
        l.removeUser(u1);
        Assert.assertEquals(vu,l.getAllUsers());
    }

    @Test (expected = UserNotFoundException.class)
    public void testUserNotFoundException() throws Exception {
        Vector<User> vu = new Vector<User>();
        l.removeUser(u1);
        Assert.assertEquals(vu, l.getAllUsers());
    }
}
