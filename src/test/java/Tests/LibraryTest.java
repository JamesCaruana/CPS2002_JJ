package Tests;

import CPS2002Assignment.*;
import Exceptions.*;
import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.*;

public class LibraryTest {

    static Library l;
    static User u0, u1, u2;

    @Before
    public void setUp() throws Exception {
        l = new Library();
        l.resetCatalogue();
        u0 = new User("John", "Cena", 1, "515-808-2362");
        u1 = new User("Leslie", "Carabott", 26, "79230696");
        u2 = new User("Nathan", "Drake", 91, "88888889");
    }

    @After
    public void tearDown() throws Exception {
        l = null;
    }

    @Test
    public void testGetAllUsers() throws Exception {
        Vector<User> vu = new Vector<User>();
        assertEquals(vu, l.getAllUsers());
    }

    @Test
    public void testAddUser() throws Exception {
        Vector<User> vu = new Vector<User>();
        vu.add(u0);
        l.addUser(u0);
        assertEquals(vu, l.getAllUsers());
    }

    @Test(expected = UserNotUniqueException.class)
    public void testUserNotUniqueException() throws Exception {
        User u3 = new User("James", "Caruana", 1, "123423");
        l.addUser(u0);
        l.addUser(u3);
    }

    @Test
    public void testGetCatalogue() throws Exception {
        Catalogue.clearCatalogue();
        Catalogue c = Catalogue.getCaltalogue();
        assertEquals(c.getAllBooks(), l.getCatalogue().getAllBooks());
    }

    @Test
    public void testRemoveUser() throws Exception {
        Vector<User> vu = new Vector<User>();
        vu.add(u0);
        l.addUser(u0);
        l.addUser(u1);
        l.removeUser(u1);
        assertEquals(vu, l.getAllUsers());
    }

    @Test(expected = UserNotFoundException.class)
    public void testUserNotFoundException() throws Exception {
        Vector<User> vu = new Vector<User>();
        l.removeUser(u1);
        assertEquals(vu, l.getAllUsers());
    }

    @Test
    public void testLoanBookTo() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        vb.add(b);
        l.addUser(u0);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b, u0);
        Assert.assertEquals(u0.getLoanedBooks(), vb);
        Assert.assertEquals(u0.getLoanedBooks().get(0).getLoanee(), u0);
        Assert.assertNotSame(u0.getLoanedBooks().get(0).getLoanDate(), null);
    }

    @Test(expected = UserNotFoundException.class)
    public void testLoanBookToExp1() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        vb.add(b);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b, u0);

    }

    @Test(expected = BookNotFoundException.class)
    public void testLoanBookToExp2() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        vb.add(b);
        l.addUser(u0);

        l.loanBookTo(b, u0);

    }

    @Test(expected = BookAlreadyLoanedException.class)
    public void testLoanBookToExp3() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        vb.add(b);
        l.addUser(u0);
        l.addUser(u1);
        l.getCatalogue().addBook(b);
        l.loanBookTo(b, u0);
        l.loanBookTo(b, u1);

    }

    @Test(expected = MaximumLoanedBooksException.class)
    public void testLoanBookToExp4() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b1 = new Book(1, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b2 = new Book(2, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b3 = new Book(3, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        l.addUser(u0);
        l.getCatalogue().addBook(b);
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.loanBookTo(b, u0);
        l.loanBookTo(b1, u0);
        l.loanBookTo(b2, u0);
        l.loanBookTo(b3, u0);
    }

    @Test
    public void testReturnBook() throws Exception {
        Vector<Book> vb = new Vector<Book>(); //simulate user loaned books
        Book b1 = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b2 = new Book(1, 1, "A Game Of Thrones", "George R.R. Martin", Genre.FANTASY, 1996, 2);

        l.addUser(u0);
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);

        l.loanBookTo(b1, u0);
        l.loanBookTo(b2, u0);

        l.returnBook(b2);
        l.returnBook(b1);

        Assert.assertEquals(u0.getLoanedBooks(), vb);
        assertEquals(b1.getLoanDate(), null);
        assertEquals(b1.getLoanee(), null);

    }

    @Test(expected = BookNotFoundException.class)
    public void testReturnBookException1() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        l.returnBook(b);
    }

    @Test(expected = BookNotLoanedException.class)
    public void testReturnBookException2() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        l.getCatalogue().addBook(b);
        l.returnBook(b);
    }

    @Test
    public void testNoOfUsers() throws Exception {
        Vector<User> vu = new Vector<User>();

        l.addUser(u0);
        l.addUser(u1);
        assertEquals(2, l.noOfUsers());
    }

    /**
     * *** Observer Tests ****
     */
    @Test
    public void testAddingObserver() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        l.addUser(u0);
        l.addUser(u1);
        l.addUser(u2);
        l.getCatalogue().addBook(b);

        try {
            l.loanBookTo(b, u0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            l.loanBookTo(b, u1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            l.loanBookTo(b, u2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(2, b.getObserverVector().size());
        assertEquals(true, b.getObserverVector().contains(u1));
        assertEquals(true, b.getObserverVector().contains(u2));

    }

    @Test(expected = ObserverAdditionException.class)
    public void testAddingObserverException1() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b2 = new Book(2, 1, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, 1979, 1);
        Book b3 = new Book(3, 2, "A Game Of Thrones", "George R.R. Martin", Genre.FANTASY, 1996, 2);

        l.addUser(u0);
        l.addUser(u1);
        l.getCatalogue().addBook(b);
        l.getCatalogue().addBook(b2);

        l.loanBookTo(b, u0);
        l.loanBookTo(b2, u1);

        b.setLoanDate("20/03/2014", "09:00 AM");

        l.loanBookTo(b2, u0);
    }

    @Test(expected = ObserverAdditionException.class)
    public void testAddingObserverException2() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b2 = new Book(2, 12, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, 1979, 1);
        Book b3 = new Book(3, 2, "A Game Of Thrones", "George R.R. Martin", Genre.FANTASY, 1996, 2);
        Book b4 = new Book(4, 991, "Treasure Island", "Robert Louis Stevenson", Genre.ADVENTURE_FICTION, 1883, 1);

        l.addUser(u0);
        l.addUser(u1);
        l.getCatalogue().addBook(b);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.getCatalogue().addBook(b4);

        l.loanBookTo(b, u0);
        l.loanBookTo(b2, u0);
        l.loanBookTo(b3, u0);

        l.loanBookTo(b4, u1);

        l.loanBookTo(b4, u0);
    }

    @Test
    public void testLoanToNextUser1() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);

        l.addUser(u0);
        l.addUser(u1);
        l.addUser(u2);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b, u0);
        try {
            l.loanBookTo(b, u1);
        } catch (Exception e) {

        }
        try {
            l.loanBookTo(b, u2);
        } catch (Exception e) {

        }

        l.returnBook(b);

        assertEquals(b.getLoanee(), u1);
    }

    @Test
    public void testLoanToNextUser2() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);

        l.addUser(u0);
        l.addUser(u1);
        l.addUser(u2);
        l.getCatalogue().addBook(b);

        l.loanBookTo(b, u0);
        try {
            l.loanBookTo(b, u1);
        } catch (Exception e) {

        }
        try {
            l.loanBookTo(b, u2);
        } catch (Exception e) {

        }

        l.returnBook(b);
        l.returnBook(b);

        assertEquals(false, u0.getLoanedBooks().contains(b));
        assertEquals(false, u1.getLoanedBooks().contains(b));
        assertEquals(true, u2.getLoanedBooks().contains(b));
        assertEquals(b.getLoanee(), u2);

    }

    @Test(expected = MaximumLoanedBooksException.class)
    public void testLoanToNextUserException() throws Exception {
        Book b = new Book(0, 1, "A Clash Of Kings", "George R.R. Martin", Genre.FANTASY, 1999, 1);
        Book b2 = new Book(2, 12, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, 1979, 1);
        Book b3 = new Book(3, 2, "A Game Of Thrones", "George R.R. Martin", Genre.FANTASY, 1996, 2);
        Book b4 = new Book(4, 991, "Treasure Island", "Robert Louis Stevenson", Genre.ADVENTURE_FICTION, 1883, 1);

        l.addUser(u0);
        l.addUser(u1);
        l.getCatalogue().addBook(b);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.getCatalogue().addBook(b4);

        l.loanBookTo(b, u0);
        try {
            l.loanBookTo(b, u1);
        } catch (Exception e) {

        }
        try {
            l.loanBookTo(b2, u1);
            l.loanBookTo(b3, u1);
            l.loanBookTo(b4, u1);
        } catch (Exception e) {
        }

        l.returnBook(b);

    }

}
