package BO;

import DAL.DBcontext;
import Entity.Book;
import Entity.Borrowing;
import Entity.Reader;
import Validate.validateInput;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BorrowingBO {

    private DBcontext db;

    public BorrowingBO(DBcontext db) {
        this.db = db;
    }

    validateInput valid = new validateInput();

    public void addBorrowing() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------Add Borrowing-------------");
        System.out.println("Members: ");
        for (Reader member : db.getMembers()) {
            System.out.println(
                    member.getID() + "\t" + member.getName()
            );
        }
        System.out.println("Books: ");
        for (Book book : db.getBooks()) {
            System.out.println(
                    book.getID() + "\t" + book.getTitle()
            );
        }
        Borrowing bo = new Borrowing();
        System.out.println("Enter Member ID:");
        int memberID = valid.checkInputInteger();
        Reader member = db.getMember(memberID);
        bo.setMember(member);
        
        System.out.println("Enter Book ID:");
        int bookID = valid.checkInputInteger();
        Book book = db.getBook(bookID);
        bo.setBook(book);
        System.out.println("Enter Deadline of Borrowing:");
        bo.setDeadline(valid.checkDate());
        db.addBorrowing(bo);
        member.getBorrowings().add(bo);
    }

    public void giveBookBack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------Give Book Back-------------");
        System.out.println("Enter Member ID:");
        int memberID = valid.checkInputInteger();
        Reader m = db.getMember(memberID);
        if (m == null) {
            System.err.println("This member is not exist!");
        } else {
            System.out.println("Enter Book ID:");
            int bookID = valid.checkInputInteger();
            Book b = db.getBook(bookID);
            boolean isExisting = false;
            for (int i = 0; i < db.getBorrowings().size(); i++) {
                Borrowing bo = db.getBorrowings().get(i);
                if (bo.getMember().getID() == m.getID()
                        && bo.getBook().getID() == b.getID()) {
                    isExisting = true;
                    db.getBorrowings().remove(bo);
                    m.getBorrowings().remove(bo);
                    System.out.println("Give book back succesfully");
                    break;
                }
                if (!isExisting) {
                    System.out.println("This book hasn't been borrowed");
                }
            }
        }
    }

    public void displayBorrowingBookInformationByMemberID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------Borrowing Book Infor-------------");
        System.out.println("Enter Member ID:");
        int MemberID = valid.checkInputInteger();
        Reader m = db.getMember(MemberID);
        if (m == null) {
            System.out.println("This member is not exist!");
        } else if(m.getBorrowings().isEmpty()) 
            System.out.println("This member has not borrowing book");
        else {
            System.out.println(m.getName() + "'s Borrowing:");
            for (Borrowing bo : m.getBorrowings()) {
                System.out.println(
                        bo.getBook().getID() + "\t" + bo.getBook().getTitle()
                        + "\tDeadline: " + bo.getDeadline()
                );
            }
        }
    }

}
