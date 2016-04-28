import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    private int isbn;
    private long id;
    private String title;
    private String author;
    private Genre genre;
    private int year;
    private int edition;
    private Date loanDate;
    private User loanee;

    private static long bookIdCounter = 0;

    // Create a Book
    public Book(int isbn ,String title, String author, Genre genre, int year, int edition){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.edition = edition;
        this.isbn = isbn;
        this.loanDate = null;
        this.loanee = null;
        this.id = bookIdCounter;
        bookIdCounter++;
    }
    
    // getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Genre getGenre() {
        return genre;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getEdition() {
        return edition;
    }
    
    public int getISBN() {
        return isbn;
    }

    public User getLoanee() {
        return loanee;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public long getId() {
        return id;
    }


    // setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setEdition(int edition) {
        this.edition = edition;
    }
    
    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    public void setLoanee(User loanee) {
        this.loanee = loanee;
    }

    public void setLoanDate(String date , String time) throws Exception{
        String format = "dd/MM/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try{
            loanDate = sdf.parse(date + " " + time);   //parse loanDate
        }catch(Exception e){
            throw e;
        }
    }

    public void setLoanDate(){
        loanDate = new Date();
    }

}
