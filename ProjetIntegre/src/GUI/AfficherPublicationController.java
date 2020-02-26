/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AfficherPublicationController implements Initializable {

    @FXML
    private Label txtTitre;
    @FXML
    private Label txtContenu;
    @FXML
    private Label txtDate;
    @FXML
    private Label txtAuteur;
    @FXML
    private Button btnRetour;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    public void SetTitre(String titre){
        txtTitre.setWrapText(true);
        txtTitre.setText(titre);
    }
    
     public void SetContenu(String contenu){
         txtContenu.setWrapText(true);
        txtContenu.setText(contenu);
    }
     
      public void SetDate(String date){
        txtDate.setText(date);
    }
       public void SetAuteur(String auteur){
        txtAuteur.setText(auteur);
    }

    @FXML
    private void Retour(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ForumDashboard.fxml"));
            Parent root = loader.load();

            ForumDashboardController r = loader.getController();
            btnRetour.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
