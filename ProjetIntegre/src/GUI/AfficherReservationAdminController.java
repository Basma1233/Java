/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Entities.Reservation;
import Services.EventService;
import Services.ReservationService;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherReservationAdminController implements Initializable {

    @FXML
    private ScrollPane ScrlPane;
    @FXML
    private AnchorPane AnchPane;
    @FXML
    private TableView<Reservation> Table;
    @FXML
    private TableColumn<Reservation, Integer> ide;
    @FXML
    private TableColumn<Reservation, Integer> username;
    @FXML
    private TableColumn<Reservation, String> date;
    @FXML
    private TableColumn<Reservation, String> type;
    @FXML
    private TableColumn<Reservation, Integer> nbrplace;
    @FXML
    private TableColumn<Reservation, String> Event;

    
    
     private ObservableList<Reservation> EventData = FXCollections.observableArrayList();
         ReservationService evtservice =  new ReservationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          try {
        List<Reservation> listReservation= new ArrayList<Reservation>();
        listReservation = evtservice.getAllReservation();
        EventData.clear();
        EventData.addAll(listReservation);
        Table.setItems(EventData);
        
        ide.setCellValueFactory
        (
            new PropertyValueFactory<>("id")
        );
        
        username.setCellValueFactory
        (
            new PropertyValueFactory<>("id_user")
        );
        
         
        type.setCellValueFactory
        (
            new PropertyValueFactory<>("type")
        );
         
          date.setCellValueFactory
        (
            new PropertyValueFactory<>("dateres")
        );
          
         nbrplace.setCellValueFactory
        (
            new PropertyValueFactory<>("nbr")
        );  
        
        
        Event.setCellValueFactory
        (
            new PropertyValueFactory<>("id_even")
        );
        } catch (SQLDataException ex) {
            Logger.getLogger(AfficheEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    }    
    
}
