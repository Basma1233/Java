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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.lang.Object;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ForumDashboardController implements Initializable {

    @FXML
    private TableView<Publication> tableForum;
    @FXML
    private TableColumn<Publication, String> colDate;
    @FXML
    private TableColumn<Publication, Integer> colAuteur;
    @FXML
    private TableColumn<Publication, String> colTitre;

    ObservableList<Publication> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Publication, String> colModifier;
    @FXML
    private TableColumn<Publication, String> colSupprimer;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnAccueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServicePublication sp = new ServicePublication();
        ObservableList<Publication> list = FXCollections.observableArrayList();
        try {
            list = sp.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);

        colDate.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
        colAuteur.setCellValueFactory(new PropertyValueFactory<>("idAuteur"));
        colTitre.setCellValueFactory(new PropertyValueFactory<>("titrePublication"));

        Callback<TableColumn<Publication, String>, TableCell<Publication, String>> cellFactory = (param) -> {
            final TableCell<Publication, String> cell = new TableCell<Publication, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final Button btnEdit = new Button("Modifier");
                        btnEdit.setOnAction(event -> {
                            Publication p = getTableView().getItems().get(getIndex());
                            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierPublication.fxml"));
            Parent root = loader.load();
            ModifierPublicationController r = loader.getController();
            btnEdit.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Modification de \n " + p.getTitrePublication() + "\n publiée le : " + p.getDatePublication());
                            alert.show();

                        });
                        setGraphic(btnEdit);
                        setText(null);

                    }
                }

            };
            return cell;
        };
        
        Callback<TableColumn<Publication, String>, TableCell<Publication, String>> cellFactory2 = (param) -> {
            final TableCell<Publication, String> cell = new TableCell<Publication, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        
final Button btnDelete = new Button("Supprimer");
                        btnDelete.setOnAction(event -> {
                            Publication p2 = getTableView().getItems().get(getIndex());
                            try {
                                sp.delete(p2);
                            } catch (SQLException ex) {
                                Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ObservableList<Publication> listUpdate = FXCollections.observableArrayList();
                            try {
                                listUpdate = sp.readAll();
                            } catch (SQLException ex) {
                                Logger.getLogger(ForumDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            tableForum.setItems(listUpdate);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Suppression de \n " + p2.getTitrePublication() + "\n publiée le : " + p2.getDatePublication());
                            alert.show();

                        });

                        setGraphic(btnDelete);
                        setText(null);
                    }
                }

            };
            return cell;
        };

        colModifier.setCellFactory(cellFactory);
        colSupprimer.setCellFactory(cellFactory2);
        tableForum.setItems(list);

    }

    @FXML
    private void Ajouter(MouseEvent event) {
          try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("AjouterPublication.fxml"));
       Parent root = loader.load();
       
       AjouterPublicationController r = loader.getController();
       btnAjout.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
         
    }

    @FXML
    private void Accueil(MouseEvent event) {
         try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("Dashboard.fxml"));
       Parent root = loader.load();
       
       DashboardController r = loader.getController();
       btnAccueil.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
         
    }
}

















