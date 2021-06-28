
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class DB {
    ArrayList<User> users = new ArrayList<>();

    public DB() {
    }

    public void addUser(User u){
        users.add(u);
    }
    
    public User getuser(String account){
        for (User user : users) {
            if(user.getUsername().equalsIgnoreCase(account)){
                return user;
            }
        }
        return null;
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
}
