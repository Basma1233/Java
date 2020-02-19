/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.LigneBus;
import Entities.LigneBusEleve;
import Entities.Publication;
import Services.ServiceLigneBus;
import Services.ServiceLigneBusEleve;
import Services.ServicePublication;
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
    private TextField txtIdChauffeur;
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

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceLigneBus slb = new ServiceLigneBus();
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
                            LigneBus lb = getTableView().getItems().get(getIndex());
                            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTransport.fxml"));
            Parent root = loader.load();
            ModifierTransportController r = loader.getController();
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
        colListe.setCellFactory(cellFactory3);
        colModifier.setCellFactory(cellFactory);
        colSupprimer.setCellFactory(cellFactory2);
        tableTransport.setItems(list);
    }

    @FXML
    private void Ajouter(MouseEvent event) throws SQLException {

        int idChauffeur = Integer.parseInt(txtIdChauffeur.getText());
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();

            DashboardController r = loader.getController();
            btnAcceuil.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
