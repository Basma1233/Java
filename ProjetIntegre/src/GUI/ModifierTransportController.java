/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.LigneBus;
import Services.ServiceLigneBus;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ModifierTransportController implements Initializable {

    @FXML
    private ChoiceBox<String> txtIdChauffeur;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtCapacité;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField txtHeure;
    @FXML
    private TextField txtMinute;
    @FXML
    private TextField txtAnnee;
    @FXML
    private TextField txtMois;
    @FXML
    private TextField txtJour;
    @FXML
    private Label labelID;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ServiceLigneBus slb = new ServiceLigneBus();
        ServiceUser su = new ServiceUser();
        ObservableList<String> listeChauffeur = FXCollections.observableArrayList();
        try {
            listeChauffeur = su.ListeChauffeur();
        } catch (SQLException ex) {
            Logger.getLogger(TransportDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtIdChauffeur.getItems().clear();
        txtIdChauffeur.getItems().setAll(listeChauffeur);
    }    

    @FXML
    private void Modifier(MouseEvent event) throws SQLException {
        
        int idLigne = Integer.parseInt(labelID.getText());
        String idChauffeur = txtIdChauffeur.getValue();
        String adresseDepart = txtAdresse.getText();
        int capacite = Integer.parseInt(txtCapacité.getText());
        String heureDepart = txtAnnee.getText() + "-" + txtMois.getText() + "-" + txtJour.getText() + " " + txtHeure.getText() + ":" + txtMinute.getText() + ":00";

        ServiceLigneBus slb = new ServiceLigneBus();
        LigneBus lb = new LigneBus(idLigne, idChauffeur, adresseDepart, capacite, heureDepart);

        slb.update(lb);

        
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportDashboard.fxml"));
            Parent root = loader.load();

            TransportDashboardController r = loader.getController();
            btnModifier.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void SetLabel(String label){
        labelID.setText(label);
    }
    
     public void SetHeure(String heure){
        txtHeure.setText(heure);
    }
     
      public void SetMinute(String minute){
        txtMinute.setText(minute);
    }
       public void SetAnnee(String annee){
        txtAnnee.setText(annee);
    }
        public void SetMois(String mois){
        txtMois.setText(mois);
    }
        public void SetJour(String jour){
        txtJour.setText(jour);
    }
         
       public void SetCapacite(String capacite){
        txtCapacité.setText(capacite);
    }
               
        public void SetDepart(String depart){
        txtAdresse.setText(depart);
    }

    @FXML
    private void Back(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportDashboard.fxml"));
            Parent root = loader.load();

            TransportDashboardController r = loader.getController();
            btnRetour.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
