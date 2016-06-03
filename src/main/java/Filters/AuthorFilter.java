package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class AuthorFilter implements Filter{

    private String author;

    public AuthorFilter(String author){
        this.author = author;
        this.author = this.author.toLowerCase(); //make author not case sensitive by turning it into lower case
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {

        Vector<Book> booksfound = new Vector<Book>();
        for (Book books : b) {
            if (books.getAuthor().toLowerCase().contains(author)) {
                booksfound.add(books);
            }
        }
        return booksfound;
    }
}
