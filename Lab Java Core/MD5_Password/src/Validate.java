
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.xml.bind.DatatypeConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int checkIntLimit(int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print("Please choice one option: ");
                n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Please enter number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter number");
            }
        }
    }

    public String getDate() throws ParseException {
        SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyy");
        dateFomat.setLenient(false);
        String text = "";
        while (true) {
            try {
                System.out.print("DOB: ");
                text = sc.nextLine();
                dateFomat.parse(text.trim());
            } catch (ParseException e) {
                System.out.println("Please reenter");
                continue;
            }
            break;
        }
        return text;
    }

    public String getText(String mess) {
        String name = "";
        do {
            System.out.print(mess);
            name = sc.nextLine();
            if (name.trim().equals("")) {
                continue;
            } else {
                break;
            }
        } while (true);
        return name;
    }

    public String checkPhone() {
        while (true) {
            try {
                System.out.print("Phone: ");
                Pattern p = Pattern.compile("^[0-9]{10,11}$");
                String phone = sc.nextLine();
                if (p.matcher(phone).find()) {
                    return phone;
                } else {
                    System.out.println("Phone number must be 10 or 11 number.");
                }
            } catch (Exception e) {
                System.out.println("Reenter!!!");
            }
        }
    }

    public String checkEmail() {
        System.out.print("Email: ");
        while (true) {
            try {
                String pass = sc.nextLine();
                Pattern p = Pattern.compile("^[0-9A-Za-z+_.]+@+[A-Za-z]+(\\.[A-Za-z]+){1,3}$");
                if (p.matcher(pass).find()) {
                    return pass;
                } else {
                    System.out.println("Email is not valid format");
                }
            } catch (Exception e) {
                System.out.println("Email is not valid format");
            }
        }
    }

    public String Md5(String input) throws UnsupportedEncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            return DatatypeConverter.printHexBinary(md.digest());
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }

    public boolean checkYN() {
        String s;
        while (true) {
            s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                return true;
            } else if (s.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Please enter Y or N");
                System.out.print("Entre again: ");
            }
        }
    }
}
