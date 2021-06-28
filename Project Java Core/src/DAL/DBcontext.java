
package DAL;

import Entity.Book;
import Entity.Borrowing;
import Entity.Reader;
import java.util.ArrayList;

public class DBcontext {
    private ArrayList<Reader> readers = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Borrowing> borrowings = new ArrayList<>();
    
    public void addMember(Reader m){
        readers.add(m);
    }
    public Reader getMember(int id){
        for (Reader member : readers) {
            if(member.getID() == id)
                return member;
        }
        return null;
    }
    
    public void addBook(Book b){
        books.add(b);
    }
    public Book getBook(int id){
        for (Book book : books) {
            if(book.getID() == id)
                return book;
        }
        return null;
    }
    
    public void addBorrowing(Borrowing bo){
        borrowings.add(bo);
    }

    public ArrayList<Reader> getMembers() {
        return readers;
    }

    public void setMembers(ArrayList<Reader> members) {
        this.readers = members;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(ArrayList<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
    
    
}
