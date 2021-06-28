
import java.util.Random;
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
public class Captcha {
    public void randomCapt(ResourceBundle bundle) {
        String c = "ABCDE";
        String randomString = "";
        int length = 5;
        
        Random r = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = c.charAt(r.nextInt(c.length()));
            randomString += text[i];
        }

        System.out.println( "Captcha: " + randomString);
        while(true){
        System.out.print(bundle.getString("capcha"));
        Scanner sc = new Scanner(System.in);
        String input = "";
        input = sc.nextLine(); 
        
         if (randomString.contains(input)) {
                System.out.println("Login Successful !!!");
                break;
            } else {
                System.out.println(bundle.getString("wrong.capcha"));
            }
        } 
    }
    
}

