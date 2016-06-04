package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class NotFilter implements Filter {
    private Filter filter;

    public NotFilter(Filter filter){
        this.filter = filter;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {
        Vector<Book> notVector = filter.meetFilter(b);
        Vector<Book> returnVector = new Vector<Book>();
        for (Book book : b) {
            if(!notVector.contains(book)){
                returnVector.add(book);
            }
        }
        return returnVector;
    }
}