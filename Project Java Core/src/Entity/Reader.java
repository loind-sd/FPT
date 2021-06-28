
package Entity;

import java.util.ArrayList;

public class Reader {
    private int ID;
    private String name;
    private ArrayList<Borrowing> borrowings = new ArrayList<>();

    public Reader() {
    }

    public Reader(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(ArrayList<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
    
    
}
