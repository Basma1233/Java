/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import Entities.Reservation;
import Entities.Type;
import Services.EventService;
import Services.ReservationService;
import Services.ServiceMail;
import java.io.IOException;


import java.net.URL;
import java.util.Date;
import java.util.Properties;
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
public class ReservationController implements Initializable {

    @FXML
    private DatePicker datereservation;
    @FXML
    private Button btnreserver;
    @FXML
    private ChoiceBox choiceType;
    @FXML
    private TextField nbrplace;
    
    public static int idev ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        choiceType.setItems(FXCollections.observableArrayList("Vip","normal"));
    }    

    @FXML
    private void reservation(ActionEvent event) {
        
        Reservation r = new Reservation();
        ReservationService rs = new ReservationService();
        
         java.sql.Date date = new java.sql.Date(  new Date(datereservation.getEditor().getText()).getTime());
         
         r.setDateres(date);
         r.setType(choiceType.getValue().toString());
         r.setId_user(3);
         r.setNbr(Integer.parseInt(nbrplace.getText()));
         r.setId_even(idev);
         rs.ajouterReservation(r);
         
      /*********************************************/   
      ServiceMail sm = new ServiceMail();

            final String fromEmail = "oussema.khalil@esprit.tn"; //requires valid gmail id
            final String password = "oussema1234"; // correct password for gmail id
            final String toEmail = "khalil.oussema123@gmail.com"; // can be any email id 
            final String mail = "votre reservation a été confirmé ";

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            ServiceMail.sendEmail(session, toEmail, "Confirmation reservation", mail);
//
//                              
//         
//         
//         
//         
//         
//         
      /*******************************************/   
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
                            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
                        }
         
    }
    
}
