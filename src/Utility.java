
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;



/**
 *
 * @author CHIBUZOR
 */
public class Utility {
    
    public static String getCompanyName(){
        return "Foo Enterprise";
    } 
        
    public static void centerWindowOnScreen(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.width - window.getWidth()) / 2;
        int y = (int) (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);
    }
}
