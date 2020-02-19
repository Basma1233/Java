/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.LigneBus;
import Services.ServiceLigneBus;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
    private TextField txtIdChauffeur;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //labelID.setText(getText
        // TODO
    }    

    @FXML
    private void Modifier(MouseEvent event) throws SQLException {
        
        int idLigne = 1;
        int idChauffeur = Integer.parseInt(txtIdChauffeur.getText());
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
    
}
