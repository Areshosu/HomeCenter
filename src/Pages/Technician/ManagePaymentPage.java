/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.Technician;

import Models.Database;
import Models.Payment;
import Pages.LoginPage;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sphal
 */
public class ManagePaymentPage extends javax.swing.JFrame {

    /**
     * Creates new form ManagePaymentPage
     */
    public ManagePaymentPage() {
        initComponents();
        this.setVisible(true);
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.refreshTable();
    }
    
    private void refreshTable() {
        String[] columns = {"Technician Email", "Customer Email", "Payment Option", "Amount"};
        DefaultTableModel paymentTableModel = new DefaultTableModel();
        for (Payment payment: Database.getPayments()) {
            if (payment.getReceiverEmail().equals(LoginPage.technicianPage.getLoginEmail())) {
                paymentTableModel.addRow(new Object[] {
                    payment.getReceiverEmail(),
                    payment.getSenderEmail(),
                    payment.getPaymentOption(),
                    payment.getAmount()
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

        darkBluePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        bluePanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        sideBarHeading = new javax.swing.JLabel();
        lightBluePanel = new javax.swing.JPanel();
        firstLogo = new javax.swing.JLabel();
        secondLogo = new javax.swing.JLabel();
        thirdLogo = new javax.swing.JLabel();
        fourthLogo = new javax.swing.JLabel();
        topBarHeading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MANAGE PAYMENT");

        darkBluePanel.setBackground(new java.awt.Color(22, 25, 37));

        paymentTable.setBackground(new java.awt.Color(35, 57, 91));
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Technician Email", "Customer Email", "Payment Option", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymentTable.setGridColor(new java.awt.Color(35, 57, 91));
        paymentTable.setPreferredSize(new java.awt.Dimension(300, 235));
        jScrollPane1.setViewportView(paymentTable);

        javax.swing.GroupLayout darkBluePanelLayout = new javax.swing.GroupLayout(darkBluePanel);
        darkBluePanel.setLayout(darkBluePanelLayout);
        darkBluePanelLayout.setHorizontalGroup(
            darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(darkBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        darkBluePanelLayout.setVerticalGroup(
            darkBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, darkBluePanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bluePanel.setBackground(new java.awt.Color(35, 57, 91));

        backBtn.setBackground(new java.awt.Color(64, 110, 142));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        sideBarHeading.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        sideBarHeading.setForeground(new java.awt.Color(255, 255, 255));
        sideBarHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBarHeading.setText("Payment");

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bluePanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(backBtn))
                    .addGroup(bluePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(sideBarHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bluePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(sideBarHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );

        lightBluePanel.setBackground(new java.awt.Color(142, 168, 195));

        firstLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banks/master_visa.png"))); // NOI18N

        secondLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banks/master_card.png"))); // NOI18N

        thirdLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banks/public_bank.png"))); // NOI18N

        fourthLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banks/alliance.png"))); // NOI18N

        topBarHeading.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        topBarHeading.setForeground(new java.awt.Color(0, 0, 0));
        topBarHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topBarHeading.setText("<html>Invoices/<br>Receipt</html>");

        javax.swing.GroupLayout lightBluePanelLayout = new javax.swing.GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
            lightBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lightBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstLogo)
                .addGap(18, 18, 18)
                .addComponent(secondLogo)
                .addGap(18, 18, 18)
                .addComponent(thirdLogo)
                .addGap(18, 18, 18)
                .addComponent(fourthLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(topBarHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        lightBluePanelLayout.setVerticalGroup(
            lightBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lightBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lightBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(topBarHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourthLogo)
                    .addComponent(thirdLogo)
                    .addComponent(secondLogo)
                    .addComponent(firstLogo))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(darkBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lightBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(bluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lightBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(darkBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        LoginPage.technicianPage.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManagePaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePaymentPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel bluePanel;
    private javax.swing.JPanel darkBluePanel;
    private javax.swing.JLabel firstLogo;
    private javax.swing.JLabel fourthLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lightBluePanel;
    private javax.swing.JTable paymentTable;
    private javax.swing.JLabel secondLogo;
    private javax.swing.JLabel sideBarHeading;
    private javax.swing.JLabel thirdLogo;
    private javax.swing.JLabel topBarHeading;
    // End of variables declaration//GEN-END:variables
}
