
/**
 *
 * @author CHIBUZOR
 */
public class SetupItem extends javax.swing.JPanel {

    /**
     * Creates new form SetupItem
     */
    private SetupItem() {
        initComponents();
    }
    
    public SetupItem(String staffId, String name, String dept, String designation){
        this();
        staffIdCheckBox.setText(staffId);
        employeesNameLabel.setText(name);
        nameOfDepartmentLabel.setText(dept);
        employeesPositionLabel.setText(designation);
    }
    
    public boolean isSelected(){
        return staffIdCheckBox.isSelected();
    }
    
    public String getStaffID(){
        return staffIdCheckBox.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        employeesPositionLabel = new javax.swing.JLabel();
        staffIdCheckBox = new javax.swing.JCheckBox();
        nameOfDepartmentLabel = new javax.swing.JLabel();
        employeesNameLabel = new javax.swing.JLabel();

        employeesPositionLabel.setText("Designation");

        staffIdCheckBox.setText("StaffID");
        staffIdCheckBox.setIconTextGap(10);

        nameOfDepartmentLabel.setText("Department");

        employeesNameLabel.setText("Name of Employee");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffIdCheckBox)
                .addGap(9, 9, 9)
                .addComponent(employeesNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameOfDepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeesPositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nameOfDepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(employeesNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(staffIdCheckBox)
                .addComponent(employeesPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel employeesNameLabel;
    private javax.swing.JLabel employeesPositionLabel;
    private javax.swing.JLabel nameOfDepartmentLabel;
    private javax.swing.JCheckBox staffIdCheckBox;
    // End of variables declaration//GEN-END:variables
}
