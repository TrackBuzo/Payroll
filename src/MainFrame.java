
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
            button.setContentAreaFilled(button.equals(setupButton));
        }
    }

    public void showPaymentsPanel() {
        getSceneCardLayout().show(scene, "selectPayments");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(paymentsButton));
        }
    }

    public void showPaymentsListPanel() {
        getSceneCardLayout().show(scene, "payment");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(paymentsButton));
        }
    }

    public void showEmployeePanel() {
        getSceneCardLayout().show(scene, "profiles");
        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(employeesButton));
        }
    }

    public void showBankVoucherPanel() {

        Enumeration<AbstractButton> elements = navButtons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            button.setContentAreaFilled(button.equals(bankVoucherButton));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navButtons = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        setupButton = new javax.swing.JButton();
        paymentsButton = new javax.swing.JButton();
        employeesButton = new javax.swing.JButton();
        bankVoucherButton = new javax.swing.JButton();
        scene = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setupButton.setText("Setup");
        navButtons.add(setupButton);
        setupButton.setContentAreaFilled(false);
        setupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupButtonActionPerformed(evt);
            }
        });

        paymentsButton.setText("Payments");
        navButtons.add(paymentsButton);
        paymentsButton.setContentAreaFilled(false);
        paymentsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentsButtonActionPerformed(evt);
            }
        });

        employeesButton.setText("Employees");
        navButtons.add(employeesButton);
        employeesButton.setContentAreaFilled(false);
        employeesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesButtonActionPerformed(evt);
            }
        });

        bankVoucherButton.setText("Bank Voucher");
        navButtons.add(bankVoucherButton);
        bankVoucherButton.setContentAreaFilled(false);
        bankVoucherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bankVoucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankVoucherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(employeesButton)
                .addGap(52, 52, 52)
                .addComponent(paymentsButton)
                .addGap(42, 42, 42)
                .addComponent(bankVoucherButton)
                .addGap(34, 34, 34)
                .addComponent(setupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bankVoucherButton)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeesButton)
                    .addComponent(paymentsButton))
                .addContainerGap())
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
                .addGap(0, 0, 0)
                .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupButtonActionPerformed
        // TODO add your handling code here:
        showSetupPanel();
    }//GEN-LAST:event_setupButtonActionPerformed

    private void paymentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsButtonActionPerformed
        // TODO add your handling code here:
        showPaymentsPanel();
    }//GEN-LAST:event_paymentsButtonActionPerformed

    private void employeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesButtonActionPerformed
        // TODO add your handling code here:
        showEmployeePanel();
    }//GEN-LAST:event_employeesButtonActionPerformed

    private void bankVoucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankVoucherButtonActionPerformed
        // TODO add your handling code here:
        showBankVoucherPanel();
    }//GEN-LAST:event_bankVoucherButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bankVoucherButton;
    private javax.swing.JButton employeesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup navButtons;
    private javax.swing.JButton paymentsButton;
    private javax.swing.JPanel scene;
    private javax.swing.JButton setupButton;
    // End of variables declaration//GEN-END:variables
}
