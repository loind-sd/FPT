
package BO;

import DAL.DBcontext;
import Entity.Reader;
import Validate.validateInput;
import java.util.Scanner;

public class ReaderBO {
    private DBcontext db;

    public ReaderBO(DBcontext db) {
        this.db = db;
    }
    validateInput valid = new validateInput();
    
    public void addMember(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------Add Reader--------------");
        System.out.println("Enter Reader ID:");
        int ID = valid.checkInputInteger();
        System.out.println("Enter Reader Name:");
        String name = valid.checkInputName();
        Reader m = new Reader(ID, name);
        db.addMember(m);
    }
    public void delete() {
        System.out.println("---------------Delete Reader--------------");
        System.out.println("Members: ");
        for (Reader member : db.getMembers()) {
            System.out.println(
                    member.getID() + "\t" + member.getName()
            );
        }
        
        System.out.println("Enter Member ID:");
        int memberID = valid.checkInputInteger();
        Reader member = db.getMember(memberID);
        
        
        int size = db.getMembers().size();
        for (int i = 0; i < size; i++) {
            if (db.getMembers().get(i).getID() == memberID) {
                member = db.getMembers().get(i);
                break;
            }
        }
        if (member != null) {
            db.getMembers().remove(member);
            System.out.println(" Delete Reader Succesfully! ");
        } else {
            System.out.printf("id = %d not existed.\n", memberID);
        }
    }
 
}
