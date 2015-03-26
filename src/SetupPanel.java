
/**
 *
 * @author CHIBUZOR
 */
public class SetupPanel extends javax.swing.JPanel {
    private static SetupPanel thisClass;

    
    private SetupPanel() {
        initComponents();
    }

    public static SetupPanel getInstance(){
        if(thisClass == null){
            thisClass = new SetupPanel();
        }
        return thisClass;
    }
    
    private void getEmployeesEligibleForLeaveAllowance(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        LeaveAllowanceSetUpRadioButton = new javax.swing.JRadioButton();
        MaternitySetUpRadioButton = new javax.swing.JRadioButton();
        DecemberWelfareRadioButton = new javax.swing.JRadioButton();
        AddEmployeeSetUpRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        SkipSetUpButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);

        jPanel2.setOpaque(false);

        buttonGroup.add(LeaveAllowanceSetUpRadioButton);
        LeaveAllowanceSetUpRadioButton.setText("Leave allowance");
        LeaveAllowanceSetUpRadioButton.setIconTextGap(10);
        LeaveAllowanceSetUpRadioButton.setOpaque(false);

        buttonGroup.add(MaternitySetUpRadioButton);
        MaternitySetUpRadioButton.setText("Maternity");
        MaternitySetUpRadioButton.setIconTextGap(10);
        MaternitySetUpRadioButton.setOpaque(false);

        buttonGroup.add(DecemberWelfareRadioButton);
        DecemberWelfareRadioButton.setText("December Welfare");
        DecemberWelfareRadioButton.setIconTextGap(10);
        DecemberWelfareRadioButton.setOpaque(false);

        buttonGroup.add(AddEmployeeSetUpRadioButton);
        AddEmployeeSetUpRadioButton.setText("Add Employee");
        AddEmployeeSetUpRadioButton.setIconTextGap(10);
        AddEmployeeSetUpRadioButton.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddEmployeeSetUpRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DecemberWelfareRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MaternitySetUpRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LeaveAllowanceSetUpRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(LeaveAllowanceSetUpRadioButton)
                .addGap(18, 18, 18)
                .addComponent(MaternitySetUpRadioButton)
                .addGap(18, 18, 18)
                .addComponent(DecemberWelfareRadioButton)
                .addGap(18, 18, 18)
                .addComponent(AddEmployeeSetUpRadioButton)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jButton1.setText("Update");

        SkipSetUpButton.setText("Skip");

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AddEmployeeSetUpRadioButton;
    private javax.swing.JRadioButton DecemberWelfareRadioButton;
    private javax.swing.JRadioButton LeaveAllowanceSetUpRadioButton;
    private javax.swing.JRadioButton MaternitySetUpRadioButton;
    private javax.swing.JButton SkipSetUpButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
