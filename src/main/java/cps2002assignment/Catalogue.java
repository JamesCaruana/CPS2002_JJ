package cps2002assignment;

import java.util.*;

public class Catalogue {
    
    private Vector<Book> bookList = new Vector<Book>();
   
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
    
    Vector<Book> searchByTitle(String search) {
        Vector<Book> bookVector = new Vector<Book>();
        for(int count = 0; count < bookList.size(); count++){
            if (bookList.get(count).getTitle().contains(search)) {
                bookVector.add(bookList.get(count));
                System.out.println(bookList.get(count).toString());
            }
        }
        return bookVector;
    }
    
    Vector<Book> searchByGenre(Genre g) {
        Vector<Book> bookVector = new Vector<Book>();
        for(int count = 0; count < bookList.size(); count++){
            if (bookList.get(count).getGenre().equals(g)) {
                bookVector.add(bookList.get(count));
                System.out.println(bookList.get(count).toString());
            }
        }
        return bookVector;
    }
}