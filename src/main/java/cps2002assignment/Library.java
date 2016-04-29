
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
}
