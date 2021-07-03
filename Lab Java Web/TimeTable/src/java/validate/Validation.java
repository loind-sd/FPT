/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class Validation {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean checkDateValid(String date) {
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("Date is not valid: " + date);
        }
        return false;
    }
    
     
     
     
}
