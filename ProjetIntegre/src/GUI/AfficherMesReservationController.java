/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Services.ReservationService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.util.ReadAheadInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherMesReservationController implements Initializable {
  @FXML
    private ScrollPane ScrlPane;
    @FXML
    private AnchorPane AnchPane;
    @FXML
    private TableView<Reservation> Table;
    @FXML
    private TableColumn<Reservation, Integer> ide;
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
    @FXML
    private Button Update;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          try {
        List<Reservation> listReservation= new ArrayList<Reservation>();
        listReservation = evtservice.getReservationByUser(3);
        EventData.clear();
        EventData.addAll(listReservation);
        Table.setItems(EventData);
        
        ide.setCellValueFactory
        (
            new PropertyValueFactory<>("id")
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

    @FXML
    private void Delete(ActionEvent event) {
        
        ReservationService rs = new ReservationService();
        
       rs.supprimerReservation(Table.getSelectionModel().getSelectedItem());
       
       /***************************************************/
            
                      Document document = new Document();
        try{
           PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
            document.open();
            Paragraph p1 = new Paragraph("Bienvenue au service PDF skool!");
            Paragraph p2 = new Paragraph("votre reservation a été annulée");
            Paragraph p3 = new Paragraph("à la prochaine, au revoir :)" );
         
            document.add(p1);
            document.add(p2);
            document.add(p3);

            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        document.close(); 

       
       
       
       
       
       
       /*****************************************************/
       
       
  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/GUI/AfficherMesReservation.fxml"));
                            Stage myWindow = (Stage)Update.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
   
        
        
        
        } 
    

    @FXML
    private void Update(ActionEvent event) {
        
        ModifierReservationController.idRese = Table.getSelectionModel().getSelectedItem().getId();
    
     Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/GUI/ModifierReservation.fxml"));
                            Stage myWindow = (Stage)Update.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
   
    
    
    
    
    }
    
}
