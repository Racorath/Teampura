/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import javax.swing.SwingUtilities;

/**
 *
 * @author Teampura
 */
public class DataBaseProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Connect connection = new Connect();
            SwingUtilities.invokeLater(() -> {
            new WelcomePage();
        });
    }
    
}
