
package Entity;

import java.util.Date;

public class Borrowing {
    private Reader member;
    private Book book;
    private String deadline;

    public Borrowing() {
    }

    public Borrowing(Reader member, Book book, String deadline) {
        this.member = member;
        this.book = book;
        this.deadline = deadline;
    }

    public Reader getMember() {
        return member;
    }

    public void setMember(Reader member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    
    
}
