/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Models.Database;
import Models.User;
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
    JLabel usernameLabel, passwordLabel, roleLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JComboBox roleField;
    Button login, register, exit;
    
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String selectedRole = roleField.getSelectedItem().toString();
        User user = Database.findUser(username);
            
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == login) {
            if (user != null && user.getPassword().equals(password) && user.getRole().equals(selectedRole)) {
                JOptionPane.showMessageDialog(login, "Success");
                usernameField.setText("");
                passwordField.setText("");                
            } else {
                JOptionPane.showMessageDialog(login, "Invalid username or password");
            }
        } else if (e.getSource() == register) {
            if (user != null) {
                JOptionPane.showMessageDialog(login, "please select other name.");
                return;
            } else if (username.length() < 1 || password.length() < 1) {
                JOptionPane.showMessageDialog(register, "Please input valid username and password");
            }
            else {
                Database.addUser(new User(username, password, 0, null, null, selectedRole));
                Database.writeToUsers();
                JOptionPane.showMessageDialog(register, "Successfully registered (Please complete personal details in settings.)");
                usernameField.setText("");
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
        usernameLabel = new JLabel("username: ");
        passwordLabel = new JLabel("password: ");
        roleLabel = new JLabel("login as selected role: ");
        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(100, 30));
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(100, 30));
        roleField = new JComboBox(User.getRoles());
        roleField.setPreferredSize(new Dimension(200, 30));
        
        container.setLayout(new BorderLayout());
        panel.add(usernameLabel);
        panel.add(usernameField);
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
