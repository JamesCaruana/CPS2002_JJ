package Filters;

import CPS2002Assignment.Book;

import java.util.Vector;

public interface Filter {

    Vector<Book> meetFilter(Vector<Book> b);

}
