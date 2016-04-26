
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class BookTest {

    	Book b;
	
	@org.junit.Before 
	public void startup() {
		b = new Book("A Game of Thrones", "G.R.R. Martin", "Fantasy", 1996, 1, 1);
	}
    
    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetTitle() throws Exception {
        Assert.assertEquals("A Game of Thrones", b.getTitle());
    }

    @org.junit.Test
    public void testGetAuthor() throws Exception {
        Assert.assertEquals("G.R.R. Martin", b.getAuthor());
    }

    @org.junit.Test
    public void testGetYear() throws Exception {
        Assert.assertEquals(1996, b.getYear());
    }

    @org.junit.Test
    public void testGetEdition() throws Exception {
        Assert.assertEquals(1, b.getEdition());
    }

    @org.junit.Test
    public void testIsBorrowed() throws Exception {
        Assert.assertEquals(false, b.isBorrowed());
    }

    @org.junit.Test
    public void testSetTitle() throws Exception {
        b.setTitle("Treasure Island");
        Assert.assertEquals("Treasure Island", b.getTitle());
    }

    @org.junit.Test
    public void testSetAuthor() throws Exception {
        b.setAuthor("Robert Louis Stevenson");
        Assert.assertEquals("Robert Louis Stevenson", b.getAuthor());
    }

    @org.junit.Test
    public void testSetYear() throws Exception {
        b.setYear(1883);
        Assert.assertEquals(1883, b.getYear());
    }

    @org.junit.Test
    public void testSetEdition() throws Exception {
        b.setEdition(1);
        Assert.assertEquals(1, b.getEdition());
    }

    @org.junit.Test
    public void testSetBookBorrowed() throws Exception {
        b.setBookBorrowed(true);
        Assert.assertEquals(true, b.isBorrowed());
    }
}