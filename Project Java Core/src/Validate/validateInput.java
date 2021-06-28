/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class validateInput {

    public String checkDate() throws ParseException {
        //date must be following format : dd/MM/yyyy 
        DateValidatorUsingDateFormat dateformat = new DateValidatorUsingDateFormat("dd-MM-yyyy");
        Scanner sc = new Scanner(System.in);
        String date = "";
        //create time of today
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            date = sc.nextLine();
            if (dateformat.isDateValid(date)) {
                Date dateForm = sdf.parse(date);
                if (dateForm.compareTo(today) > 0) {
                    break;
                } else {
                    System.out.println("Invalid Date! Please re-input");
                    System.out.println("Date must be following format : dd/MM/yyyy");
                }
            } else {
                System.out.println("Invalid Date! Please re-input");
                System.out.println("Date must be following format : dd/MM/yyyy");
            }
        }
        return date;
    }

    public String checkInputName() {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            name = sc.nextLine();
            if (name.trim().equals("")) {
                System.out.println("Name must not be empty! please re-input !");
            } else {
                boolean isSpecialChar = false;
                for (int i = 0; i < name.length(); i++) {
                    if ((name.charAt(i) < 65 && name.charAt(i) != 32) || (name.charAt(i) > 90 && name.charAt(i) < 97) || name.charAt(i) > 122) {
                        System.out.println("Name must not contain special character & number !");
                        isSpecialChar = true;
                        break;
                    }
                }
                if (!isSpecialChar) {
                    break;
                }
            }
        }
        return name.trim();
    }

    public String checkEmptyString() {
        Scanner sc = new Scanner(System.in);
        String string;
        while (true) {
            string = sc.nextLine();
            if (!string.trim().equals("")) {
                break;
            } else {
                System.out.println("String must not be empty! please re-input !");
            }
        }
        return string;
    }

    public int checkInputInteger() {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please re-input");
            }
        }
        return n;
    }
}
