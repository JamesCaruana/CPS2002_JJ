/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */

public class Book {
    
    private String title;
    private String author;
    private String genre;
    private int year;
    private int edition;
    private int bId;
    private boolean bookBorrowed;

    // Create a Book
    public Book(String newTitle, String newAuthor, String newGenre, int newYear, int newEdition, int newBid){
        title = newTitle;
        author = newAuthor;
        genre = newGenre;
        year = newYear;
        edition = newEdition;
        bId = newBid;
        bookBorrowed = false;
    }
    
    // getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getEdition() {
        return edition;
    }
    
    public int getBid() {
        return bId;
    }

    public boolean isBorrowed() {
        return bookBorrowed;
    }


    // setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setEdition(int edition) {
        this.edition = edition;
    }
    
    public void setB_ID(int B_ID) {
        this.bId = B_ID;
    }

    public void setBookBorrowed(boolean bookBorrowed){
        this.bookBorrowed = bookBorrowed;
    }

    
    @Override
    public String toString() {
        return ("Title of Book: " +         this.getTitle() +
                "\nAuthor of Book: " +      this.getAuthor() +
                "\nGenre of Book: " +       this.getGenre() +
                "\nYear of Publication: " + this.getYear() +
                "\nEdition: " +             this.getEdition() +
                "\nID of Book: " +          this.getBid());
    }
}
