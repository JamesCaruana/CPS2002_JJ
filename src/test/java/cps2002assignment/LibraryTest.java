package cps2002assignment;

import Exceptions.UserNotUniqueException;
import Exceptions.UserNotFoundException;
import Exceptions.MaximumLoanedBooksException;
import Exceptions.BookNotLoanedException;
import Exceptions.BookNotFoundException;
import Exceptions.BookAlreadyLoanedException;
import org.junit.*;
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
    
    @Test
    public void testLoanBookTo() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        vb.add(b);
        l.addUser(u0);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b,u0);
        Assert.assertEquals(u0.getLoanedBooks(),vb);
        Assert.assertEquals(u0.getLoanedBooks().get(0).getLoanee(),u0);
        Assert.assertNotSame(u0.getLoanedBooks().get(0).getLoanDate(),null);
    }

    @Test (expected = UserNotFoundException.class)
    public void testLoanBookToExp1() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        vb.add(b);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b,u0);

    }

    @Test (expected = BookNotFoundException.class)
    public void testLoanBookToExp2() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        vb.add(b);
        l.addUser(u0);

        l.loanBookTo(b,u0);

    }
    
    @Test
    public void testGetCatalogue()throws Exception{
        Catalogue c = new Catalogue();
        Assert.assertEquals(c.getAllBooks(),l.getCatalogue().getAllBooks());
    }


    @Test (expected = BookAlreadyLoanedException.class)
    public void testLoanBookToExp3() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        vb.add(b);
        l.addUser(u0);
        l.addUser(u1);
        l.getCatalogue().addBook(b);
        l.loanBookTo(b,u0);
        l.loanBookTo(b,u1);

    }


    @Test (expected = MaximumLoanedBooksException.class)
    public void testLoanBookToExp4() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        Book b1 = new Book(1,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        Book b2 = new Book(2,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        Book b3 = new Book(3,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        l.addUser(u0);
        l.getCatalogue().addBook(b);
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.loanBookTo(b,u0);
        l.loanBookTo(b1,u0);
        l.loanBookTo(b2,u0);
        l.loanBookTo(b3,u0);
    }
    
    @Test
    public void testReturnBook() throws Exception{
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b1 = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        Book b2 = new Book(1,1,"A Game Of Thrones" , "George R.R. Martin",Genre.FANTASY,1996,2);

        l.addUser(u0);
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);

        l.loanBookTo(b1,u0);
        l.loanBookTo(b2,u0);

        l.returnBook(b2);
        l.returnBook(b1);

        Assert.assertEquals(u0.getLoanedBooks(),vb);
        Assert.assertEquals(b1.getLoanDate(),null);
        Assert.assertEquals(b1.getLoanee(),null);

    }

    @Test (expected = BookNotFoundException.class)
    public void testReturnBookException1() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        l.returnBook(b);
    }

    @Test(expected = BookNotLoanedException.class)
    public void testReturnBookException2() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        l.getCatalogue().addBook(b);
        l.returnBook(b);
    }
    
    @Test
    public void testNoOfUsers() throws Exception {
        Vector<User> vu = new Vector<User>();

        l.addUser(u0);
        l.addUser(u1);
        Assert.assertEquals(2, l.noOfUsers());
    }
    
}
