package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class OrFilter implements Filter {
    private Filter filter1, filter2;

    public OrFilter(Filter filter1, Filter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {
        Vector<Book> lhs = filter1.meetFilter(b);
        Vector<Book> rhs = filter2.meetFilter(b);

        for (Book book : rhs) {
            if (!lhs.contains(book)) {
                lhs.add(book);
            }
        }
        return lhs;
    }
}