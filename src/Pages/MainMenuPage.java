/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Pages.Technician.TechnicianPage;
import Pages.Customer.CustomerPage;
import Helper.SharedHelper;
import Models.Database;
import Models.User;
import Pages.Manager.ManagerPage;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author sphal
 */
public class MainMenuPage implements ActionListener {
    JFrame container;
    JPanel panel;
    JLabel emailLabel, passwordLabel, roleLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JComboBox roleField;
    Button login, register, exit;
    
    public static CustomerPage customerPage;
    public static TechnicianPage technicianPage;
    
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String selectedRole = roleField.getSelectedItem().toString();
        User user = Database.findUser(email);
            
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == login) {
            if (user != null && user.getPassword().equals(password) && user.getRole().equals(selectedRole)) { 
                JOptionPane.showMessageDialog(login, "Success");
                emailField.setText("");
                passwordField.setText("");    
                if (selectedRole == "customer"){
                    customerPage = new CustomerPage();
                    customerPage.setVisible(true);
                    container.setVisible(false);
                }else if (selectedRole == "technician"){
                    technicianPage = new TechnicianPage();
                    technicianPage.setVisible(true);
                    container.setVisible(false);
                emailField.setText("");
                passwordField.setText("");
                } else if (selectedRole.equals("manager")) {
                    ManagerPage managerPage = new ManagerPage();
                    managerPage.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(login, "Invalid email or password");
            }
        } else if (e.getSource() == register) {
            if (user != null) {
                JOptionPane.showMessageDialog(login, "please use other email.");
                return;
            } else if (!SharedHelper.isValidEmail(email) || password.length() < 1) {
                JOptionPane.showMessageDialog(register, "Please input valid email and password");
            }
            else {
                Database.addUser(new User("New User :D", password, "60123456789", email, "", selectedRole));
                Database.writeToUsers();
                JOptionPane.showMessageDialog(register, "Successfully registered (Please complete personal details in settings.)");
                emailField.setText("");
                passwordField.setText("");
                return;
            }
        }
    }
    
    public MainMenuPage() {
        container = new JFrame("Main Menu");
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);
        container.setSize(400, 500);
        container.setLocation(500, 500);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        TitledBorder groupBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80), "Login / Register");
        groupBorder.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(groupBorder);
        
        login = new Button("Login");
        login.setPreferredSize(new Dimension(60, 30));
        login.addActionListener(this);
        register = new Button("Register");
        register.setPreferredSize(new Dimension(60, 30));
        register.addActionListener(this);
        exit = new Button("Exit");
        exit.setPreferredSize(new Dimension(60, 30));
        exit.addActionListener(this);
        emailLabel = new JLabel("email: ");
        passwordLabel = new JLabel("password: ");
        roleLabel = new JLabel("login as selected role: ");
        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(100, 30));
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(100, 30));
        roleField = new JComboBox(User.getRoles());
        roleField.setPreferredSize(new Dimension(200, 30));
        
        container.setLayout(new BorderLayout());
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(roleLabel);
        panel.add(roleField);
        panel.add(login);
        panel.add(register);
        panel.add(exit);        
        container.add(panel, BorderLayout.CENTER);
        container.setVisible(true);
    }
}
