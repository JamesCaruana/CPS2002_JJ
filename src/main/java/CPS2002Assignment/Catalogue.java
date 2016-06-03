package CPS2002Assignment;

import Exceptions.BookNotUniqueException;
import Exceptions.BookNotFoundException;
import java.util.*;

public class Catalogue {
    
    private Catalogue(){}

    private Vector<Book> bookList = new Vector<Book>();
    private static Catalogue caltalogueSingleton = new Catalogue();

    //return Singleton

    public static Catalogue getCaltalogue() {
        return caltalogueSingleton;
    }

    public static void clearCatalogue(){
        caltalogueSingleton = new Catalogue();
    }
    
    public Vector<Book> getAllBooks(){
        return bookList;
    }

    public void addBook(Book b) throws Exception {
        for(int i = 0; i < bookList.size();i++){
            if(bookList.get(i).getId() == b.getId()){
                throw new BookNotUniqueException("Book id already exists");
            }
        }
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
    
    public Vector<Book> searchByTitle(String search) {
        Vector<Book> bookVector = new Vector<Book>();
        for(int count = 0; count < bookList.size(); count++){
            if (bookList.get(count).getTitle().contains(search)) {
                bookVector.add(bookList.get(count));
                System.out.println(bookList.get(count).toString());
            }
        }
        return bookVector;
    }
    
    public Vector<Book> searchByGenre(Genre g) {
        Vector<Book> bookVector = new Vector<Book>();
        for(int count = 0; count < bookList.size(); count++){
            if (bookList.get(count).getGenre().equals(g)) {
                bookVector.add(bookList.get(count));
                System.out.println(bookList.get(count).toString());
            }
        }
        return bookVector;
    }
    
    public Vector<Book> searchByYearOfPublication(int search) {
        Vector<Book> bookVector = new Vector<Book>();
        for(int count = 0; count < bookList.size(); count++){
            if (search == (bookList.get(count).getYear())) {
                bookVector.add(bookList.get(count));
                System.out.println(bookList.get(count).toString());
            }
        }
        return bookVector;
    }
    
}