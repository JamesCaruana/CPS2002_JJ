package CPS2002Assignment;

public class InterestedBook {

    private Book b;
    private int queueNo;

    public InterestedBook(Book b, int queueNo) {
        this.b = b;
        this.queueNo = queueNo;
    }

    public Book getInterestedBook() {
        return b;
    }

    public int getQueueNo() {
        return queueNo;
    }
}
