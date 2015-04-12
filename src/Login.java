
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author CHIBUZOR
 */
public class Login extends JDialog {

    private final File passwordFile;
    private boolean loggedIn;
    private final JPasswordField pField;
    private final JPasswordField rpField;

    private Login(Frame owner) {
        super(owner, true);
        setTitle("Password");
        setAlwaysOnTop(true);
        this.passwordFile = new File(System.getProperty("user.dir"), "pwordlogger.dat");
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Password"));
        pField = new JPasswordField(20);
        rpField = new JPasswordField(20);
        pField.addActionListener((ActionEvent e) -> {
            login();
        });
        rpField.addActionListener((ActionEvent e) -> {
            login();
        });
        panel.add(pField);
        if (isFirstUse()) {
            panel.add(new JLabel("Retype Password"));
            panel.add(rpField);
        }
        JButton b = new JButton("Login");
        b.addActionListener((ActionEvent e) -> {
            login();
        });
        panel.add(b);
        add(panel);
        pack();
    }

    private void login() throws HeadlessException {
        if (isFirstUse()) {
            String p1 = new String(pField.getPassword());
            String p2 = new String(rpField.getPassword());
            
            if (p1.length() >= 8) {
                if (p1.equals(p2)) {
                    try {
                        setPassword(encrypt(p1));
                        loggedIn = true;
                        dispose();
                    } catch (NoSuchAlgorithmException | IOException ex) {
                        JOptionPane.showMessageDialog(this, "Sorry, something went wrong!\nProgram will exit");
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        System.exit(1);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords does not match");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password must be greater than or equal to 8 characters");
            }
        } else {
            try {
                loggedIn = encrypt(new String(pField.getPassword())).equalsIgnoreCase(getPassword());
                
                if (loggedIn) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Password!");
                }
            } catch (NoSuchAlgorithmException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Sorry, something went wrong!\nProgram will exit");
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }

    private boolean isLoggedIn() {
        return loggedIn;
    }

    public static boolean requestPassword(Frame owner) {
        Login login = new Login(owner);
        login.setSize(300, 180);
        Utility.centerWindowOnScreen(login);
        login.setResizable(false);
        login.setVisible(true);
        return login.isLoggedIn();
    }

    private boolean isFirstUse() {
        return !passwordFile.exists();
    }

    private String encrypt(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-1");
        byte[] digest = md.digest(message.getBytes());
        BigInteger bigInteger = new BigInteger(digest);
        return bigInteger.toString(16);
    }

    private String getPassword() throws IOException {
        String p;
        try (BufferedReader br = new BufferedReader(new FileReader(passwordFile))) {
            p = br.readLine();
        }
        return p;
    }

    private void setPassword(String password) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(passwordFile, false))) {
            bw.write(password);
        }
    }
}
