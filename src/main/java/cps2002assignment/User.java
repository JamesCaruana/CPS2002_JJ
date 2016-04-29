package cps2002assignment;

import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;

public class User {

    private String name,surname,phoneNumber;
    private int id;
    private Vector<Book> loanedBooks;

    // Create a User
    public User(String name,String surname, int id, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phoneNumber = phoneNumber;
        loanedBooks = new Vector<Book>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getUserID() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Vector<Book> getLoanedBooks(){
        return loanedBooks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setUserID(int id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //Other methods
    public void addLoanedBook(Book b) throws Exception{
        if(loanedBooks.size() >= 3){

            throw new MaximumLoanedBooksException("ERROR : User with id "+id+" has loaned the maximum number of books");

        }
        String format = "dd/MM/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Date now = new Date();
        System.out.println(sdf.format(now));
        Date loan = null;
        long diff;
        int diffDays;

        for(int i = 0; i < loanedBooks.size(); i++){
            loan = loanedBooks.get(i).getLoanDate();
            diff =  now.getTime() - loan.getTime();
            diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            System.out.println("difference between days: " + diffDays);

            if(diffDays > 28){
                throw new BookOverdueException("ERROR : User with ID "+id+" has a book with id "+loanedBooks.get(i).getId()+" which is overdue.");
            }
        }

        b.setLoanDate();

        System.out.println(sdf.format(b.getLoanDate()));
        loanedBooks.add(b);
    }

    public void removeLoanedBook(Book b) throws Exception{
            for(int i = 0; i < loanedBooks.size(); i++){ //find book
                if(b == loanedBooks.get(i)){
                    loanedBooks.get(i).setLoanee(null);
                    loanedBooks.get(i).setLoanDate(null);
                    loanedBooks.remove(i);
                    System.out.println("Book removed");
                    return;
                }
            }
            throw new BookNotFoundException("ERROR : User with id "+ id + " has not loaned book with book id "+b.getId());
        }

}