
import java.awt.CardLayout;
import java.util.Enumeration;
import javax.swing.AbstractButton;

/**
 *
 * @author CHIBUZOR
 */
public final class MainFrame extends javax.swing.JFrame {

    private static MainFrame thisClass;
    private final SetupPanel setup;
    private final PaymentPanel selectPayments;
    private final PayEmployee payment;
    private final ProfilePanel profiles;

    private MainFrame() {
        setTitle("Payroll");
        initComponents();
        setup = SetupPanel.getInstance();
        selectPayments = PaymentPanel.getInstance();
        payment = PayEmployee.getInstance();
        profiles = ProfilePanel.getInstance();

        scene.add(setup, "setup");
        scene.add(selectPayments, "selectPayments");
        scene.add(payment, "payment");
        scene.add(profiles, "profiles");

        showSetupPanel();
    }

    public CardLayout getSceneCardLayout() {
        return (CardLayout) scene.getLayout();
    }

    public static MainFrame getInstance() {
        if (thisClass == null) {
            thisClass = new MainFrame();
        }
        return thisClass;
    }

    public void showSetupPanel() {
        getSceneCardLayout().show(scene, "setup");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(jButton1));
        }
    }

    public void showPaymentsPanel() {
        getSceneCardLayout().show(scene, "selectPayments");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(jButton2));
        }
    }

    public void showPaymentsListPanel() {
        getSceneCardLayout().show(scene, "payment");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(jButton2));
        }
    }

    public void showEmployeePanel() {
        getSceneCardLayout().show(scene, "profiles");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(jButton3));
        }
    }

    public void showBankVoucherPanel() {

        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(jButton4));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navButtons = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        scene = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Setup");
        navButtons.add(jButton1);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Payments");
        navButtons.add(jButton2);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Employees");
        navButtons.add(jButton3);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Bank Voucher");
        navButtons.add(jButton4);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

        scene.setBackground(new java.awt.Color(255, 255, 255));
        scene.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showSetupPanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showPaymentsPanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        showEmployeePanel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        showBankVoucherPanel();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup navButtons;
    private javax.swing.JPanel scene;
    // End of variables declaration//GEN-END:variables
}
