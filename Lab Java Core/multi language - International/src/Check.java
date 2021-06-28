
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Check {

    public void checkAcc(ResourceBundle bundel) {
        Scanner sc = new Scanner(System.in);
        String acc = "";
        System.out.print(bundel.getString("account"));
        acc = sc.nextLine();
        while (true) {

            Pattern p1 = Pattern.compile("^[0-9]{10}");

            if (p1.matcher(acc).find()) {

                break;
            } else {
                System.err.println("Account number must is a number and must have 10 digits.");
                System.out.print(bundel.getString("check.account"));
                acc = sc.nextLine();
            }
        }

    }
    Scanner sc = new Scanner(System.in);

    //Yêu cầu: password trong khoảng 8-31 ký tự
    //Chứa cả số và chữ, không có ký tự đặc biệt
    public void checkPassword(ResourceBundle bundle) {
        while (true) {
            System.out.println(bundle.getString("password"));
            String pass = sc.nextLine();

            //Thầy Hải bảo 2 dòng regex p và p1 sai
            Pattern p = Pattern.compile("^[0-9]{8,31}$"); // có mỗi số
            Pattern p1 = Pattern.compile("^[a-zA-Z]{8,31}$"); // có mỗi chữ
            //

            Pattern p2 = Pattern.compile("^[a-zA-Z0-9]{8,31}$");  // cả số và chữ, không có ký tự đb

            if (!p.matcher(pass).find() && !p1.matcher(pass).find() && p2.matcher(pass).find()) {
                break;
            } else {
                System.out.println(bundle.getString("wrong.password1") + bundle.getString("wrong.password2"));
            }
        }
    }

}
