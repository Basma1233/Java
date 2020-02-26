/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import LoginForm.LoginForm;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficheEventsController implements Initializable {

    @FXML
    private ScrollPane ScrlPane;
    @FXML
    private AnchorPane AnchPane;
    @FXML
    private TableView<Event> Table;
    @FXML
    private TableColumn<Event,Integer> ide;
    @FXML
    private TableColumn<Event, String> titre;
    @FXML
    private TableColumn<Event ,String> lieu;
    @FXML
    private TableColumn<Event,String> datedebut;
    @FXML
    private TableColumn<Event,String> datefin;
    @FXML
    private TableColumn<Event, Integer> nbplaces;
    @FXML
    private TableColumn<Event, Integer> nbparticipants;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button ajout;
    

 private ObservableList<Event> EventData = FXCollections.observableArrayList();
         EventService evtservice =  new EventService();


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
	void afficherFenetrePrincipal(ActionEvent actionEvent) {

		final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vue/FenetrePrincipaleAdmin.fxml"));

		    Parent root1;
			try {
				root1 = (Parent) fxmlLoader.load();

				LoginForm.window.setScene(new Scene(root1));


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

   

    public void setIde(TableColumn<Event, Integer> ide) {
        this.ide.setText(ide.getText());
    }

    public void setTitre(TableColumn<Event, String> titre) {
        this.titre.setText(titre.getText());
    }

    public void setLieu(TableColumn<Event, String> lieu) {
        this.lieu.setText(lieu.getText());
    }

    public void setDatedebut(TableColumn<Event, String> datedebut) {
        this.datedebut.setText(datedebut.getText());
    }

    public void setDatefin(TableColumn<Event, String> datefin) {
        this.datefin.setText(datefin.getText());
    }

    public void setNbplaces(TableColumn<Event, Integer> nbplaces) {
        this.nbplaces.setText(nbplaces.getText());
    }

  

   
    public void setEventData(ObservableList<Event> EventData) {
        this.EventData = EventData;
    }

    public void setEvtservice(EventService evtservice) {
        this.evtservice = evtservice;
    }

    @FXML
    private void modifieEvent(ActionEvent event) {
                           ModifierEvenementController.idEv =  Table.getSelectionModel().getSelectedItem().getID();
                   System.out.println("cxxxxxxxxxxxxxxxxxxxxxxxxx"+ModifierEvenementController.idEv);

  Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/GUI/ModifierEvenement.fxml"));
                            Stage myWindow = (Stage)modifier.getScene().getWindow();
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
    private void supprimerEvent(ActionEvent event) throws SQLDataException {
        
         Event EventSelec = (Event) Table.getSelectionModel().getSelectedItem();
        System.out.println("GUI.AfficheEventsController.supprimerEvent()"+ EventSelec.getID());
         if(EventSelec == null){
            
        }else{
            if(evtservice.supprimerEvent(EventSelec.getID())){
                
               
                resetTableData();
            }else{
                
            }
        }
    }

    @FXML
    private void Ajout(ActionEvent event) {
         Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/gui/ajoutEvenement.fxml"));
                            Stage myWindow = (Stage)modifier.getScene().getWindow();
                            Scene sc = new Scene(root);
                            myWindow.setScene(sc);
                            myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
                            myWindow.show();
                        } catch (IOException ex) {
                            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        
    }
          public void resetTableData() throws SQLDataException
    {
        List<Event> listEvenements = new ArrayList<>();
        listEvenements = evtservice.getAllEvenement();
        ObservableList<Event> data = FXCollections.observableArrayList(listEvenements);
        Table.setItems(data);
    }

}
