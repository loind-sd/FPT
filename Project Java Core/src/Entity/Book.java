
package Entity;

public class Book {
    private int ID;
    private String title;
    
    public Book() {
    }

    public Book(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
