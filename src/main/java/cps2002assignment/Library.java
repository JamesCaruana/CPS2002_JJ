
package cps2002assignment;

import java.util.Vector;

public class Library {

    private Vector<User> userVector = new Vector<User>();
    private Catalogue c = new Catalogue();
    
    public Vector<User> getAllUsers() {
        return userVector;
    }
}
