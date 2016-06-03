package cps2002assignment;

import Exceptions.MaximumLoanedBooksException;
import Exceptions.BookOverdueException;
import Exceptions.BookNotFoundException;
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
    public void getLoanedBooks() throws Exception {
        Vector<Book>b = new Vector<Book>();
        Assert.assertEquals(b,u1.getLoanedBooks());
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

    @Test
    public void addLoanedBook() throws Exception {
        Book b = new Book(0,2,"A Game of Thrones", "G.R.R. Martin", Genre.FANTASY, 1996, 1);
        User u = new User("Name1","Surname1",1001,"99999999");
        Vector<Book>vb = new Vector<Book>();
        vb.add(b);
        u.addLoanedBook(b);
        Assert.assertEquals(vb,u.getLoanedBooks());
    }

    @Test (expected = MaximumLoanedBooksException.class)
    public void throwsMaximumLoanedBooksException() throws Exception{
        User u = new User("Name1","Surname1",1001,"99999999");
        Book b = new Book(0,2,"A Game of Thrones", "G.R.R. Martin", Genre.FANTASY, 1996, 1);

        u.addLoanedBook(b);
        u.addLoanedBook(b);
        u.addLoanedBook(b);
        u.addLoanedBook(b);

    }

    @Test (expected = BookOverdueException.class)
    public void throwsBookOverdueException() throws Exception{
        User u = new User("Name1","Surname1",1001,"99999999");
        Book b = new Book(0,2,"A Game of Thrones", "G.R.R. Martin", Genre.FANTASY, 1996, 1);

        u.addLoanedBook(b);
        u.addLoanedBook(b);
        b.setLoanDate("20/03/2016","03:00 AM");
        u.addLoanedBook(b);

    }

    @Test
   public void removeLoanedBook() throws Exception {
        User u = new User("Name1","Surname1",1001,"99999999");
        Book b = new Book(0,1,"A Game of Thrones", "G.R.R. Martin",Genre.FANTASY, 1996, 1);

        Vector<Book>vb = new Vector<Book>();
        vb.add(b);

        u.addLoanedBook(b);
        u.addLoanedBook(b);

        u.removeLoanedBook(b);
        Assert.assertEquals(vb,u.getLoanedBooks());

    }

    @Test (expected = BookNotFoundException.class)
    public void throwsBookNotFoundException() throws Exception{
        User u = new User("Name1","Surname1",1001,"99999999");
        Book b = new Book(0,2,"A Game of Thrones", "G.R.R. Martin", Genre.FANTASY, 1996, 1);
        Book b2 = new Book(0,5,"A Game of Thrones", "G.R.R. Martin", Genre.FANTASY, 1996, 1);
        u.addLoanedBook(b);
        u.removeLoanedBook(b2);
    }

}