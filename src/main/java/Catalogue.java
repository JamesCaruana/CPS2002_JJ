import java.util.*;

public class Catalogue {
    
    private Vector<Book> bookList = new Vector<Book>();
   
    // Method for adding a new book to vector of Books
    public Vector<Book> getBookList(){
        return bookList;
    }
    public void addBook(Book b) {
        bookList.add(b);
    }
}