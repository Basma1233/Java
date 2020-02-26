/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Services.EventService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField lieu;
    @FXML
    private TextField nbp;
    @FXML
    private TextField dd;
    @FXML
    private Button ajout;
    @FXML
    private TextField df;

    EventService evt = new EventService();
    public static int idEv ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Event e = new Event();
       e= evt.findEvenementById(idEv);
       titre.setText(e.getTitre());
       lieu.setText(e.getLieu());
        nbp.setText(String.valueOf(e.getNbp()));
        dd.setText(String.valueOf(e.getDateDebut()));
        df.setText(String.valueOf(e.getDateFin()));

        // TODO
    }    

   private void modif(ActionEvent event) throws SQLDataException {
        
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
                String t= titre.getText();
                String l= lieu.getText();
                int nbp= Integer.parseInt(this.nbp.getText());
                Date dd = java.sql.Date.valueOf(this.dd.getText());
                Date df = java.sql.Date.valueOf(this.df.getText());
                EventService Es= new EventService();
                Event e= new Event(idEv, t, l, nbp, nbp,(java.sql.Date) dd,(java.sql.Date) df);
                Es.modifierEvent(e, t, l, nbp, nbp, (java.sql.Date)dd,(java.sql.Date) df, 32);
                
                
                Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/Gui/AfficheEvents.fxml"));
                            Stage myWindow = (Stage)titre.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(ModifierEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
        
                
    }
    
}
