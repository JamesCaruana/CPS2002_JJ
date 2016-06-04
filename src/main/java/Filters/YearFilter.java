package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class YearFilter implements Filter {
    private int year;

    public YearFilter(int year){
        this.year = year;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {

        Vector<Book> booksfound = new Vector<Book>();
        for (Book books : b) {
            if (books.getYear() == year) {
                booksfound.add(books);
            }
        }
        return booksfound;
    }

}