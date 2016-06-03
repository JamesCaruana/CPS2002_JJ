package Tests;

import CPS2002Assignment.Genre;
import CPS2002Assignment.Book;
import CPS2002Assignment.User;
import org.junit.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;

public class BookTest {
    static Book b;

    @BeforeClass
    public static void startup() throws Exception {
        b = new Book(0,0,"A Game Of Thrones" , "George R.R. Martin",Genre.FANTASY,1996,1);
    }

    @Test
    public void getTitle() throws Exception {
        Assert.assertEquals("A Game Of Thrones",b.getTitle());
    }

    @Test
    public void getAuthor() throws Exception {
        Assert.assertEquals("George R.R. Martin",b.getAuthor());
    }

    @Test
    public void getYear() throws Exception {
        Assert.assertEquals(1996,b.getYear());
    }

    @Test
    public void getEdition() throws Exception {
        Assert.assertEquals(1,b.getEdition());
    }

    @Test
    public void getISBN() throws Exception {
        Assert.assertEquals(0,b.getISBN());
    }

    @Test
    public void getLoanee() throws Exception {
        User u = new User("name","surname",0,"0");
        b.setLoanee(u);
        Assert.assertEquals(u,b.getLoanee());
    }

    @Test
    public void getLoanDate() throws Exception {
        b.setLoanDate("29/03/2016","03:00 AM");
        Date d;
        String format = "dd/MM/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date  = "29/03/2016";
        String time = "03:00 AM";
        d = sdf.parse(date + " " + time);

        Assert.assertEquals(d,b.getLoanDate());
    }

    @Test
    public void getId() throws Exception {
        Assert.assertEquals(0,b.getId());
    }

    @Test
    public void getGenre() throws Exception {
        Assert.assertEquals(Genre.FANTASY,b.getGenre());
    }

    @Test
    public void setTitle() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setTitle("Test");
        Assert.assertEquals("Test",b.getTitle());
    }

    @Test
    public void setAuthor() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setAuthor("Test");
        Assert.assertEquals("Test",b.getAuthor());
    }

    @Test
    public void setYear() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setYear(2000);
        Assert.assertEquals(2000,b.getYear());
    }

    @Test
    public void setEdition() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setEdition(2);
        Assert.assertEquals(2,b.getEdition());
    }

    @Test
    public void setISBN() throws Exception {
        Book b = new Book(0,0,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setISBN(9);
        Assert.assertEquals(9,b.getISBN());
    }

    @Test
    public void setGenre() throws Exception {
        Book b = new Book(0,0,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setGenre(Genre.DRAMA);
        Assert.assertEquals(Genre.DRAMA,b.getGenre());
    }

    @Test
    public void setLoanee() throws Exception {
        Book b = new Book(0,0,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        User u = new User("Name1","Surname1",1001,"99999999");
        b.setLoanee(u);
        Assert.assertEquals(u,b.getLoanee());
    }

    @Test
    public void setLoanDate() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        String date  = "29/03/2016";
        String time = "03:00 AM";
        b.setLoanDate(date,time);
        String format = "dd/MM/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = sdf.parse(date + " " + time);

        Assert.assertEquals(d,b.getLoanDate());
    }

    @Test (expected = java.text.ParseException.class)
    public void throwsParseException() throws Exception{
        String date  = "29/03+2016";
        String time = "03:00 AM";
        b.setLoanDate(date,time);
    }

    @Test
    public void setLoanDate1() throws Exception {
        Book b = new Book(0,1,"A Clash Of Kings" , "George R.R. Martin",Genre.FANTASY,1999,1);
        b.setLoanDate();
        Date d = new Date();
        Assert.assertEquals(d,b.getLoanDate());
    }

    @Test
    public void setLoanDate2() throws Exception {
        b.setLoanDate(null);
        Assert.assertEquals(null,b.getLoanDate());
    }

}