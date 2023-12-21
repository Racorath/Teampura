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

public class WelcomePage extends JFrame {
    JButton logInButton;

    public WelcomePage() {
        setTitle("Library Management System");
        setSize(600, 400);

        // create welcome label
        JLabel welcomeLabel = new JLabel("Welcome! by Teampura");
        welcomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 32));

        // create image panel
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center the components

        // Load image using getResource
        ImageIcon libraryIcon = new ImageIcon(getClass().getResource("/databaseproject/library.png"));
        Image scaledImage = libraryIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledLibraryIcon = new ImageIcon(scaledImage);
        JLabel libraryLabel = new JLabel(scaledLibraryIcon);
        imagePanel.add(libraryLabel);

        // create buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        logInButton = new JButton("Log In");
        buttonsPanel.add(logInButton);

        // create main panel and add components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(welcomeLabel);
        mainPanel.add(imagePanel);
        mainPanel.add(buttonsPanel);

        // add main panel to the window
        add(mainPanel);

        logInButton.addActionListener(new LoginActionListener());

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // You can replace this with your login logic
            Login login = new Login();
            login.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomePage();
        });
    }
}
