/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skool;

import Entities.LigneBus;
import Entities.Publication;
import Services.ServiceLigneBus;
import Services.ServicePublication;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hamza
 */
public class Skool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
    /*    User u1 = new User(1, "hamza.benbeya@esprit.tn","Ben Beya","Hamza","Admin");
        
        ServiceUser su = new ServiceUser();
    */
            String adresseDepart = "aaaa";
            String message = "bbbbb";
            java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String currentTime = sdf.format(dt);

       ServiceLigneBus slb = new ServiceLigneBus();
       LigneBus lb = new LigneBus (1,adresseDepart,20,currentTime);
slb.add(lb);



    }
    
}
