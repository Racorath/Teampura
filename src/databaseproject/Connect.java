/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abram
 */



public class Connect {
    Connection con = null;
    
    public Connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            JOptionPane.showMessageDialog(null, "Connected na!");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User login(String username, String password){
        Statement s;
        String sql;
        ResultSet r;
        User u = null;
        try {
            s = con.createStatement();
            sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            r = s.executeQuery(sql);
            if (r.next() == true)
                 u = new User(username, password, r.getString("first_name"), r.getString("last_name"));
                return u;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Incorrect username/password.");
        return null;
    }
    public boolean insertRecord(BookRecord books){
        Statement s;
        String sql;
        try {
            s = con.createStatement();                       
            sql = "INSERT INTO books VALUES('" 
                + books.getRollNumber() + "', '" 
                + books.getName() + "', '" 
                + books.getCourse() + "', '" 
                + books.getSemester() + "', '" 
                + books.getEmail() + "', '" 
                + books.getPhoneNumber() + "', '"  
                + books.getBookTitle() + "', '"       
                + books.getBookAuthor() + "', '"    
                + books.getBookId() + "', '"      
                + books.getAbout() + "', '"      
                + books.getEdition() + "')";
                s.executeUpdate(sql); 
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
