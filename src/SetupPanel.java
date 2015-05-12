
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author CHIBUZOR
 */
public class SetupPanel extends javax.swing.JPanel {

    private static SetupPanel thisClass;
    private ArrayList<SetupItem> leaveItems;
    private ArrayList<SetupItem> maternityItems;
    private ArrayList<SetupItem> welfareItems;

    private SetupPanel() {
        initComponents();
        loadData();
        showLeaveAllowance();
    }

    private void loadData() {
        leaveItems = getEmployeesEligibleForLeaveAllowance();
        maternityItems = getEmployeesEligibleForMaternityAllowance();
        welfareItems = getEmployeesEligibleForWelfareAllowance();
    }

    private void showLeaveAllowance() {
        scene.removeAll();
        for (SetupItem leaveItem : leaveItems) {
            scene.add(leaveItem);
        }
        if (leaveItems.isEmpty()) {
            JLabel notice = new JLabel("Nothing found");
            notice.setHorizontalAlignment(SwingConstants.CENTER);
            scene.add(notice);
        }
        scene.validate();
        LeaveAllowanceSetUpRadioButton.setSelected(true);
    }

    private void showMaternityAllowance() {
        scene.removeAll();
        for (SetupItem maternityItem : maternityItems) {
            scene.add(maternityItem);
        }
        if (maternityItems.isEmpty()) {
            JLabel notice = new JLabel("Nothing found");
            notice.setHorizontalAlignment(SwingConstants.CENTER);
            scene.add(notice);
        }
        scene.validate();
        MaternitySetUpRadioButton.setSelected(true);
    }

    private void showWelfareAllowance() {
        scene.removeAll();
        for (SetupItem welfareItem : welfareItems) {
            scene.add(welfareItem);
        }

        if (welfareItems.isEmpty()) {
            JLabel notice = new JLabel("Nothing found");
            notice.setHorizontalAlignment(SwingConstants.CENTER);
            scene.add(notice);
        }
        scene.validate();
        DecemberWelfareRadioButton.setSelected(true);
    }

    public static SetupPanel getInstance() {
        if (thisClass == null) {
            thisClass = new SetupPanel();
        }
        return thisClass;
    }

    private ArrayList<SetupItem> getEmployeesEligibleForLeaveAllowance() {
        ArrayList<SetupItem> items = new ArrayList<>();
        //Add employess eligible for leave allowance
        return items;
    }

    private ArrayList<SetupItem> getEmployeesEligibleForMaternityAllowance() {
        ArrayList<SetupItem> items = new ArrayList<>();
        //Add employess eligible for maternity allowance

        return items;
    }

    private ArrayList<SetupItem> getEmployeesEligibleForWelfareAllowance() {
        ArrayList<SetupItem> items = new ArrayList<>();
        //Add employess eligible for welfare allowance

        return items;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        LeaveAllowanceSetUpRadioButton = new javax.swing.JRadioButton();
        MaternitySetUpRadioButton = new javax.swing.JRadioButton();
        DecemberWelfareRadioButton = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        blockEmployeeButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        SkipSetUpButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scene = new javax.swing.JPanel();

        setOpaque(false);

        jPanel2.setOpaque(false);

        buttonGroup.add(LeaveAllowanceSetUpRadioButton);
        LeaveAllowanceSetUpRadioButton.setText("Leave allowance");
        LeaveAllowanceSetUpRadioButton.setIconTextGap(10);
        LeaveAllowanceSetUpRadioButton.setOpaque(false);
        LeaveAllowanceSetUpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveAllowanceSetUpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(MaternitySetUpRadioButton);
        MaternitySetUpRadioButton.setText("Maternity");
        MaternitySetUpRadioButton.setIconTextGap(10);
        MaternitySetUpRadioButton.setOpaque(false);
        MaternitySetUpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaternitySetUpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(DecemberWelfareRadioButton);
        DecemberWelfareRadioButton.setText("December Welfare");
        DecemberWelfareRadioButton.setIconTextGap(10);
        DecemberWelfareRadioButton.setOpaque(false);
        DecemberWelfareRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecemberWelfareRadioButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Add Employee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        blockEmployeeButton.setText("Block Eployee");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockEmployeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MaternitySetUpRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DecemberWelfareRadioButton)
                            .addComponent(LeaveAllowanceSetUpRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockEmployeeButton)
                .addGap(67, 67, 67)
                .addComponent(LeaveAllowanceSetUpRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MaternitySetUpRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DecemberWelfareRadioButton)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jPanel1.setOpaque(false);

        jPanel3.setOpaque(false);

        jButton1.setText("Update");

        SkipSetUpButton.setText("Skip");
        SkipSetUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkipSetUpButtonActionPerformed(evt);
            }
        });

        jButton3.setText("OK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SkipSetUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(SkipSetUpButton)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        scene.setBackground(new java.awt.Color(255, 255, 255));
        scene.setLayout(new javax.swing.BoxLayout(scene, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(scene);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LeaveAllowanceSetUpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveAllowanceSetUpRadioButtonActionPerformed
        // TODO add your handling code here:
        showLeaveAllowance();
    }//GEN-LAST:event_LeaveAllowanceSetUpRadioButtonActionPerformed

    private void MaternitySetUpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaternitySetUpRadioButtonActionPerformed
        // TODO add your handling code here:
        showMaternityAllowance();
    }//GEN-LAST:event_MaternitySetUpRadioButtonActionPerformed

    private void DecemberWelfareRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecemberWelfareRadioButtonActionPerformed
        // TODO add your handling code here:
        showWelfareAllowance();
    }//GEN-LAST:event_DecemberWelfareRadioButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddEmployeeDialog dialog = new AddEmployeeDialog(MainFrame.getInstance());
        Utility.centerWindowOnParent(MainFrame.getInstance(), dialog);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SkipSetUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkipSetUpButtonActionPerformed
        // TODO add your handling code here:
        MainFrame.getInstance().showPaymentsPanel();
    }//GEN-LAST:event_SkipSetUpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DecemberWelfareRadioButton;
    private javax.swing.JRadioButton LeaveAllowanceSetUpRadioButton;
    private javax.swing.JRadioButton MaternitySetUpRadioButton;
    private javax.swing.JButton SkipSetUpButton;
    private javax.swing.JButton blockEmployeeButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel scene;
    // End of variables declaration//GEN-END:variables
}
