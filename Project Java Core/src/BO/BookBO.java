
package BO;

import DAL.DBcontext;
import Entity.Book;
import Validate.validateInput;
import java.util.Scanner;

public class BookBO {
    private DBcontext db;

    public BookBO(DBcontext db) {
        this.db = db;
    }
    validateInput valid = new validateInput();
    public void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Add Book--------------");
        System.out.println("Enter Book ID:");
        int ID = valid.checkInputInteger();
        System.out.println("Enter Book Title:");
        String title = valid.checkEmptyString();
        Book b = new Book(ID, title);
        db.addBook(b);
    }
    
}
