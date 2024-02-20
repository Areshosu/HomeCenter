/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.Manager;

import Helper.DeselectOnReselectModel;
import Helper.SharedHelper;
import Models.Appointment;
import Models.Database;
import Models.Service;
import Models.User;
import Pages.MainMenuPage;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sphal
 */
public class ManageAppointmentPage extends javax.swing.JFrame {

    private static final String dateTimeFieldPlaceHolder = "eg. (12/03/2005, 5:10PM)";
    private int selectedRowIndex = -1;
    /**
     * Creates new form ManageAppointmentPage
     */
    public ManageAppointmentPage() {
        initComponents();
        
        appointmentTable.setSelectionModel(new DeselectOnReselectModel());
        appointmentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    if (selectedRowIndex == appointmentTable.getSelectedRow()) {
                        selectedRowIndex = -1;
                        appointmentTable.getSelectionModel().clearSelection();
                    }
                    if (appointmentTable.getSelectedRow() == -1) {
                        serviceNameField.setSelectedIndex(0);
                        customerEmailField.setSelectedIndex(0);
                        technicianEmailField.setSelectedIndex(0);
                        startingDateField.setText(dateTimeFieldPlaceHolder);
                        endingDateField.setText(dateTimeFieldPlaceHolder);                    
                        return;
                    }                
                    selectedRowIndex = appointmentTable.getSelectedRow();
                    
                    String service = appointmentTable.getValueAt(selectedRowIndex, 0).toString();
                    String[] services = Arrays.stream(Database.getServices()).map(Service::toString).toArray(String[]::new);
                    serviceNameField.setSelectedIndex(SharedHelper.indexOf(services, service));
                    String customerEmail = appointmentTable.getValueAt(selectedRowIndex, 1).toString();
                    String[] customerEmails = Arrays.stream(Database.getUsers()).filter(user -> user.getRole().equals("customer")).map(User::toString).toArray(String[]::new);
                    String technicianEmail = appointmentTable.getValueAt(selectedRowIndex, 2).toString();
                    String[] technicianEmails = Arrays.stream(Database.getUsers()).filter(user -> user.getRole().equals("technician")).map(User::toString).toArray(String[]::new);
                    customerEmailField.setSelectedIndex(SharedHelper.indexOf(customerEmails, customerEmail));
                    technicianEmailField.setSelectedIndex(SharedHelper.indexOf(technicianEmails, technicianEmail));
                    startingDateField.setText(appointmentTable.getValueAt(selectedRowIndex, 3).toString());
                    endingDateField.setText(appointmentTable.getValueAt(selectedRowIndex, 4).toString());                    
                }
            }
        });
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        
        this.refreshTable();
        this.refreshEmailsSelection();
        this.refreshServicesSelection();
    }
    
    private void refreshTable() {
        String[] columns = {"service name", "cust email", "tech email", "start date", "end date"};
        DefaultTableModel appointmentTableModel = new DefaultTableModel(columns, 0);
            for (Appointment appointment: Database.getAppointments()) {
                appointmentTableModel.addRow(new Object[] {
                    appointment.getServiceName(),
                    appointment.getCustomerEmail(),
                    appointment.getTechnicianEmail(),
                    SharedHelper.dateToString(appointment.getStartingDateTime()),
                    SharedHelper.dateToString(appointment.getEndingDateTime())
                });
            }            
        appointmentTable.setModel(appointmentTableModel);      
    }
    
    private void refreshEmailsSelection() {
        DefaultComboBoxModel customerModels = new DefaultComboBoxModel();
        DefaultComboBoxModel technicianModels = new DefaultComboBoxModel();
        for (User user: Database.getUsers()) {
            if (user.getRole().equals("customer")) {
                customerModels.addElement(user);
            } else if (user.getRole().equals("technician")) {
                technicianModels.addElement(user);
            }
        }
        customerEmailField.setModel(customerModels);
        technicianEmailField.setModel(technicianModels);          
    }
    
    private void refreshServicesSelection() {
        DefaultComboBoxModel serviceModels = new DefaultComboBoxModel();
        for (Service service: Database.getServices()) {
            serviceModels.addElement(service);
        }
        serviceNameField.setModel(serviceModels);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        appointmentListingLabel = new javax.swing.JLabel();
        serviceNameLabel = new javax.swing.JLabel();
        customerEmailLabel = new javax.swing.JLabel();
        technicianEmailLabel = new javax.swing.JLabel();
        startingDateLabel = new javax.swing.JLabel();
        startingDateField = new javax.swing.JTextField();
        endingDateLabel = new javax.swing.JLabel();
        endingDateField = new javax.swing.JTextField();
        createUpdateBtn = new javax.swing.JButton();
        formMessage = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        startDateValidateMsg = new javax.swing.JLabel();
        endDateValidateMsg = new javax.swing.JLabel();
        customerEmailField = new javax.swing.JComboBox<>();
        technicianEmailField = new javax.swing.JComboBox<>();
        serviceNameField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "service name", "cust email", "tech email", "start date", "end date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(appointmentTable);

        appointmentListingLabel.setText("APPOINTMENT LISTING");

        serviceNameLabel.setText("Service Name");

        customerEmailLabel.setText("Customer Email");

        technicianEmailLabel.setText("Technician Email");

        startingDateLabel.setText("Starting Date");

        startingDateField.setText(dateTimeFieldPlaceHolder);
        startingDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startingDateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                startingDateFieldFocusLost(evt);
            }
        });
        startingDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startingDateFieldKeyReleased(evt);
            }
        });

        endingDateLabel.setText("Ending Date");

        endingDateField.setText(dateTimeFieldPlaceHolder);
        endingDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                endingDateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                endingDateFieldFocusLost(evt);
            }
        });
        endingDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endingDateFieldActionPerformed(evt);
            }
        });
        endingDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                endingDateFieldKeyReleased(evt);
            }
        });

        createUpdateBtn.setText("CREATE/UPDATE");
        createUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUpdateBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        startDateValidateMsg.setForeground(new java.awt.Color(255, 51, 0));

        endDateValidateMsg.setForeground(new java.awt.Color(255, 51, 0));

        customerEmailField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerEmailField.setToolTipText("");

        technicianEmailField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        serviceNameField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointmentListingLabel)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(formMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(technicianEmailField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startingDateField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endingDateField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createUpdateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(startingDateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(startDateValidateMsg))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(endingDateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(endDateValidateMsg)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(serviceNameField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(customerEmailField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(serviceNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customerEmailLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(technicianEmailLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(appointmentListingLabel)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(serviceNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerEmailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(technicianEmailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(technicianEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startingDateLabel)
                            .addComponent(startDateValidateMsg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startingDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endingDateLabel)
                            .addComponent(endDateValidateMsg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endingDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createUpdateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formMessage)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void endingDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endingDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endingDateFieldActionPerformed

    private void createUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUpdateBtnActionPerformed
        String serviceName = serviceNameField.getSelectedItem().toString();
        String customerEmail = customerEmailField.getSelectedItem().toString();
        String technicianEmail = technicianEmailField.getSelectedItem().toString();
        LocalDateTime startDate = SharedHelper.isValidDateTime(startingDateField.getText());
        LocalDateTime endDate = SharedHelper.isValidDateTime(endingDateField.getText());
        
        formMessage.setForeground(Color.RED);
        if (serviceName.length() < 1 ||
                !SharedHelper.isValidEmail(customerEmail) ||
                !SharedHelper.isValidEmail(technicianEmail) ||
                startDate == null ||
                endDate == null) {
            if (startDate == null) {
                startDateValidateMsg.setText("Invalid date time");
            }
            if (endDate == null) {
                endDateValidateMsg.setText("Invalid date time");
            }
            formMessage.setText("Invalid, please try again.");
            return;
        }
        
        
        Appointment appointment = new Appointment(serviceName, customerEmail, technicianEmail, startDate, endDate);
        formMessage.setForeground(Color.GREEN);
        if (selectedRowIndex != -1) {
            Database.updateAppointment(appointment, selectedRowIndex);
            formMessage.setText("Updated Successfully!");
        } else {
            Database.addAppointment(appointment);
            formMessage.setText("Created Successfully!");
        }
        Database.writeToAppointments();
        this.refreshTable();
    }//GEN-LAST:event_createUpdateBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        MainMenuPage.managerPage.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void startingDateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startingDateFieldFocusLost
        if (startingDateField.getText().equals("")) {
            startingDateField.setText(dateTimeFieldPlaceHolder);
        }
    }//GEN-LAST:event_startingDateFieldFocusLost

    private void startingDateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startingDateFieldFocusGained
        if (startingDateField.getText().equals(dateTimeFieldPlaceHolder)) {
            startingDateField.setText("");
        }
    }//GEN-LAST:event_startingDateFieldFocusGained

    private void endingDateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endingDateFieldFocusGained
        if (endingDateField.getText().equals(dateTimeFieldPlaceHolder)) {
            endingDateField.setText("");
        }
    }//GEN-LAST:event_endingDateFieldFocusGained

    private void endingDateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endingDateFieldFocusLost
        if (endingDateField.getText().equals("")) {
            endingDateField.setText(dateTimeFieldPlaceHolder);
        }
    }//GEN-LAST:event_endingDateFieldFocusLost

    private void startingDateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startingDateFieldKeyReleased
        if (SharedHelper.isValidDateTime(startingDateField.getText()) == null) {
            startDateValidateMsg.setText("Invalid date time");
        } else {
            startDateValidateMsg.setText("");
        }
    }//GEN-LAST:event_startingDateFieldKeyReleased

    private void endingDateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endingDateFieldKeyReleased
        if (SharedHelper.isValidDateTime(endingDateField.getText()) == null) {
            endDateValidateMsg.setText("Invalid date time");
        } else {
            endDateValidateMsg.setText("");
        }
    }//GEN-LAST:event_endingDateFieldKeyReleased

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
            java.util.logging.Logger.getLogger(ManageAppointmentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAppointmentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAppointmentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAppointmentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAppointmentPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentListingLabel;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton createUpdateBtn;
    private javax.swing.JComboBox<String> customerEmailField;
    private javax.swing.JLabel customerEmailLabel;
    private javax.swing.JLabel endDateValidateMsg;
    private javax.swing.JTextField endingDateField;
    private javax.swing.JLabel endingDateLabel;
    private javax.swing.JLabel formMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> serviceNameField;
    private javax.swing.JLabel serviceNameLabel;
    private javax.swing.JLabel startDateValidateMsg;
    private javax.swing.JTextField startingDateField;
    private javax.swing.JLabel startingDateLabel;
    private javax.swing.JComboBox<String> technicianEmailField;
    private javax.swing.JLabel technicianEmailLabel;
    // End of variables declaration//GEN-END:variables
}
