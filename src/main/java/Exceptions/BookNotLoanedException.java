
package Exceptions;

public class BookNotLoanedException extends Exception {
    public BookNotLoanedException(String message){
        super(message);
    }
}
