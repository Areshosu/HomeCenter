/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.Technician;

import Helper.ConfirmationPopup;
import Helper.DeselectOnReselectModel;
import Helper.SharedHelper;
import Helper.TableActionCellRenderer;
import Helper.WithConfirmPopup;
import Models.Appointment;
import Models.Database;
import Models.Service;
import Models.User;
import Pages.LoginPage;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class ManageAppointmentPage extends javax.swing.JFrame implements WithConfirmPopup {
    private static final String dateTimeFieldPlaceHolder = "eg. (12/03/2005, 5:10PM)";
    private int selectedRowIndex = -1;

    /**
     * Creates new form ManageAppointmentPage
     */
    public ManageAppointmentPage() {
        initComponents();
        this.setVisible(true);
        DefaultComboBoxModel customers = new DefaultComboBoxModel();
        DefaultComboBoxModel serviceModels = new DefaultComboBoxModel();
        DefaultComboBoxModel statusModels = new DefaultComboBoxModel();
        for (User user: Database.getUsers()) {
            if (user.getRole().equals("customer")) {
                customers.addElement(user);
            }
        }
        for (String status: User.getStatuses()) {
            statusModels.addElement(status);
        }
        

        Service[] services = Arrays.stream(Database.getServices())
                                .filter(svc -> svc.getTechnicianEmail().equals(LoginPage.technicianPage.getLoginEmail()))
                                .toArray(Service[]::new);
        
        for (Service service: services) {
            if (service.getTechnicianEmail().equals(LoginPage.technicianPage.getLoginEmail())) {
                serviceModels.addElement(service);
            }
        }
        
        User[] users = Arrays.stream(Database.getUsers())
                                .filter(usr -> usr.getRole().equals("customer"))
                                .toArray(User[]::new);
        
        custEmailField.setModel(customers);
        statusField.setModel(statusModels);
        serviceNameField.setModel(serviceModels);
        
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
                        custEmailField.setSelectedIndex(0);
                        statusField.setSelectedIndex(0);
                        startDateField.setText(dateTimeFieldPlaceHolder);
                        endDateField.setText(dateTimeFieldPlaceHolder);
                        return;
                    }
                    selectedRowIndex = appointmentTable.getSelectedRow();
                    
                    Service selectedService = Database.findService(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 0).toString());
                    User selectedCust = Database.findUser(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 1).toString());
                    String selectedStatus = appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 4).toString();
                    serviceNameField.setSelectedIndex(SharedHelper.indexOf(services, selectedService));
                    statusField.setSelectedIndex(SharedHelper.indexOf(User.getStatuses(), selectedStatus));
                    custEmailField.setSelectedIndex(SharedHelper.indexOf(users, selectedCust));
                    startDateField.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 2).toString());
                    endDateField.setText(appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 3).toString());                  
                    }
            }
        });
        
        ManageAppointmentPage self = this;
        appointmentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = appointmentTable.columnAtPoint(e.getPoint());
                if (column == 5) {
                    new ConfirmationPopup(self);
                }
            }
        });
    }
    
    @Override
    public void runCallbackForConfirmPopup() {
        Database.removeAppointment(this.selectedRowIndex);
        Database.writeToAppointments();
        refreshTable();
        formMessage.setText("Deleted successfully!");
        formMessage.setForeground(Color.GREEN);        
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        refreshTable();
    }
    
    public void refreshTable() {
    String[] columns = {"Service Name", "Cust Email", "Start DateTime", "End DateTime", "Status", "Action"};
    DefaultTableModel appointmentTableModel = new DefaultTableModel(columns, 0);
    TableActionCellRenderer actionRenderer = new TableActionCellRenderer();
    for (Appointment appointment: Database.getAppointments()) {
        if (appointment.getTechnicianEmail().equals(LoginPage.technicianPage.getLoginEmail())) {
            appointmentTableModel.addRow(new Object[] {
            appointment.getServiceName(),
            appointment.getCustomerEmail(),
            SharedHelper.dateToString(appointment.getStartingDateTime()),
            SharedHelper.dateToString(appointment.getEndingDateTime()),
            appointment.getStatus()
        });
        }
    }
        appointmentTable.setModel(appointmentTableModel);
        appointmentTable.getColumn("Action").setCellRenderer(actionRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bluePanel = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        serviceNameLabel = new javax.swing.JLabel();
        startDateField = new javax.swing.JTextField();
        endDateLabel = new javax.swing.JLabel();
        custEmailLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateField = new javax.swing.JTextField();
        createUpdateBtn = new javax.swing.JButton();
        endDateFieldMsg = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        startDateFieldMsg = new javax.swing.JLabel();
        formMessage = new javax.swing.JLabel();
        serviceNameField = new javax.swing.JComboBox<>();
        custEmailField = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();
        statusField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MANAGE APPOINTMENT");

        jPanel1.setBackground(new java.awt.Color(35, 57, 91));

        appointmentTable.setBackground(new java.awt.Color(64, 110, 142));
        appointmentTable.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        appointmentTable.setForeground(new java.awt.Color(255, 255, 255));
        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Cust Email", "Start DateTime", "End DateTime", "Status", "Action"
            }
        ));
        appointmentTable.setGridColor(new java.awt.Color(64, 110, 142));
        appointmentTable.setPreferredSize(new java.awt.Dimension(300, 355));
        appointmentTable.setRowHeight(30);
        bluePanel.setViewportView(appointmentTable);

        backBtn.setBackground(new java.awt.Color(64, 110, 142));
        backBtn.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        serviceNameLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        serviceNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        serviceNameLabel.setText("SERVICE NAME");

        startDateField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        startDateField.setText("eg. (12/03/2005, 5:10PM)");
        startDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startDateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                startDateFieldFocusLost(evt);
            }
        });
        startDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startDateFieldKeyReleased(evt);
            }
        });

        endDateLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        endDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        endDateLabel.setText("ENDING DATE");

        custEmailLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        custEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        custEmailLabel.setText("CUSTOMER EMAIL");

        startDateLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        startDateLabel.setText("STARTING DATE");

        endDateField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        endDateField.setText("eg. (12/03/2005, 5:10PM)");
        endDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                endDateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                endDateFieldFocusLost(evt);
            }
        });
        endDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                endDateFieldKeyReleased(evt);
            }
        });

        createUpdateBtn.setBackground(new java.awt.Color(64, 110, 142));
        createUpdateBtn.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        createUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        createUpdateBtn.setText("CREATE/UPDATE");
        createUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUpdateBtnActionPerformed(evt);
            }
        });

        endDateFieldMsg.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        endDateFieldMsg.setForeground(new java.awt.Color(255, 0, 0));

        headingLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setText("Appointments");

        startDateFieldMsg.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        startDateFieldMsg.setForeground(new java.awt.Color(255, 0, 0));

        formMessage.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        formMessage.setForeground(new java.awt.Color(255, 0, 0));

        serviceNameField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        serviceNameField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        custEmailField.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        custEmailField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        statusLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("STATUS");

        statusField.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        statusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(formMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(backBtn)
                        .addComponent(serviceNameLabel)
                        .addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(custEmailLabel)
                        .addComponent(startDateLabel)
                        .addComponent(endDateLabel)
                        .addComponent(endDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(serviceNameField, 0, 200, Short.MAX_VALUE)
                        .addComponent(custEmailField, 0, 200, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(createUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endDateFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(startDateFieldMsg)
                        .addGap(65, 65, 65)
                        .addComponent(endDateFieldMsg)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(headingLabel))
                        .addGap(24, 24, 24)
                        .addComponent(serviceNameLabel)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(custEmailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(startDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(endDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        LoginPage.technicianPage.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void createUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUpdateBtnActionPerformed
        String serviceTitle = serviceNameField.getSelectedItem().toString();
        String customerEmail = custEmailField.getSelectedItem().toString();
        LocalDateTime startDate = SharedHelper.isValidDateTime(startDateField.getText());
        LocalDateTime endDate = SharedHelper.isValidDateTime(endDateField.getText());
        String status = statusField.getSelectedItem().toString();
        
        if (serviceTitle.length() < 1 ||
                    customerEmail.length() < 1 ||
                    startDate == null ||
                    endDate == null) {
            formMessage.setText("Invalid details, please try again.");
            formMessage.setForeground(Color.red);
            return;
        }
        
        Appointment appointment = new Appointment(serviceTitle, customerEmail, LoginPage.technicianPage.getLoginEmail(), startDate, endDate, status);
        if (selectedRowIndex != -1) {
            Database.updateAppointment(appointment, selectedRowIndex);
            formMessage.setText("Successfully updated!");
        } else {
            Database.addAppointment(appointment);
            formMessage.setText("Successfully added!");            
        }
        
        Database.writeToAppointments();
        refreshTable();
        formMessage.setForeground(Color.green);
    }//GEN-LAST:event_createUpdateBtnActionPerformed

    private void startDateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDateFieldKeyReleased
        if (SharedHelper.isValidDateTime(startDateField.getText()) == null) {
            startDateFieldMsg.setText("Invalid date time");
        } else {
            startDateFieldMsg.setText("");
        }
    }//GEN-LAST:event_startDateFieldKeyReleased

    private void endDateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endDateFieldKeyReleased
        if (SharedHelper.isValidDateTime(endDateField.getText()) == null) {
            endDateFieldMsg.setText("Invalid date time");
        } else {
            endDateFieldMsg.setText("");
        }
    }//GEN-LAST:event_endDateFieldKeyReleased

    private void startDateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startDateFieldFocusGained
        if (startDateField.getText().equals(dateTimeFieldPlaceHolder)) {
            startDateField.setText("");
        }
    }//GEN-LAST:event_startDateFieldFocusGained

    private void startDateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startDateFieldFocusLost
        if (startDateField.getText().equals("")) {
            startDateField.setText(dateTimeFieldPlaceHolder);
        }
    }//GEN-LAST:event_startDateFieldFocusLost

    private void endDateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endDateFieldFocusGained
        if (endDateField.getText().equals(dateTimeFieldPlaceHolder)) {
            endDateField.setText("");
        }
    }//GEN-LAST:event_endDateFieldFocusGained

    private void endDateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endDateFieldFocusLost
        if (endDateField.getText().equals("")) {
            endDateField.setText(dateTimeFieldPlaceHolder);
        }
    }//GEN-LAST:event_endDateFieldFocusLost

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
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane bluePanel;
    private javax.swing.JButton createUpdateBtn;
    private javax.swing.JComboBox<String> custEmailField;
    private javax.swing.JLabel custEmailLabel;
    private javax.swing.JTextField endDateField;
    private javax.swing.JLabel endDateFieldMsg;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel formMessage;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> serviceNameField;
    private javax.swing.JLabel serviceNameLabel;
    private javax.swing.JTextField startDateField;
    private javax.swing.JLabel startDateFieldMsg;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JComboBox<String> statusField;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
