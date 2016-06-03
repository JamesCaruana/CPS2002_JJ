package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class EditionFilter implements Filter {
    private int edition;

    public EditionFilter(int edition){
        this.edition = edition;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {

        Vector<Book> booksfound = new Vector<Book>();
        for (Book books : b) {
            if (books.getEdition() == edition) {
                booksfound.add(books);
            }
        }
        return booksfound;
    }

}