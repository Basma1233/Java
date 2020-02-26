/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.LigneBusEleve;
import Entities.User;
import Services.ServiceLigneBusEleve;
import Services.ServiceUser;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AffecterBusController implements Initializable {

    @FXML
    private Button btnRetour;
    @FXML
    private TextField txtRecherche;
    @FXML
    private Button btnRecherche;
    @FXML
    private TableView<User> tableEleve;
    @FXML
    private Label labelID;
    @FXML
    private TableColumn<User, Integer> colID;
    @FXML
    private TableColumn<User, String> colNom;
    @FXML
    private TableColumn<User, String> colPrenom;
    @FXML
    private TableColumn<User, String> colAffecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceUser su = new ServiceUser();
        ObservableList<User> listeEleve = FXCollections.observableArrayList();
        
         try {
            listeEleve = su.ListeEleve();
        } catch (SQLException ex) {
            Logger.getLogger(AffecterBusController.class.getName()).log(Level.SEVERE, null, ex);
        }
         tableEleve.setItems(listeEleve);
         colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        
        Callback<TableColumn<User, String>, TableCell<User, String>> cellFactory4 = (param) -> {
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        final Button btnAffecter = new Button("Affecter");
                        btnAffecter.setOnAction(event -> {
                            
                            int idLigne = Integer.parseInt(labelID.getText());
                            User u = tableEleve.getItems().get(tableEleve.getSelectionModel().getSelectedIndex());
                            int idEleve = u.getId();
                            String nom = u.getNom();
                            String prenom = u.getPrenom();
                            String num = Integer.toString(u.getNumTel());
                            String adresse = "Tunis";
                            String date = "22-04-2023 07:30";
                              String ACCOUNT_SID = "AC86a5960437fc460b97220a2461d3db65";
                              String AUTH_TOKEN = "eadf54a76e49640f684f1adfc25e3dcb";

 
                                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
               Message message = Message.creator(new PhoneNumber("+216"+ num),
        new PhoneNumber("+12028041959"), 
        "L'ecole vous informe que votre bus de : " + adresse + " sort le :" + date).create();

    System.out.println(message.getSid());
                            
                            
                            ServiceLigneBusEleve slbe = new ServiceLigneBusEleve();
                            LigneBusEleve lbe = new LigneBusEleve(idLigne, idEleve, nom, prenom);

                            try {
                                slbe.add(lbe);
                            } catch (SQLException ex) {
                                Logger.getLogger(AffecterBusController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });

                        setGraphic(btnAffecter);
                        setText(null);
                    }
                }

            };
            return cell;
        };
        colAffecter.setCellFactory(cellFactory4);
         
    }    

    @FXML
    private void Retour(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportDashboard.fxml"));
            Parent root = loader.load();

            TransportDashboardController r = loader.getController();
            btnRetour.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Recherche(MouseEvent event) throws SQLException {
        ObservableList<User> RechercheID = FXCollections.observableArrayList();
        ServiceUser u = new ServiceUser();
        String nom = txtRecherche.getText();

         RechercheID = u.RecherchePrenom(nom);
        tableEleve.setItems(RechercheID);
    }
     
    
    public void SetLabel(String label){
        labelID.setText(label);
    }
    
}

