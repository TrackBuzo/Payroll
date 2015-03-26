
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHIBUZOR
 */
public class UnitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean requestPassword = Login.requestPassword(null);
        JOptionPane.showMessageDialog(null, requestPassword);
    }
    
}
