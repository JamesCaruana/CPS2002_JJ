
package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public class AndFilter implements Filter {

    private Filter filter1,filter2;

    public AndFilter(Filter filter1 , Filter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public Vector<Book> meetFilter(Vector<Book> b) {
        Vector<Book> lhs = filter1.meetFilter(b);
        return filter2.meetFilter(lhs);
    }
}
