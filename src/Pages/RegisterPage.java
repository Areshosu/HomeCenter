/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Helper.SharedHelper;
import Models.Database;
import Models.User;
import homeappservice.HomeAppService;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Shiro
 */
public class RegisterPage extends javax.swing.JFrame {

    /**
     * Creates new form RegisterPage
     */
    public RegisterPage() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        darkBluePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        APULogo = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        twitterLogo = new javax.swing.JLabel();
        bluePanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        formMessage = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        alreadyRegisterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTER");

        darkBluePanel.setBackground(new java.awt.Color(22, 25, 37));

        titleLabel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("WELCOME BACK");

        APULogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/APU.png"))); // NOI18N

        descriptionLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        descriptionLabel.setText("<html><center>Empowering Service Excellence: Streamlining APU<br>Hostel Home Appliances Service Centre Operations.<br> Seamlessly Register, Book, Pay, and Provide<br>Feedback for Servicing Appointments. <br> Object-Oriented Efficiency for <br>Enhanced User Experience.</center></html>");
        descriptionLabel.setToolTipText("");

        twitterLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/twitter.png"))); // NOI18N
        twitterLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twitterLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout darkBluePanelLayout = new javax.swing.GroupLayout(darkBluePanel);
        darkBluePanel.setLayout(darkBluePanelLayout);
        darkBluePanelLayout.setHorizontalGroup(
            darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(darkBluePanelLayout.createSequentialGroup()
                .addGroup(darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(darkBluePanelLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(darkBluePanelLayout.createSequentialGroup()
                        .addGroup(darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(darkBluePanelLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(APULogo))
                            .addGroup(darkBluePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(twitterLogo))
                            .addGroup(darkBluePanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(titleLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        darkBluePanelLayout.setVerticalGroup(
            darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(darkBluePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(APULogo)
                .addGap(18, 18, 18)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(twitterLogo)
                .addContainerGap())
        );

        bluePanel.setBackground(new java.awt.Color(35, 57, 91));

        emailLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("EMAIL");

        passwordLabel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("PASSWORD");

        formMessage.setFont(new java.awt.Font("Perpetua Titling MT", 0, 10)); // NOI18N
        formMessage.setForeground(new java.awt.Color(255, 0, 0));

        registerBtn.setBackground(new java.awt.Color(64, 110, 142));
        registerBtn.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        alreadyRegisterBtn.setBackground(new java.awt.Color(51, 51, 51));
        alreadyRegisterBtn.setFont(new java.awt.Font("Perpetua Titling MT", 0, 8)); // NOI18N
        alreadyRegisterBtn.setForeground(new java.awt.Color(255, 255, 255));
        alreadyRegisterBtn.setText("Already registered?");
        alreadyRegisterBtn.setBorderPainted(false);
        alreadyRegisterBtn.setOpaque(false);
        alreadyRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alreadyRegisterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(emailField)
                        .addComponent(emailLabel)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField)
                        .addComponent(formMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addComponent(alreadyRegisterBtn))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(emailLabel)
                .addGap(18, 18, 18)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formMessage)
                .addGap(18, 18, 18)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alreadyRegisterBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(darkBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(darkBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alreadyRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alreadyRegisterBtnActionPerformed
        this.setVisible(false);
        HomeAppService.loginPage.setVisible(true);
    }//GEN-LAST:event_alreadyRegisterBtnActionPerformed

    private void twitterLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twitterLogoMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://twitter.com/AsiaPacificU").toURI());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_twitterLogoMouseClicked

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        
        formMessage.setForeground(Color.RED);
        if (!SharedHelper.isValidEmail(email)) {
            formMessage.setText("invalid email");
            return;
        } else if (password.length() < 1) {
            formMessage.setText("invalid password");
            return;
        } else if (Database.findUser(email) != null) {
            formMessage.setText("email already registered");
            return;
        }
        
        emailField.setText("");
        passwordField.setText("");
        
        User newUser = new User("New User :D", password, "0123456789", email, "", "customer");
        Database.addUser(newUser);
        Database.writeToUsers();
        
        formMessage.setForeground(Color.GREEN);
        formMessage.setText("Registered Successfully! Redirecting in 3s");
        
        RegisterPage self = this;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                self.setVisible(false);
                HomeAppService.loginPage.setVisible(true);
            }
        }, 2000);
    }//GEN-LAST:event_registerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APULogo;
    private javax.swing.JButton alreadyRegisterBtn;
    private javax.swing.JPanel bluePanel;
    private javax.swing.JPanel darkBluePanel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel formMessage;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel twitterLogo;
    // End of variables declaration//GEN-END:variables
}
