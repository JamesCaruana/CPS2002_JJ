package Filters;

import CPS2002Assignment.Book;
import CPS2002Assignment.Genre;

import java.util.Vector;

public class GenreFilter implements Filter {
    private Genre genre;

    public GenreFilter(Genre genre){
        this.genre = genre;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {

        Vector<Book> booksfound = new Vector<Book>();
        for (Book books : b) {
            if (books.getGenre().equals(genre)) {
                booksfound.add(books);
            }
        }
        return booksfound;
    }
}
