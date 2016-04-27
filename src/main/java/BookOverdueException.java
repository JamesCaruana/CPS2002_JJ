public class BookOverdueException extends Exception {
    public BookOverdueException() {
    }

    public BookOverdueException(String message) {
        super(message);
    }

    public BookOverdueException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookOverdueException(Throwable cause) {
        super(cause);
    }
}
