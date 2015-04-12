
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author CHIBUZOR
 */
public class Utility {

    private static ExecutorService executor;
    
    public static ExecutorService getExecutorService(){
        if(executor == null){
            executor = Executors.newCachedThreadPool();
        }
        return executor;
    }
    
    public static String getCompanyName() {
        return "Foo Enterprise";
    }

    public static void centerWindowOnScreen(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.width - window.getWidth()) / 2;
        int y = (int) (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);
    }

    public static void centerWindowOnParent(Window parent, Window child) {
        Point parentLocationOnScreen = parent.getLocationOnScreen();
        int x = (int) (parent.getWidth() - child.getWidth()) / 2;
        int y = (int) (parent.getHeight() - child.getHeight()) / 2;
        x += parentLocationOnScreen.x;
        y += parentLocationOnScreen.y;
        //Make sure the top of child doesn't fall behind the screen
        x = x < 0 ? 0 : x;
        y = y < 0 ? 0 : y;

        child.setLocation(x, y);
    }
}
