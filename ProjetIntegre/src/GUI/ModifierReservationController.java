/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ModifierReservationController implements Initializable {

    @FXML
    private DatePicker datereservation;
    @FXML
    private ChoiceBox  choiceType;
    @FXML
    private TextField nbrplace;
    @FXML
    private Button update;
    
    public static int idRese ;
    
    ReservationService rs = new ReservationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                Reservation r = rs.findReservatinById(idRese);

       nbrplace.setText(String.valueOf(r.getNbr()));
        choiceType.setItems(FXCollections.observableArrayList("Vip","normal"));
       
       
        
        
        
        
        
        // TODO
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        
                Reservation r = rs.findReservatinById(idRese);
                r.setNbr(Integer.parseInt(nbrplace.getText()));
                rs.modifierReservation(r);
                
                 Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/GUI/AfficherMesReservation.fxml"));
                            Stage myWindow = (Stage)nbrplace.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
    }
   
    
        
        
    }
    
