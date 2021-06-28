
import BO.BookBO;
import BO.BorrowingBO;
import BO.ReaderBO;
import DAL.DBcontext;
import Validate.validateInput;
import java.text.ParseException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        DBcontext db = new DBcontext();
        ReaderBO memberBO = new ReaderBO(db);
        BookBO bookBO = new BookBO(db);
        BorrowingBO borrowingBO = new BorrowingBO(db);
        validateInput valid = new validateInput();
        while (true) {
            System.out.println("-----------Libraly Management-----------");
            System.out.println("1. Add Reader");
            System.out.println("7. Delete Reader");
            
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Give Book Back");
            System.out.println("5. Display information of Borrowing Book");
            System.out.println("6. Exit");
            System.out.println("Choose an optional: ");
            choice = valid.checkInputInteger();
            if (choice < 1 || choice > 7) {
                System.out.println("Incorrect choice ! Please re-choose");
            } else {
                switch (choice) {
                    case 1:
                        memberBO.addMember();
                        break;
                        case 7:
                        memberBO.delete();
                        break;
                    case 2:
                        bookBO.addBook();
                        break;
                    case 3:
                        borrowingBO.addBorrowing();
                        break;
                    case 4:
                        borrowingBO.giveBookBack();
                        break;
                    case 5:
                        borrowingBO.displayBorrowingBookInformationByMemberID();
                        break;
                    case 6:
                        System.exit(0);
                }
            }
        }

    }

}
