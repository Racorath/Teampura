/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseproject;

/**
 *
 * @author Raven Bengil
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends JFrame {
    private JTextField usernameField, passwordField, firstNameField, lastNameField;

    public Register() {
        // Set frame properties
        setTitle("Register");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame location to the center of the screen
        setLocationRelativeTo(null);

        // Create labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");

        // Create text fields
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();

        // Create buttons
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Add action listeners to buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Create panel for components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(submitButton);
        panel.add(clearButton);

        // Add panel to the frame
        add(panel);

        // Set frame visibility
        setVisible(true);
    }

    private void registerUser() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(username, password, first_name, last_name) VALUES (?, ?, ?, ?)");

            // Set values for the prepared statement
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            preparedStatement.setString(3, firstNameField.getText());
            preparedStatement.setString(4, lastNameField.getText());

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the connection
            connection.close();

            if (rowsAffected > 0) {
                // Display a success message
                JOptionPane.showMessageDialog(this, "Registered successfully!");

                // Clear the fields
                clearFields();

                // Open Front.java (assuming Front.java is in the same package)
                Front front = new Front();
                front.setVisible(true);

                // Close the current registration window
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error registering user. Please try again.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error registering user. Please try again.");
        }
    }

    private void clearFields() {
        // Clear text fields
        usernameField.setText("");
        passwordField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Register();
        });
    }
}