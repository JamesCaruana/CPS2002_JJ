import org.junit.*;

import java.util.Vector;

import java.util.Vector;

import static org.junit.Assert.*;

public class UserTest {
   
    User u1;
    @Before
    public void startup() throws Exception {
        u1 = new User("Name1","Surname1",1001,"99999999");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Name1",u1.getName());
    }

    @Test
    public void getSurname() throws Exception {
        Assert.assertEquals("Surname1",u1.getSurname());
    }

    @Test
    public void getUserID() throws Exception {
        Assert.assertEquals("Surname1",u1.getSurname());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        Assert.assertEquals("99999999",u1.getPhoneNumber());
    }

    @Test
    public void setName() throws Exception {
        u1.setName("Name2");
        Assert.assertEquals("Name2",u1.getName());
    }

    @Test
    public void setSurname() throws Exception {
        u1.setSurname("Surname2");
        Assert.assertEquals("Surname2",u1.getSurname());
    }

    @Test
    public void setUserID() throws Exception {
        u1.setUserID(5);
        Assert.assertEquals(5,u1.getUserID());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        u1.setPhoneNumber("5");
        Assert.assertEquals("5",u1.getPhoneNumber());
    }
    
}