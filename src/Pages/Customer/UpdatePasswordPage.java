/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.Customer;

import Models.Database;
import Models.User;
import java.awt.Color;
/**
 *
 * @author yyhao0422
 */
public class UpdatePasswordPage extends javax.swing.JFrame {

    /**
     * Creates new form UpdatePasswordPage
     */
    
    public String email;
    
    public UpdatePasswordPage() {
        initComponents();
    }
    
    public void setLoginEmail(String email){
        this.email = email;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        handleUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        confirmNewPasswordField = new javax.swing.JTextField();
        handleExot = new javax.swing.JButton();
        formMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        handleUpdate.setText("Update");
        handleUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleUpdateActionPerformed(evt);
            }
        });

        jLabel1.setText("New Password :");

        newPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Confirm Password :");

        confirmNewPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmNewPasswordFieldActionPerformed(evt);
            }
        });

        handleExot.setText("Cancel");
        handleExot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleExotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(handleExot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(handleUpdate)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(confirmNewPasswordField)))
                            .addComponent(formMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handleUpdate)
                    .addComponent(handleExot))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmNewPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmNewPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmNewPasswordFieldActionPerformed

    private void handleUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleUpdateActionPerformed
        // TODO add your handling code here:
        
        
        if(newPasswordField.getText().isEmpty()){
            formMessage.setText("Invalid password, no empty password allowed");
            formMessage.setForeground(Color.red);
        }else if(newPasswordField.getText().equals(confirmNewPasswordField.getText())){
            User user = Database.findUser(email);
            user.setPassword(newPasswordField.getText());
            Database.updateUser(user,email);
            Database.writeToUsers();
            this.setVisible(false);
        }else{
            formMessage.setText("Incorrect confirm password, please enter same password.");
            formMessage.setForeground(Color.red);
        }
        
    }//GEN-LAST:event_handleUpdateActionPerformed

    private void handleExotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleExotActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_handleExotActionPerformed

    private void newPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePasswordPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmNewPasswordField;
    private javax.swing.JLabel formMessage;
    private javax.swing.JButton handleExot;
    private javax.swing.JButton handleUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField newPasswordField;
    // End of variables declaration//GEN-END:variables
}
