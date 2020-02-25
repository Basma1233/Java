/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controller.ParentController;
import Controller.StudentsController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomePageController implements Initializable {
    StudentsController st = new StudentsController();
    ParentController pt = new ParentController();

    @FXML
    private Button ParentButton;
    @FXML
    private AnchorPane EleveButton;
    @FXML
    private Button student;
    @FXML
    private TableColumn<Student, String> mail;
    @FXML
    private TableColumn<Parent, String> parentname;
    @FXML
    private TableColumn<Student, String>studentname;
    @FXML
    private TableColumn<Student, String> slogin;
    @FXML
    private TableColumn<Student, String> calsse;
    @FXML
    private TableColumn<Student, LocalDate> dof;
    @FXML
    private TableColumn<Parent, String> plogin;
    @FXML
    private TableColumn<Student, String> sname;
    @FXML
    private TableView<Student> studenttableview;
    @FXML
    private TableView<Parent> PaentTableview;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       final ObservableList<Student> data = FXCollections.observableArrayList(st.ShowStudents());
      
  
    
    studentname.setCellValueFactory(new PropertyValueFactory("name"));
    slogin.setCellValueFactory(new PropertyValueFactory("login"));
    
    mail.setMinWidth(200);
    mail.setCellValueFactory(new PropertyValueFactory("mail"));
        calsse.setCellValueFactory(new PropertyValueFactory("classe"));
    dof.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));


    
    studenttableview.setItems(data);
//parent
  final ObservableList<Parent> datap = FXCollections.observableArrayList(pt.ShowParents());
      
  
    
    parentname.setCellValueFactory(new PropertyValueFactory("name"));
    plogin.setCellValueFactory(new PropertyValueFactory("login"));
    
   
        sname.setCellValueFactory(new PropertyValueFactory("studentname"));
   


    
    PaentTableview.setItems(datap);

    
        
        // TODO
    }

    @FXML
    private void GoToParent(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "parentFxml.fxml"
    )
  );

  Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );

  stage.show();

    }

        
    

   

    @FXML
    private void GoToEleve(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "Student.fxml"
    )
  );

  Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );

  stage.show();

    }

   
  

}
