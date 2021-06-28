
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

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
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        Check c = new Check();
        Captcha cc = new Captcha();
        do {
            System.out.println("=========Login Tien Phong Bank’s Ebank===========");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            input = sc.nextLine();
            switch (input) {
                case "1":
                    Locale lc = new Locale("vn", "VN");
                    ResourceBundle bundle_vi = ResourceBundle.getBundle("MessageBundle", lc);
                    loginSytem(bundle_vi);
                    break;
                case "2":
                    
                    ResourceBundle bundle_en = ResourceBundle.getBundle("vi-en");
                    loginSytem(bundle_en);
                    break;
            }
        } while (!input.equals("3"));
    }
    
    public static void loginSytem(ResourceBundle bundle) {
        Check c = new Check();
        c.checkAcc(bundle);
        c.checkPassword(bundle);
        Captcha cc = new Captcha();
        cc.randomCapt(bundle);
    }
}