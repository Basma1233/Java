package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Connexion {
      
    private static String url="jdbc:mysql://localhost:3306/3a3" ; //jdbc est un framework // 3306:port d'ecoute
    private static String usr="root";
    private static String pwd="";
    private static Connection cnx ;
    private static Connexion mycon;
    
    public static Connection getCnx(){
        return cnx;
    }
    
    private Connexion(){
        try{
        cnx=DriverManager.getConnection(url,usr,pwd); // creer une instance
           System.out.println("Connexion etablie!") ; 
    }
    catch (SQLException ex){
        Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
        public static Connexion getInstance(){
            if(mycon==null)
                mycon=new Connexion() ;
            return mycon ;
        }

    Statement CreateStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

