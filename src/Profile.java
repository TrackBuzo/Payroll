
import database.DatabaseImpl;
import database.DepartmentsTable;
import database.StaffTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author CHIBUZOR
 */
public class Profile extends javax.swing.JDialog {

    private boolean anyFieldEdited;
    private ArrayList<HashMap<String, String>> departments;
    private ArrayList<HashMap<String, String>> designations;

    private Profile(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    public Profile(java.awt.Frame parent, HashMap<String, String> employee) {
        this(parent);

        Runnable runnable = () -> {
            loadData();
            setEmployeeDetails(employee);
            EditProfileButton.setEnabled(true);
        };
        //Execute in another thread, to avoid program from being unresponsive
        Utility.getExecutorService().execute(runnable);
    }

    private void loadData() {
        //oad departments
        try {
            departments = DatabaseImpl.getDepartmentsTable();
        } catch (SQLException ex) {
            departments = new ArrayList<>();
        }
        if (departments.isEmpty()) {
            departmentComboBox.setModel(new DefaultComboBoxModel(new String[]{"Not Available"}));
        } else {
            String deptNames[] = new String[departments.size()];
            for (int i = 0; i < deptNames.length; i++) {
                deptNames[i] = departments.get(i).get(DepartmentsTable.NAME.toString());
            }
            departmentComboBox.setModel(new DefaultComboBoxModel(deptNames));
        }

        //load designations
        try {
            designations = DatabaseImpl.getDesignationsTable();
        } catch (SQLException ex) {
            designations = new ArrayList<>();
        }
        if (designations.isEmpty()) {
            designationsComboBox.setModel(new DefaultComboBoxModel(new String[]{"Not Available"}));
        } else {
            String designationsNames[] = new String[designations.size()];
            for (int i = 0; i < designationsNames.length; i++) {
                designationsNames[i] = departments.get(i).get(DepartmentsTable.NAME.toString());
            }
            designationsComboBox.setModel(new DefaultComboBoxModel(designationsNames));
        }
    }

    private String getDepartmentName(String dept_id) {
        for (HashMap<String, String> department : departments) {
            if (department.get(DepartmentsTable.DEPARTMENT_ID.toString()).equals(dept_id)) {
                return department.get(DepartmentsTable.NAME.toString());
            }
        }
        return "";
    }

    private void setEmployeeDetails(HashMap<String, String> employee) {

        CompanysNameLabel1.setText(Utility.getCompanyName());
        String firstName = employee.get(StaffTable.FNAME.toString());
        String lastName = employee.get(StaffTable.LNAME.toString());
        jLabel28.setText(firstName + " " + lastName + "'s Profile");
        SurnameLabel1.setText(lastName);
        FisrtNameLabel1.setText(firstName);
        MiddleNameLabel1.setText(employee.get(StaffTable.OTHER_NAMES.toString()));
        mStatusComboBox.setSelectedItem(employee.get(StaffTable.MARRITAL_STATUS.toString()));
        sexComboBox.setSelectedItem(employee.get(StaffTable.SEX.toString()));
        departmentComboBox.setSelectedItem(getDepartmentName(StaffTable.DEPARTMENT_ID.toString()));
        designationsComboBox.setSelectedItem(employee.get(StaffTable.DESIGNATION.toString()));
        long date = Long.parseLong(employee.get(StaffTable.DATE_JOINED.toString()));
        DateJoinedLabel1.setText(new Date(date).toString());
        PhoneNumberLabel1.setText(employee.get(StaffTable.PHONE.toString()));
        EmployeesEmailLabel1.setText(employee.get(StaffTable.EMAIL.toString()));
        ResidentialAddressTextArea1.setText(employee.get(StaffTable.RESIDENTIAL_ADDRESS.toString()));
        PermanentAddressTextArea1.setText(employee.get(StaffTable.PERMANENT_ADDRESS.toString()));

    }

    private void allowEdit() {
        //Set components editable
        mStatusComboBox.setEnabled(true);
        sexComboBox.setEnabled(true);
        departmentComboBox.setEnabled(true);
        designationsComboBox.setEnabled(true);
        ResidentialAddressTextArea1.setEditable(true);
        PermanentAddressTextArea1.setEditable(true);

        EditProfileButton.setText("Update");
        EditProfileButton.setActionCommand("update");
    }

    private HashMap<String, String> getEditedData() {
        HashMap<String, String> editedFields = new HashMap<>();
        if(anyFieldEdited){
            
        }
        return editedFields;
    }

    private void saveChanges() {
        if (anyFieldEdited) {
            //Save Edited Fields
            EditProfileButton.setEnabled(false);
            Runnable runnable = () -> {
                boolean fieldsSaved = DatabaseImpl
                        .updateEmployee(staffIDLabel.getText(), getEditedData());
                EditProfileButton.setEnabled(true);

                if (fieldsSaved) {
                    mStatusComboBox.setEnabled(false);
                    sexComboBox.setEnabled(false);
                    departmentComboBox.setEnabled(false);
                    designationsComboBox.setEnabled(false);
                    ResidentialAddressTextArea1.setEditable(false);
                    PermanentAddressTextArea1.setEditable(false);

                    EditProfileButton.setText("Edit");
                    EditProfileButton.setActionCommand("edit");
                    anyFieldEdited = false;
                }
            };
            Utility.getExecutorService().execute(runnable);

        } else {
            mStatusComboBox.setEnabled(false);
            sexComboBox.setEnabled(false);
            departmentComboBox.setEnabled(false);
            designationsComboBox.setEnabled(false);
            ResidentialAddressTextArea1.setEditable(false);
            PermanentAddressTextArea1.setEditable(false);

            EditProfileButton.setText("Edit");
            EditProfileButton.setActionCommand("edit");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        CompanysNameLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        SurnameLabel1 = new javax.swing.JLabel();
        FisrtNameLabel1 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        MiddleNameLabel1 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        DateJoinedLabel1 = new javax.swing.JLabel();
        PhoneNumberLabel1 = new javax.swing.JLabel();
        EmployeesEmailLabel1 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ResidentialAddressTextArea1 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        PermanentAddressTextArea1 = new javax.swing.JTextArea();
        EditProfileButton = new javax.swing.JButton();
        ProfileBackButton1 = new javax.swing.JButton();
        departmentComboBox = new javax.swing.JComboBox();
        sexComboBox = new javax.swing.JComboBox();
        designationsComboBox = new javax.swing.JComboBox();
        mStatusComboBox = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        staffIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CompanysNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CompanysNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanysNameLabel1.setText("Company Name");

        jLabel28.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Employee profile");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel65.setText("Surname:");

        SurnameLabel1.setText("Employee's Surname");

        FisrtNameLabel1.setText("Employee's Firstname");

        jLabel66.setText("First Name:");

        MiddleNameLabel1.setText("Employee's MiddleName");

        jLabel67.setText("Middle Name:");

        jLabel68.setText("Marrital Status:");

        DateJoinedLabel1.setText("Date");

        PhoneNumberLabel1.setText("080123334457");

        EmployeesEmailLabel1.setText("email");

        jLabel69.setText("Sex:");

        jLabel70.setText("Department:");

        jLabel71.setText("Designation:");

        jLabel72.setText("Date Joined:");

        jLabel73.setText("Phone:");

        jLabel74.setText("Email:");

        jLabel75.setText("Residential Address:");

        jLabel76.setText("Permanent Address:");

        ResidentialAddressTextArea1.setEditable(false);
        ResidentialAddressTextArea1.setColumns(20);
        ResidentialAddressTextArea1.setRows(5);
        ResidentialAddressTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(ResidentialAddressTextArea1);

        PermanentAddressTextArea1.setEditable(false);
        PermanentAddressTextArea1.setColumns(20);
        PermanentAddressTextArea1.setRows(5);
        PermanentAddressTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(PermanentAddressTextArea1);

        EditProfileButton.setText("Edit");
        EditProfileButton.setEnabled(false);
        EditProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileButtonActionPerformed(evt);
            }
        });

        ProfileBackButton1.setText("Ok");
        ProfileBackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileBackButton1ActionPerformed(evt);
            }
        });

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departmentComboBox.setEnabled(false);
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxValueChanged(evt);
            }
        });

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));
        sexComboBox.setEnabled(false);
        sexComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxValueChanged(evt);
            }
        });

        designationsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        designationsComboBox.setEnabled(false);
        designationsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxValueChanged(evt);
            }
        });

        mStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married", "Divorced", "Complicated" }));
        mStatusComboBox.setEnabled(false);
        mStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxValueChanged(evt);
            }
        });

        jLabel77.setText("Staff ID");

        staffIDLabel.setText("Employee's ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CompanysNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EditProfileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfileBackButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(PhoneNumberLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmployeesEmailLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateJoinedLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(designationsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(mStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FisrtNameLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MiddleNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SurnameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(staffIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CompanysNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(staffIDLabel))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(SurnameLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(FisrtNameLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(MiddleNameLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(mStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(designationsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(DateJoinedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneNumberLabel1)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeesEmailLabel1)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileBackButton1)
                    .addComponent(EditProfileButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfileButtonActionPerformed
        // TODO add your handling code here:
        if (EditProfileButton.getActionCommand().equalsIgnoreCase("edit")) {
            allowEdit();
        } else {
            saveChanges();
        }
    }//GEN-LAST:event_EditProfileButtonActionPerformed

    private void comboBoxValueChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxValueChanged
        // TODO add your handling code here:
        anyFieldEdited = true;
    }//GEN-LAST:event_comboBoxValueChanged

    private void textAreaValueChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaValueChanged
        // TODO add your handling code here:
        anyFieldEdited = true;
    }//GEN-LAST:event_textAreaValueChanged

    private void ProfileBackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileBackButton1ActionPerformed
        // TODO add your handling code here:
        saveChanges();
        setVisible(false);
    }//GEN-LAST:event_ProfileBackButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompanysNameLabel1;
    private javax.swing.JLabel DateJoinedLabel1;
    private javax.swing.JButton EditProfileButton;
    private javax.swing.JLabel EmployeesEmailLabel1;
    private javax.swing.JLabel FisrtNameLabel1;
    private javax.swing.JLabel MiddleNameLabel1;
    private javax.swing.JTextArea PermanentAddressTextArea1;
    private javax.swing.JLabel PhoneNumberLabel1;
    private javax.swing.JButton ProfileBackButton1;
    private javax.swing.JTextArea ResidentialAddressTextArea1;
    private javax.swing.JLabel SurnameLabel1;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox designationsComboBox;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JComboBox mStatusComboBox;
    private javax.swing.JComboBox sexComboBox;
    private javax.swing.JLabel staffIDLabel;
    // End of variables declaration//GEN-END:variables
}
