package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class TitleFilter implements Filter {
    private String title;

    public TitleFilter(String title){
        this.title = title;
        this.title = this.title.toLowerCase();
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {

        Vector<Book> booksfound = new Vector<Book>();
        for (Book books : b) {
            if (books.getTitle().toLowerCase().contains(title)) {
                booksfound.add(books);
            }
        }
        return booksfound;
    }
}
