/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pi;

import com.sun.jndi.ldap.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ProjetPi {
    private static String url="jdbc:mysql://localhost/skool";
    private static String usr="root ";
    private static String pwd="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        try {
            java.sql.Connection cnx = DriverManager.getConnection(url,usr,pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetPi.class.getName()).log(Level.SEVERE, null, ex);
        }
             
                    
    }
    
}
