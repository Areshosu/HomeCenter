/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.Customer;

import Models.Database;
import Models.Payment;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yyhao0422
 */
public class PaymentHistoryPage extends javax.swing.JFrame {

    /**
     * Creates new form PaymentHistoryPage
     */
    
    public String email;
    
    public void setLoginEmail(String email) {
        this.email = email;
    }
    
    
    public PaymentHistoryPage() {
        initComponents();
    }
    
    public void populatePaymentData(){
        
        if(email != null){
        
            Payment[] payments = Database.getPaymentsCustomer(email);
            String[] columns = {"Amount","Payment Option","Sender Email","Receiver Email"};
            
            DefaultTableModel paymentTableModel = new DefaultTableModel(columns,0);
        
            for (Payment payment:payments){
                paymentTableModel.addRow(new Object[]{
                    payment.getAmount(),
                    payment.getPaymentOption(),
                    payment.getSenderEmail(),
                    payment.getReceiverEmail(),
                });         
            }
            
            paymentTable.setModel(paymentTableModel);
            
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        handleExitButton = new javax.swing.JButton();
        bluePanel = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        handleExitButton.setText("Exit");
        handleExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleExitButtonActionPerformed(evt);
            }
        });

        paymentTable.setBackground(new java.awt.Color(64, 110, 142));
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "Payment Option", "Sender Email", "Reciever Email"
            }
        ));
        paymentTable.setGridColor(new java.awt.Color(64, 110, 142));
        paymentTable.setPreferredSize(new java.awt.Dimension(300, 335));
        paymentTable.setRowHeight(30);
        bluePanel.setViewportView(paymentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(handleExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(handleExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleExitButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_handleExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentHistoryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bluePanel;
    private javax.swing.JButton handleExitButton;
    private javax.swing.JTable paymentTable;
    // End of variables declaration//GEN-END:variables
}
