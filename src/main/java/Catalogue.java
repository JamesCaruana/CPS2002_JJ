import java.util.*;

public class Catalogue {
    
    private Vector<Book> bookList = new Vector<Book>();
   
    public Vector<Book> getBookList(){
        return bookList;
    }
    public void addBook(Book b) {
        bookList.add(b);
    }
    
    public void removeBook(Book b) throws Exception{
        for(int i = 0; i < bookList.size(); i++){ //find book
            if(b == bookList.get(i)){
                bookList.remove(i);
                System.out.println("Book removed");
                return;
            }
        }
        throw new BookNotFoundException("ERROR : Book with id "+b.getId()+" was not found");
    }
}