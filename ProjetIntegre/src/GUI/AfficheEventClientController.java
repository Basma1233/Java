/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Entities.Reservation;
import Services.EventService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficheEventClientController implements Initializable {

    @FXML
    private ScrollPane ScrlPane;
    @FXML
    private AnchorPane AnchPane;
    @FXML
    private TableView<Event> Table;
    @FXML
    private TableColumn<Event, Integer> ide;
    @FXML
    private TableColumn<Event, String> titre;
    @FXML
    private TableColumn<Event, String> lieu;
    @FXML
    private TableColumn<Event, String> datedebut;
    @FXML
    private TableColumn<Event, String> datefin;
    @FXML
    private TableColumn<Event, Integer> nbplaces;
    @FXML
    private TableColumn<Event, Integer> nbparticipants;
    @FXML
    private Button Reserver;

    
     private ObservableList<Event> EventData = FXCollections.observableArrayList();
         EventService evtservice =  new EventService();
    @FXML
    private TextField rechercheFilrd;
    @FXML
    private Button Rechercher;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
           try {
            List<Event> listEvenement= new ArrayList<Event>();
            listEvenement = evtservice.getAllEvenement();
            EventData.clear();
        EventData.addAll(listEvenement);
        Table.setItems(EventData);
        
        ide.setCellValueFactory
        (
            new PropertyValueFactory<>("ID")
        );
        
        titre.setCellValueFactory
        (
            new PropertyValueFactory<>("titre")
        );
        
         datedebut.setCellValueFactory
        (
            new PropertyValueFactory<>("DateDebut")
        );
         
          datefin.setCellValueFactory
        (
            new PropertyValueFactory<>("DateFin")
        );
          
         nbplaces.setCellValueFactory
        (
            new PropertyValueFactory<>("nbp")
        );  
        
        
        lieu.setCellValueFactory
        (
            new PropertyValueFactory<>("lieu")
        );
        } catch (SQLDataException ex) {
            Logger.getLogger(AfficheEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    @FXML
    private void ReserverAction(ActionEvent event) {
    
    
    
                                 ReservationController.idev =  Table.getSelectionModel().getSelectedItem().getID();

         Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/GUI/Reservation.fxml"));
                            Stage myWindow = (Stage)Reserver.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    
}

    @FXML
    private void Rechercher(ActionEvent event) throws SQLDataException {
        
                    List<Event> listEvenements = new ArrayList<Event>();

   
            listEvenements  = evtservice.getEventBytitre(rechercheFilrd.getText());
            ObservableList<Event> data = FXCollections.observableArrayList(listEvenements);
            Table.setItems(data);
       
}
    
}