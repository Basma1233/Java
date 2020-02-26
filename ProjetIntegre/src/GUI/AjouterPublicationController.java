/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Publication;
import Services.ServicePublication;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextArea taMessage;
    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfTitre;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void Ajouter(ActionEvent event) throws SQLException {

            String titre = tfTitre.getText();
            String message = taMessage.getText();
            java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String currentTime = sdf.format(dt);

       ServicePublication sp = new ServicePublication();
       Publication p = new Publication (titre,message,currentTime);
       
       sp.add(p);
       
       
      
    }

    @FXML
    private void Ajouter(MouseEvent event) throws SQLException {
          String titre = tfTitre.getText();
            String message = taMessage.getText();
            java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

String currentTime = sdf.format(dt);

       ServicePublication sp = new ServicePublication();
       Publication p = new Publication (titre,message,currentTime);
       
       sp.add(p);
       
        try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("ForumDashboard.fxml"));
       Parent root = loader.load();
       
       ForumDashboardController r = loader.getController();
       btnAjouter.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
         
    }

    @FXML
    private void Back(MouseEvent event) {
        
        try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("ForumDashboard.fxml"));
       Parent root = loader.load();
       
       ForumDashboardController r = loader.getController();
       btnRetour.getScene().setRoot(root);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
