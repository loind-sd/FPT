
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {

        Validate v = new Validate();
        DB db = new DB();
        Login login = new Login(db);
        User u = new User("LongDt", "19longdt", "Long Xink", "0123456789", "19Longdt@fu.com", "hanoi");
        db.addUser(u);
        while (true) {
            System.out.println("=====Login Program=====");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = v.checkIntLimit(1, 3);
            switch (choice) {
                case 1:
                    login.addUser();
                    break;
                case 2:
                    login.addLogin();
                    break;
                case 3:
                    System.exit(0);

            }

        }

    }

}
