/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.ControllerFenetrePrincipaleAdmin;
import Entities.LigneBus;
import Entities.LigneBusEleve;
import Entities.Publication;
import Services.ServiceLigneBus;
import Services.ServiceLigneBusEleve;
import Services.ServicePublication;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class TransportDashboardController implements Initializable {

    private Connection con;
    private Statement ste;

    ObservableList<LigneBus> list = FXCollections.observableArrayList();

    @FXML
    private TableView<LigneBus> tableTransport;
    @FXML
    private TableColumn<LigneBus, Integer> colIDLigne;
    @FXML
    private TableColumn<LigneBus, Integer> colIDChauffer;
    @FXML
    private TableColumn<LigneBus, String> colDepart;
    @FXML
    private TableColumn<LigneBus, Integer> colCapacite;
    @FXML
    private TableColumn<LigneBus, String> colHeureDepart;
    @FXML
    private TableColumn<LigneBus, String> colListe;
    @FXML
    private TableColumn<LigneBus, String> colModifier;
    @FXML
    private TableColumn<LigneBus, String> colSupprimer;
    @FXML
    private Button btnAjouter;
    @FXML
    private ChoiceBox<String> txtIdChauffeur;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtCapacité;
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
    private TableView<LigneBusEleve> tableEleve;
    @FXML
    private TableColumn<LigneBusEleve, Integer> colIDLigne1;
    @FXML
    private TableColumn<LigneBusEleve, Integer> colIDEelve1;
    @FXML
    private TableColumn<?, ?> colNom;
    @FXML
    private TableColumn<?, ?> ColPrenom;
    @FXML
    private TextField txtRecherche;
    @FXML
    private Button btnRecherche;
    @FXML
    private Button btnAcceuil;
    @FXML
    private TableColumn<LigneBus, String> colAffecter;

    
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
        
        
        ObservableList<LigneBus> list = FXCollections.observableArrayList();

        try {
            list = slb.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        colIDLigne.setCellValueFactory(new PropertyValueFactory<>("idLigne"));
        colIDChauffer.setCellValueFactory(new PropertyValueFactory<>("idChauffeur"));
        colDepart.setCellValueFactory(new PropertyValueFactory<>("departAdresse"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        colHeureDepart.setCellValueFactory(new PropertyValueFactory<>("departHeure"));

        Callback<TableColumn<LigneBus, String>, TableCell<LigneBus, String>> cellFactory = (param) -> {
            final TableCell<LigneBus, String> cell = new TableCell<LigneBus, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final Button btnEdit = new Button("Modifier");
                        btnEdit.setOnAction(event -> {
                           LigneBus ligne = tableTransport.getItems().get(tableTransport.getSelectionModel().getSelectedIndex());
            String label = Integer.toString(ligne.getIdLigne());
            String chauffeur = ligne.getIdChauffeur();
            String adresse = ligne.getDepartAdresse();
            int capacite = ligne.getCapacite();
            String dateTime = ligne.getDepartHeure();
        
            String heure = dateTime.substring(11,13);
            String minute = dateTime.substring(14,16);
            String annee = dateTime.substring(0,4);
            String mois = dateTime.substring(5,7);
            String jour = dateTime.substring(8,10);
                    
                            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTransport.fxml"));
            
            Parent root = loader.load();
            ModifierTransportController r = loader.getController();
            r.SetCapacite(Integer.toString(capacite));
            r.SetDepart(adresse);
            
            
           r.SetLabel(label);
            r.SetAnnee(annee);
            r.SetHeure(heure);
            r.SetJour(jour);
            r.SetMinute(minute);
            r.SetMois(mois);
           
            btnAcceuil.getScene().setRoot(root);
             

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

                        });
                        setGraphic(btnEdit);
                        setText(null);

                    }
                }

            };
            return cell;
        };

        Callback<TableColumn<LigneBus, String>, TableCell<LigneBus, String>> cellFactory2 = (param) -> {
            final TableCell<LigneBus, String> cell = new TableCell<LigneBus, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        final Button btnDelete = new Button("Supprimer");
                        btnDelete.setOnAction(event -> {
                            LigneBus p2 = getTableView().getItems().get(getIndex());
                            try {
                                slb.delete(p2);
                            } catch (SQLException ex) {
                                Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ObservableList<LigneBus> listUpdate = FXCollections.observableArrayList();
                            try {
                                listUpdate = slb.readAll();
                            } catch (SQLException ex) {
                                Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            tableTransport.setItems(listUpdate);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Suppression de \n " + p2.getIdLigne() + "\n Adresse : " + p2.getDepartAdresse());
                            alert.show();

                        });

                        setGraphic(btnDelete);
                        setText(null);
                    }
                }

            };
            return cell;
        };

        Callback<TableColumn<LigneBus, String>, TableCell<LigneBus, String>> cellFactory3 = (param) -> {
            final TableCell<LigneBus, String> cell = new TableCell<LigneBus, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        final Button btnAfficher = new Button("Afficher");
                        btnAfficher.setOnAction(event -> {
                            ServiceLigneBusEleve slbe = new ServiceLigneBusEleve();
                            ObservableList<LigneBusEleve> list2 = FXCollections.observableArrayList();
                            LigneBus lb1 = getTableView().getItems().get(getIndex());

                            String idLigne1 = Integer.toString(lb1.getIdLigne());

                            try {
                                list2 = slbe.Display(idLigne1);
                            } catch (SQLException ex) {
                                Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            tableEleve.setItems(list2);
                            colIDLigne1.setCellValueFactory(new PropertyValueFactory<>("idLigne"));
                            colIDEelve1.setCellValueFactory(new PropertyValueFactory<>("idEleve"));
                            ColPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                        });

                        setGraphic(btnAfficher);
                        setText(null);
                    }
                }

            };
            return cell;
        };
        
         Callback<TableColumn<LigneBus, String>, TableCell<LigneBus, String>> cellFactory4 = (param) -> {
            final TableCell<LigneBus, String> cell = new TableCell<LigneBus, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        final Button btnAffecter = new Button("Affecter");
                        btnAffecter.setOnAction(event -> {
                           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffecterBus.fxml"));
            Parent root = loader.load();

             LigneBus ligne = tableTransport.getItems().get(tableTransport.getSelectionModel().getSelectedIndex());
            String label2 = Integer.toString(ligne.getIdLigne());
            AffecterBusController r = loader.getController();
            r.SetLabel(label2);
            btnAffecter.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
        colListe.setCellFactory(cellFactory3);
        colModifier.setCellFactory(cellFactory);
        colSupprimer.setCellFactory(cellFactory2);
        tableTransport.setItems(list);
    }

    @FXML
    private void Ajouter(MouseEvent event) throws SQLException {

        String idChauffeur = txtIdChauffeur.getValue();
        String adresseDepart = txtAdresse.getText();
        int capacite = Integer.parseInt(txtCapacité.getText());
        String heureDepart = txtAnnee.getText() + "-" + txtMois.getText() + "-" + txtJour.getText() + " " + txtHeure.getText() + ":" + txtMinute.getText() + ":00";

        ServiceLigneBus slb = new ServiceLigneBus();
        LigneBus lb = new LigneBus(idChauffeur, adresseDepart, capacite, heureDepart);

        slb.add(lb);

        ObservableList<LigneBus> listUpdate = FXCollections.observableArrayList();
        try {
            listUpdate = slb.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableTransport.setItems(listUpdate);
    }

    @FXML
    private void Recherche(InputMethodEvent event) throws SQLException {

        ObservableList<LigneBus> listRecherche = FXCollections.observableArrayList();
        ServiceLigneBus slb = new ServiceLigneBus();
        String id = txtRecherche.getText();

        listRecherche = slb.RechercheID(id);
        tableTransport.setItems(listRecherche);
    }

    @FXML
    private void Recherche(MouseEvent event) throws SQLException {
        ObservableList<LigneBus> listRecherche = FXCollections.observableArrayList();
        ServiceLigneBus slb = new ServiceLigneBus();
        String id = txtRecherche.getText();

        listRecherche = slb.RechercheID(id);
        tableTransport.setItems(listRecherche);
    }

    @FXML
    private void Acceuil(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/FenetrePrincipaleAdmin.fxml"));
            Parent root = loader.load();

            ControllerFenetrePrincipaleAdmin r = loader.getController();
            btnAcceuil.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

