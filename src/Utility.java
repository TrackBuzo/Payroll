
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.text.JTextComponent;

/**
 *
 * @author CHIBUZOR
 */
public class Utility {

    private static ExecutorService executor;

    public static ExecutorService getExecutorService() {
        if (executor == null) {
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

    public static boolean printComponent(Component component) {
        PrinterJob job = PrinterJob.getPrinterJob();
        return false;
    }

    public static boolean isOnMaternityLeave(String staffId) {
        //Check if on maternity leave
        return false;
    }

    public static boolean isDecember() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) == Calendar.DECEMBER;
    }

    public static void setPlaceholder(JTextComponent c, String placeholder) {
        if (c.getText().isEmpty()) {
            c.setText(placeholder);
            c.setForeground(Color.lightGray);
        }

        c.addFocusListener(new FocusListener() {

            private boolean isPlaceholderShowing() {
                return c.getText().equalsIgnoreCase(placeholder)
                        && c.getForeground().equals(Color.lightGray);
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (isPlaceholderShowing()) {
                    c.setText("");
                    c.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (c.getText().isEmpty()) {
                    c.setText(placeholder);
                    c.setForeground(Color.lightGray);
                }
            }
        });
    }
}
