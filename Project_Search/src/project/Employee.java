package project;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class Employee extends javax.swing.JFrame {
    
    String selected;
    DefaultTableModel dtm;
    Connection connection;
    private static String username=" ";
    
    public Employee(String user) {
        initComponents();
        username = user;
        setLocationRelativeTo(null);
       
        comboBox.addItem("Salary");
        comboBox.addItem("First Name");
        
        // Search Code 
        lbl_search.getDocument().addDocumentListener(new DocumentListener() {    
           private void updateSuggestions() {
              DefaultTableModel ob = (DefaultTableModel) tbl_showData.getModel();
               TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
               tbl_showData.setRowSorter(obj);
               obj.setRowFilter(RowFilter.regexFilter(lbl_search.getText()));
               obj.setRowFilter(RowFilter.regexFilter("(?i)" + lbl_search.getText()));
           }

           @Override
           public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions();
           }

           @Override
           public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions();
           }

           @Override
           public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions();
           }
       });
        
        
        // Connection Code
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Factory", "root", "root");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, " Connection Failed");
        }

        // Columns names
        String[] column_names = {"ID", "First Name", "Last Name", "Salary", "Phone Number", "Department"};
        dtm = new DefaultTableModel(column_names, 0);

        fill_table();
        tbl_showData.setModel(dtm);
        tbl_showData.setForeground(new Color(0x395886));
        tbl_showData.setBackground(new Color(0xD5DEEF));
        fill_combo_box();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_search = new javax.swing.JTextField();
        btm_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_showData = new javax.swing.JTable();
        btm_add = new javax.swing.JButton();
        enter_first_name = new javax.swing.JTextField();
        first_name_label = new javax.swing.JLabel();
        last_name_label = new javax.swing.JLabel();
        enter_last_name = new javax.swing.JTextField();
        enter_phone_number = new javax.swing.JTextField();
        phone_number_label = new javax.swing.JLabel();
        salary_label = new javax.swing.JLabel();
        enter_salary = new javax.swing.JTextField();
        department_label = new javax.swing.JLabel();
        enter_department = new javax.swing.JComboBox<>();
        btm_update = new javax.swing.JButton();
        btm_delete = new javax.swing.JButton();
        sort_down = new javax.swing.JButton();
        sort_up = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(57, 88, 134));

        jPanel2.setBackground(new java.awt.Color(213, 222, 239));
        jPanel2.setForeground(new java.awt.Color(213, 222, 239));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 88, 134));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icons/icons8-employee-96.png"))); // NOI18N
        jLabel2.setText("Employees");

        lbl_search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 88, 134), 2, true));
        lbl_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_searchActionPerformed(evt);
            }
        });

        btm_back.setBackground(new java.awt.Color(57, 88, 134));
        btm_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btm_back.setForeground(new java.awt.Color(255, 255, 255));
        btm_back.setText("Back");
        btm_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_backActionPerformed(evt);
            }
        });

        tbl_showData.setForeground(new java.awt.Color(213, 222, 239));
        tbl_showData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_showData.setColumnSelectionAllowed(true);
        tbl_showData.setGridColor(new java.awt.Color(209, 201, 239));
        tbl_showData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_showDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_showData);
        tbl_showData.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btm_add.setBackground(new java.awt.Color(57, 88, 134));
        btm_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btm_add.setForeground(new java.awt.Color(255, 255, 255));
        btm_add.setText("Add");
        btm_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_addActionPerformed(evt);
            }
        });

        enter_first_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        enter_first_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_first_nameActionPerformed(evt);
            }
        });

        first_name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        first_name_label.setForeground(new java.awt.Color(57, 88, 134));
        first_name_label.setText("First Name");

        last_name_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        last_name_label.setForeground(new java.awt.Color(57, 88, 134));
        last_name_label.setText("Last Name");

        enter_last_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        enter_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_last_nameActionPerformed(evt);
            }
        });

        enter_phone_number.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        phone_number_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phone_number_label.setForeground(new java.awt.Color(57, 88, 134));
        phone_number_label.setText("Phone number");

        salary_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salary_label.setForeground(new java.awt.Color(57, 88, 134));
        salary_label.setText("Salary");

        enter_salary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        enter_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_salaryActionPerformed(evt);
            }
        });

        department_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        department_label.setForeground(new java.awt.Color(57, 88, 134));
        department_label.setText("Department");

        enter_department.setEditable(true);
        enter_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_departmentActionPerformed(evt);
            }
        });

        btm_update.setBackground(new java.awt.Color(57, 85, 134));
        btm_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btm_update.setForeground(new java.awt.Color(255, 255, 255));
        btm_update.setText("Update");
        btm_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_updateActionPerformed(evt);
            }
        });

        btm_delete.setBackground(new java.awt.Color(57, 88, 134));
        btm_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btm_delete.setForeground(new java.awt.Color(255, 255, 255));
        btm_delete.setText("Delete");
        btm_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_deleteActionPerformed(evt);
            }
        });

        sort_down.setBackground(new java.awt.Color(213, 222, 239));
        sort_down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icons/icons8-up-arrow-26.png"))); // NOI18N
        sort_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort_downActionPerformed(evt);
            }
        });

        sort_up.setBackground(new java.awt.Color(213, 222, 239));
        sort_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icons/icons8-down-arrow-26.png"))); // NOI18N
        sort_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort_upActionPerformed(evt);
            }
        });

        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(57, 88, 134));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btm_back))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(sort_up, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btm_add)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sort_down, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addComponent(btm_update)
                                .addGap(26, 26, 26)
                                .addComponent(btm_delete)
                                .addGap(19, 19, 19))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(671, 671, 671)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(first_name_label))
                                    .addComponent(last_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salary_label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phone_number_label, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(department_label, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enter_department, 0, 163, Short.MAX_VALUE)
                                    .addComponent(enter_phone_number)
                                    .addComponent(enter_salary)
                                    .addComponent(enter_last_name)
                                    .addComponent(enter_first_name)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel2)
                    .addContainerGap(766, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(first_name_label)
                            .addComponent(enter_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enter_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(last_name_label))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salary_label)
                            .addComponent(enter_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone_number_label)
                            .addComponent(enter_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enter_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(department_label))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sort_up, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btm_add)
                                    .addComponent(btm_update)
                                    .addComponent(btm_delete)))
                            .addComponent(sort_down, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btm_back)
                        .addGap(31, 31, 31))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(534, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fill_combo_box() {
        try {
            PreparedStatement statement = connection.prepareStatement("select Department_Name from department");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                enter_department.addItem(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fill_table() 
    {
        try {
            dtm.setRowCount(0);

            PreparedStatement statement = connection.prepareStatement("select first_name,last_name,salary,Phone_Number,ID,Department from employee");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                dtm.addRow(new Object[]{result.getString(5), result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(6)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btm_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_addActionPerformed
        // TODO add your handling code here:

        if (!enter_first_name.getText().isEmpty() && !enter_last_name.getText().isEmpty()
                && !enter_salary.getText().isEmpty() && !enter_phone_number.getText().isEmpty()) {
            try {

                String first_name = enter_first_name.getText();
                String last_name = enter_last_name.getText();
                double salary = Double.parseDouble(enter_salary.getText());
                String phone_number = enter_phone_number.getText();

                PreparedStatement statement = connection.prepareStatement("insert into employee (first_name,last_name,salary,phone_number,department) values (?,?,?,?,?)");

                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setDouble(3, salary);
                statement.setString(4, phone_number);
                statement.setString(5, enter_department.getSelectedItem().toString());

                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Added Successfully");
              
                fill_table();
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btm_addActionPerformed

    private void enter_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enter_departmentActionPerformed

    private void btm_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_backActionPerformed
        // TODO add your handling code here:
        new DashBoard(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_btm_backActionPerformed

    private void btm_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_updateActionPerformed
        // TODO add your handling code here:
        if (!enter_first_name.getText().isEmpty() && !enter_last_name.getText().isEmpty()
                && !enter_salary.getText().isEmpty() && !enter_phone_number.getText().isEmpty()) {
            try {
                String first_name = enter_first_name.getText();
                String last_name = enter_last_name.getText();
                double salary = Double.parseDouble(enter_salary.getText());
                String phone_number = enter_phone_number.getText();

                PreparedStatement statement = connection.prepareStatement("update employee set first_name=?,last_name=?,salary=?,phone_number=?,department=? where ID=?");

                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setDouble(3, salary);
                statement.setString(4, phone_number);
                statement.setString(5, enter_department.getSelectedItem().toString());
                statement.setString(6, tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 0).toString());
                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Updated Successfully");
              
                fill_table();
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btm_updateActionPerformed

    private void btm_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_deleteActionPerformed
        try {
            // TODO add your handling code here:
            
            PreparedStatement statement = connection.prepareStatement("delete from employee where ID=?");
            
           
            statement.setString(1, tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 0).toString());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
          
            fill_table();
            enter_first_name.setText("");
            enter_last_name.setText("");
            enter_salary.setText("");
            enter_phone_number.setText("");
            enter_department.setSelectedIndex(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btm_deleteActionPerformed

    private void enter_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enter_last_nameActionPerformed

    private void enter_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enter_salaryActionPerformed

    private void enter_first_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_first_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enter_first_nameActionPerformed

    private void tbl_showDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_showDataMouseClicked
        // TODO add your handling code here:
        enter_first_name.setText(tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 1).toString());
        enter_last_name.setText(tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 2).toString());
        enter_salary.setText(tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 3).toString());
        enter_phone_number.setText(tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 4).toString());
        enter_department.setSelectedItem(tbl_showData.getValueAt(tbl_showData.getSelectedRow(), 5));

    }//GEN-LAST:event_tbl_showDataMouseClicked

    private void lbl_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_searchActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_lbl_searchActionPerformed

    private void sort_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_upActionPerformed
        // TODO add your handling code here:
        selected = comboBox.getSelectedItem().toString();
        if (selected.equals("First Name"))
        {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee order by first_name desc");
                ResultSet result = statement.executeQuery();
                dtm.setRowCount(0);
                while (result.next()) {
                    dtm.addRow(new Object[]{result.getString(5), result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(6)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (selected.equals("Salary"))
        {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee order by salary desc");
               // statement.setString(1, com_box.getSelectedItem().toString());
                ResultSet result = statement.executeQuery();
                dtm.setRowCount(0);
                while (result.next()) {
                    dtm.addRow(new Object[]{result.getString(5), result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(6)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_sort_upActionPerformed

    private void sort_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_downActionPerformed
        // TODO add your handling code here:
         selected = comboBox.getSelectedItem().toString();
        if (selected.equals("First Name"))
        {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee order by first_name asc");
                ResultSet result = statement.executeQuery();
                dtm.setRowCount(0);
                while (result.next()) {
                    dtm.addRow(new Object[]{result.getString(5), result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(6)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (selected.equals("Salary"))
        {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee order by salary asc");
               // statement.setString(1, com_box.getSelectedItem().toString());
                ResultSet result = statement.executeQuery();
                dtm.setRowCount(0);
                while (result.next()) {
                    dtm.addRow(new Object[]{result.getString(5), result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(6)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      
    }//GEN-LAST:event_sort_downActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee(username).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btm_add;
    private javax.swing.JButton btm_back;
    private javax.swing.JButton btm_delete;
    private javax.swing.JButton btm_update;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel department_label;
    private javax.swing.JComboBox<String> enter_department;
    private javax.swing.JTextField enter_first_name;
    private javax.swing.JTextField enter_last_name;
    private javax.swing.JTextField enter_phone_number;
    private javax.swing.JTextField enter_salary;
    private javax.swing.JLabel first_name_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel last_name_label;
    private javax.swing.JTextField lbl_search;
    private javax.swing.JLabel phone_number_label;
    private javax.swing.JLabel salary_label;
    private javax.swing.JButton sort_down;
    private javax.swing.JButton sort_up;
    private javax.swing.JTable tbl_showData;
    // End of variables declaration//GEN-END:variables
}
