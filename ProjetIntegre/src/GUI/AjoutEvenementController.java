/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Services.EventService;
import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.Date;
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

public class AjoutEvenementController implements Initializable {

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

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
       public TextField getTitre() {
        return titre;
    }

    public TextField getLieu() {
        return lieu;
    }

    public TextField getNbp() {
        return nbp;
    }

    public TextField getDd() {
        return dd;
    }

    public Button getAjout() {
        return ajout;
    }

    public TextField getDf() {
        return df;
    }

    
    public void setTitre(TextField titre) {
        this.titre = titre;
        // TODO
    }  

    public void setLieu(TextField lieu) {
        this.lieu = lieu;
    }

    public void setNbp(TextField nbp) {
        this.nbp = nbp;
    }

    public void setDd(TextField dd) {
        this.dd = dd;
    }

    public void setAjout(Button ajout) {
        this.ajout = ajout;
    }

    /**
     * Initializes the controller class.
     */
    public void setDf(TextField df) {    
        this.df = df;
    }
    
     @FXML
    private void ajout(ActionEvent event) throws IOException, AWTException {
        
                String t= titre.getText();
                String l= lieu.getText();
                int nbpl= Integer.parseInt(nbp.getText());
                Date datedebut = java.sql.Date.valueOf(this.dd.getText());
                Date datefin = java.sql.Date.valueOf(this.df.getText());
                EventService es=new EventService();
                Event e= new Event(t, l, nbpl, datedebut, datefin);
                es.ajouterEvent(e);
                
    
               
                
                

      
           Parent root = FXMLLoader.load(getClass().getResource("/GUI/AfficheEvents.fxml"));
            
            Stage myWindow = (Stage)titre.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            myWindow.show();
        
         
                Notification.sendNotification("Module event", "event has been aafected ",TrayIcon.MessageType.INFO);
             
                
}

}