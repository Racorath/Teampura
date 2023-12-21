/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseproject;

/**
 *
 * @author Teampura
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton userButton;
    private JPasswordField passText;
    private JLabel userLabel, passLabel;
    private JTextArea userText;
    Connect con = new Connect();
    
    public Login() {
        setTitle("Login");
        setSize(425, 290);
        setLayout(null);
        
        // create labels and buttons
        userButton = new JButton("Login");
        passText = new JPasswordField(5);
        userLabel = new JLabel("Username");
        passLabel = new JLabel("Password");
        userText = new JTextArea(5, 5);

        // add components
        add(passText);
        add(userLabel);
        add(passLabel);
        add(userText);
        add(userButton);

        // set component bounds (only needed by Absolute Positioning)
        passText.setBounds(185, 120, 130, 35);
        userLabel.setBounds(85, 70, 100, 25);
        passLabel.setBounds(85, 120, 85, 35);
        userText.setBounds(185, 65, 130, 35);
        userButton.setBounds(185, 195, 130, 45);

        // add action listeners to the buttons
        userButton.addActionListener(new UserButtonActionListener());

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class UserButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Open UserHomepage when userButton is pressed
            User user = con.login(userText.getText(), new String(passText.getPassword())  );  
            if (user != null){
                Front frnt = new Front();
                frnt.setVisible(true);
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog( null,"Incorrect username/password.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}