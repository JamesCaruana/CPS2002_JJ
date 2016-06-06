package CPS2002Assignment;

import Exceptions.*;

import java.util.*;

public class Library {

    private Vector<User> userVector = new Vector<User>();
    private Catalogue c = Catalogue.getCaltalogue();

    public void addUser(User u) throws Exception {
        for (int i = 0; i < userVector.size(); i++) {
            if (userVector.get(i).getUserID() == u.getUserID()) {
                throw new UserNotUniqueException("User id already exists");
            }
        }
        userVector.add(u);
    }

    public void removeUser(User u) throws Exception {
        for (int i = 0; i < userVector.size(); i++) { //find user
            if (u == userVector.get(i)) {
                userVector.remove(i);
                System.out.println("User removed");
                return;
            }
        }
        throw new UserNotFoundException("User with id " + u.getUserID() + " was not found");
    }

    public void loanBookTo(Book b, User u) throws Exception {

        boolean foundUser = false;
        boolean foundBook = false;

        for (int i = 0; i < userVector.size(); i++) { //check if user is in system
            if (u == userVector.get(i)) {
                foundUser = true;
                break;
            }
        }

        if (!foundUser) {
            throw new UserNotFoundException("User with id " + u.getUserID() + " was not found");
        }

        for (int i = 0; i < c.getAllBooks().size(); i++) { //check if book is in system
            if (b == c.getAllBooks().get(i)) {
                foundBook = true;
                break;
            }
        }

        if (!foundBook) {
            throw new BookNotFoundException("Book with id " + b.getId() + " was not found");
        }

        if (b.getLoanee() != null) { // if there is a loanee
            //Exception will still be thrown but user will be added to observer list -->OBSERVER ADDITION

            //check if add is possible
            Date now = new Date();
            Date loan = null;
            long diff;
            int diffDays;

            for (int i = 0; i < u.getLoanedBooks().size(); i++) {
                loan = u.getLoanedBooks().get(i).getLoanDate();
                diff = now.getTime() - loan.getTime();
                diffDays = (int) (diff / (24 * 60 * 60 * 1000));

                if (diffDays > 28) {
                    throw new ObserverAdditionException("ERROR : User with ID " + u.getUserID() + " has a book with id " + u.getLoanedBooks().get(i).getId() + " which is overdue.");
                }
            }

            if (u.getLoanedBooks().size() >= 3) {
                throw new ObserverAdditionException("ERROR : User with id " + u.getUserID() + " has loaned the maximum number of books");
            }

            //observer addition ok
            b.addObserver(u); //add observer to vector
            System.out.println("Added user to observer list !");
            throw new BookAlreadyLoanedException("Book with id " + b.getId() + " is loaned");
        }

        try {
            u.addLoanedBook(b); // can throw BookOverdue & MaximumLoanedBooks exceptions
            b.setLoanee(u);
            System.out.println("Loaned book with id " + b.getId() + " to user with id " + u.getUserID());
        } catch (Exception e) {
            throw e;
        }

    }

    public void returnBook(Book b) throws Exception {
        boolean foundBook = false;
        for (int i = 0; i < c.getAllBooks().size(); i++) { //check if book is in system
            if (b == c.getAllBooks().get(i)) {
                foundBook = true;
                break;
            }
        }

        if (!foundBook) {
            throw new BookNotFoundException("Book with id " + b.getId() + " was not found");
        }

        if (b.getLoanee() == null) {
            throw new BookNotLoanedException("Book with id " + b.getId() + " was not loaned");
        }

        b.getLoanee().removeLoanedBook(b);

        //try to loan to next user
        boolean flag = false;
        while (b.getObserverVector().size() > 0) { //if at least one observer, keep looping until no more observers or a successful loan. Most recent exception will be thrown
            try {
                loanToNextUser(b);
                flag = true;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (b.getObserverVector().size() == 0) { //if no more observers throw last exception
                    throw e;
                }
            }
            if (flag) { //if no catches occurred
                break; // loan ok break out of loop
            }
        }
    }

    public int noOfUsers() {
        return userVector.size();
    }

    public Vector<User> getAllUsers() {
        return userVector;
    }

    public Catalogue getCatalogue() {
        return c;
    }

    public void resetCatalogue() {
        Catalogue.clearCatalogue();
        c = Catalogue.getCaltalogue();
    }

    public void loanToNextUser(Book b) throws Exception {
        User u = b.notifyObservers(); // returned user is next loanee
        try {
            loanBookTo(b, u);
            b.removeObserver(u);
        } catch (Exception e) { //if an exception is thrown by loanBookTo , remove observer and rethrow exception
            System.out.println("Cannot loan book to user with id : " + u.getUserID());
            b.removeObserver(u);
            throw e;
        }

    }

}
