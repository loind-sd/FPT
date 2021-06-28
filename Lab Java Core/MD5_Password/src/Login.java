
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Login {

    Validate v = new Validate();

    public Login() {
    }
    private DB db;

    public Login(DB db) {
        this.db = db;
    }
    SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");

    public void addUser() throws ParseException, UnsupportedEncodingException {
        System.out.println("=====ADD USER=====");
        String Account = v.getText("Account: ");
        String Password = v.getText("Password: ");
        String Name = v.getText("Name: ");
        String Phone = v.checkPhone();
        String Email = v.checkEmail();
        String Address = v.getText("Address: ");
        String dat = v.getDate();
        Date date = dateFomat.parse(dat); 

        User u = new User(Account, v.Md5(Password), Name, Phone, Email, Address);
        db.addUser(u);
        System.out.println(v.Md5(Password) + Password);
    }

    public void addLogin() throws UnsupportedEncodingException {
        System.out.println("=====LOGIN=====");
        if(db.getUsers().isEmpty()){
            System.out.println("Create at least 1 user!11 ");
            return;
        }
        String Acc = v.getText("Account: ");
        String Pass = v.getText("Password: ");
        boolean check = false;
        for (int i = 0; i < db.getUsers().size(); i++) {
            if (Acc.equalsIgnoreCase(db.getUsers().get(i).getUsername())
                    && v.Md5(Pass).equalsIgnoreCase(db.getUsers().get(i).getPass())) {
                check = true;
                System.out.println("=====WELLCOME=====");
                System.out.print("Hi " + db.getUsers().get(i).getName()
                        + ", do you want change password now? Y/N: ");
                if (v.checkYN()) {
                    String oldPass, newPass, renewPass;
                    do {
                        oldPass = v.getText("Old Password: ");
                        if (!oldPass.equals(Pass)) {
                            System.out.println("Reenter Old Password");
                        }
                    } while (!oldPass.equals(Pass));

                    do {
                        newPass = v.getText("New Password: ");
                        if (oldPass.equals(newPass)) {
                            System.out.println("Reenter New Password");
                        }
                    } while (newPass.equals(oldPass));

                    do {
                        renewPass = v.getText("Renew Password: ");
                        if (!renewPass.equals(newPass) && newPass.equals(oldPass)) {
                            System.out.println("New Password must equals Renew Password");
                        }
                    } while (!renewPass.equals(newPass));
                    System.out.println("Change Password Successfull!!!");
                    
                    db.getUsers().get(i).setPass(v.Md5(newPass));
                }
            }
        }
        if (!check) {
            System.err.println("sai nick");
        }
    }
}
