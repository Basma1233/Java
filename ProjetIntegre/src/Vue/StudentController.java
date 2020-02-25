/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controller.StudentsController;
import Entity.Student;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class StudentController implements Initializable {

    StudentsController s = new StudentsController();
    Student student = new Student();
    @FXML
    private TextField Name;
    @FXML
    private TextField Login;
    @FXML
    private TextField Password;
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private TextField classe;
    @FXML
    private TextField Adress;
    @FXML
    private TextField Mail;
    @FXML
    private TextField Sex;
    @FXML
    private Button AddButton;
    @FXML
    private ListView<String> liststudent;
    @FXML
    private TextField rech;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> ls = new ArrayList<>();

        for (Student x : s.ShowStudents()) {
            ls.add(x.getLogin());

        }
        liststudent.getItems().setAll(ls);

    }

    @FXML
    private void AddSudent(ActionEvent event) {
        String Name = this.Name.getText();
        String Login = this.Login.getText();
        String Password = this.Password.getText();

        LocalDate dateofbirth = this.DateOfBirth.getValue();
        String classe = this.classe.getText();
        String Adress = this.Adress.getText();
        String Mail = this.Mail.getText();
        String Sex = this.Sex.getText();

        Student student = new Student(dateofbirth, classe, Adress, Mail, Sex, Name, Login, Password, 0);
        s.CreateStudent(student);
        List<String> ls = new ArrayList<>();
        if ((student.getName().equals(null)) || (student.getLogin().equals(null)) || (student.getPassword().equals(null)) || (student.getAdress().equals(null)) || (student.getClasse().equals(null)) || (student.getDateOfBirth().equals(null)) || (student.getMail().equals(null)) || (student.getSex().equals(null)))  {
            System.out.println("Error");

        } 
        else {
            for (Student x : s.ShowStudents()) {
                ls.add(x.getLogin());
            }
        }
        liststudent.getItems().setAll(ls);

        init();
    }
    
    


    @FXML
    private void GetStudent(MouseEvent event) throws IOException {
        liststudent.getSelectionModel().selectedIndexProperty().addListener(observable -> {
            System.out.println();
        });
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "updateStudent.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        UpdateStudentController controller
                = loader.<UpdateStudentController>getController();
        controller.initData(liststudent.getSelectionModel().getSelectedItem());

        stage.show();

    }

    public void init() {
        this.Adress.setText("");
        this.DateOfBirth.setValue(null);
        this.Login.setText("");
        this.Mail.setText("");
        this.Name.setText("");
        this.Password.setText("");
        this.Sex.setText("");
        this.classe.setText("");
    }

    @FXML
    private void rechercherStudent(KeyEvent event) {
        
          List<String> lp= new ArrayList<>();
         for(Student x :   s.rechercherStudent(rech.getText()))
        {
            lp.add(x.getLogin());
            
            
        }
         liststudent.getItems().setAll(lp);
         
         if(rech.getText().equals(null)){
              for(Student x :s.ShowStudents())
        {
            lp.add(x.getLogin());
            
            
        }
         liststudent.getItems().setAll(lp);
             
         }
    }
    

}
