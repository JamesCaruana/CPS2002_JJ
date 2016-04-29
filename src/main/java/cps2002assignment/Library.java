
package cps2002assignment;

import java.util.Vector;

public class Library {

    private Vector<User> userVector = new Vector<User>();
    private Catalogue c = new Catalogue();
    
    public Vector<User> getAllUsers() {
        return userVector;
    }
    
    public void addUser(User u) throws Exception{
        for(int i = 0; i < userVector.size();i++){
            if(userVector.get(i).getUserID() == u.getUserID()){
                throw new UserNotUniqueException("User id already exists");
            }
        }
        userVector.add(u);
    }
    
    public void removeUser(User u) throws Exception{
        for(int i = 0; i < userVector.size(); i++){ //find user
            if(u == userVector.get(i)){
                userVector.remove(i);
                System.out.println("User removed");
                return;
            }
        }
        throw new UserNotFoundException("User with id "+u.getUserID()+" was not found");
    }

    public void loanBookTo(Book b , User u) throws Exception {

        boolean foundUser = false;
        boolean foundBook = false;

        for (int i = 0; i < userVector.size(); i++) { //check if user is in system
            if (u == userVector.get(i)) {
                foundUser = true;
                break;
            }
        }

        if(!foundUser){
            throw new UserNotFoundException("User with id "+u.getUserID()+" was not found");
        }

        for(int i = 0; i < c.getAllBooks().size(); i++){ //check if book is in system
            if(b == c.getAllBooks().get(i)){
                foundBook = true;
                break;
            }
        }

        if(!foundBook){
            throw new BookNotFoundException("Book with id "+b.getId()+" was not found");
        }

        if(b.getLoanee() != null){
            throw new BookAlreadyLoanedException("Book with id "+b.getId()+ " was not found");
        }

        try{
            u.addLoanedBook(b); // can throw BookOverdue & MaximumLoanedBooks exceptions
            b.setLoanee(u);
        }catch(Exception e){
            throw e;
        }

    }
    
    public void returnBook(Book b) throws Exception{
        boolean foundBook = false;
        for(int i = 0; i < c.getAllBooks().size(); i++){ //check if book is in system
            if(b == c.getAllBooks().get(i)){
                foundBook = true;
                break;
            }
        }

        if(!foundBook){
            throw new BookNotFoundException("Book with id "+b.getId()+" was not found");
        }

        if(b.getLoanee() == null){
            throw new BookNotLoanedException("Book with id "+b.getId()+" was not loaned");
        }

        b.getLoanee().removeLoanedBook(b);

    }
    
    public Catalogue getCatalogue(){
        return c;
    }
}
