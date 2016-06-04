package Tests;

import CPS2002Assignment.Genre;
import CPS2002Assignment.Book;
import CPS2002Assignment.Catalogue;
import Exceptions.BookNotUniqueException;
import Exceptions.BookNotFoundException;
import Filters.*;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.*;

public class CatalogueTest {

    static Catalogue c;
    static Book b1, b2, b3;

    @Before
    public void setUp() throws Exception {
        Catalogue.clearCatalogue();
        c = Catalogue.getCaltalogue(); //singleton update
        b1 = new Book(1, 0, "A Clash Of Kings" , "George R.R. Martin", Genre.FANTASY, 1999, 1);
        b2 = new Book(2, 1, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, 1979, 1);
        b3 = new Book(3, 2, "A Game Of Thrones" , "George R.R. Martin", Genre.FANTASY, 1996, 2);
    }

    @After
    public void tearDown() throws Exception {
        Catalogue.clearCatalogue();
    }

    @Test
    public void testGetBookList() throws Exception {
        Vector<Book> b =  new Vector<Book>();
        Assert.assertEquals(b, c.getAllBooks());
    }

    @Test
    public void testAddBook() throws Exception {
        Vector<Book> vb = new Vector<Book>();
        vb.add(b1);
        c.addBook(b1);
        Assert.assertEquals(vb,c.getAllBooks());
    }
    
    @Test (expected =  BookNotUniqueException.class)
    public void testThrowsBookNotUniqueException() throws Exception {
        Book b4 = new Book(2,2,"A Game Of Thrones" , "George R.R. Martin",Genre.FANTASY,1996,2);
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b4);
    }
    
    @Test
    public void testRemoveBook() throws Exception {

        Vector<Book>vb = new Vector<Book>();

        vb.add(b1);
        c.addBook(b1);
        c.addBook(b2);
        c.removeBook(b2);
        Assert.assertEquals(vb,c.getAllBooks());

    }
    
    @Test (expected = BookNotFoundException.class)
    public void testThrowBookNotFoundException() throws Exception {

        Vector<Book>vb = new Vector<Book>();

        c.addBook(b2);

        c.removeBook(b1);
        Assert.assertEquals(vb,c.getAllBooks());

    }
    
    @Test
    public void testFilterAuthor() throws Exception{
        Vector<Book> vb = new Vector<Book>();
        vb.add(b1);
        vb.add(b3);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);

        Assert.assertEquals(vb,c.search(new AuthorFilter("George R.R. Martin")));
    }
    
    @Test
    public void testFilterEdition() throws Exception{
        Vector<Book>vb = new Vector<Book>();
        vb.add(b1);
        vb.add(b2);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);


        Assert.assertEquals(vb,c.search(new EditionFilter(1)));
    }
    
    @Test
    public void testFilterGenre() throws Exception{
        Vector<Book>vb = new Vector<Book>();
        vb.add(b1);
        vb.add(b3);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);

        Assert.assertEquals(vb,c.search(new GenreFilter(Genre.FANTASY)));
    }
    
    @Test
    public void testSearchByTitle() throws Exception {
        Vector<Book> vb = new Vector<Book>();
        vb.add(b1);
        vb.add(b3);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        Assert.assertEquals(vb,c.searchByTitle("A"));
    }
    
    @Test
    public void testSearchByGenre() throws Exception {
        Vector<Book> vb = new Vector<Book>();
        vb.add(b1);
        vb.add(b3);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        Assert.assertEquals(vb,c.searchByGenre(Genre.FANTASY));
    }
    
    @Test
    public void testSearchByYearOfPublication() throws Exception {
        Vector<Book> vb = new Vector<Book>();
        vb.add(b1);

        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        Assert.assertEquals(vb,c.searchByYearOfPublication(1999));
    }
    
}