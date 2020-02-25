/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controller.ParentController;
import Controller.StudentsController;
import Entity.Parent;
import Entity.Student;
import DAO.ParentInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ParentFxmlController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField login;
     
    @FXML
    private TextField password;
    @FXML
    private Button AddButton;
      StudentsController st = new StudentsController();
 ParentInterface p= new ParentController();
    @FXML
    private ListView<String> listParent;
    @FXML
    private TextField rech;
    @FXML
    private ChoiceBox<String> student;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                    List<String> lp= new ArrayList<>();
                             List<String> ls= new ArrayList<>();

         for(Parent x :p.ShowParents())
        {
            lp.add(x.getLogin());
            System.out.println("hello");
            
        }
         for (Student s: st.ShowStudents()) {
              ls.add(s.getLogin());
         }
         if(ls.size()>0)
         { student.setItems(FXCollections.observableList(ls));}
                  if(lp.size()>0)

                  {listParent.getItems().setAll(lp);}
    }
 
    @FXML
    private void AddParent(ActionEvent event) {
       
        String name = this.name.getText();
        String login = this.login.getText();
        String password = this.password.getText();
        Student stu = st.SowStudentByLogin(student.getValue());
        Parent parent= new Parent(name, login, password,0);
        parent.setStudent(stu);
        if ((parent.getName().equals(""))||(parent.getLogin().equals(""))||(parent.getPassword().equals(""))) {
            System.out.println("les champs sont vide");
          
        }else   
        p.AddParent(parent);
        
        List<String> lp= new ArrayList<>();

         for(Parent x :p.ShowParents())
        {
            lp.add(x.getLogin());  
        }
         listParent.getItems().setAll(lp);
          init();
          
        
    }

    @FXML
    private void GetParent(MouseEvent event) throws IOException {
        listParent.getSelectionModel().selectedIndexProperty().addListener(observable -> {
            System.out.println();
        }); 
        FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "updateParent.fxml"
    )
  );

  Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );

  UpdateParentController controller = 
    loader.<UpdateParentController>getController();
  controller.initData(listParent.getSelectionModel().getSelectedItem());

  stage.show();

    }
 

    public void init(){
        this.name.setText("");
        this.login.setText("");
        this.password.setText("");
         
    }

    @FXML
    private void RechercherParent(KeyEvent event) {
      List<String> lp= new ArrayList<>();
         for(Parent x :   p.rechercherParent(rech.getText()))
        {
            lp.add(x.getLogin());
            
            
        }
         listParent.getItems().setAll(lp);
         
         if(rech.getText().equals(null)){
              for(Parent x :p.ShowParents())
        {
            lp.add(x.getLogin());
            
            
        }
         listParent.getItems().setAll(lp);
             
         }
                }

    
    
}
