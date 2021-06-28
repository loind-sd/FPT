package work;





import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;

public class common {
    public static JFrame findParent(Component com){
        Container c = com.getParent();
        
        while(c.getParent()!=null){
            c=c.getParent();
        }
        
        if (c instanceof JFrame) {
            return (JFrame)c;
        }
        else{
            return null;
        }
    }
}