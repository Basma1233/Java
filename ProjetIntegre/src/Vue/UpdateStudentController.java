/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controller.StudentsController;
import Entity.Parent;
import Entity.Student;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateStudentController implements Initializable {
    StudentsController ss= new StudentsController();
    Student student = new Student();
    @FXML
    private TextField Name;
    @FXML
    private TextField Login;
    @FXML
    private TextField Password;
    @FXML
    private TextField classe;
    @FXML
    private TextField Adress;
    @FXML
    private TextField Mail;
    @FXML
    private TextField Sex;
    @FXML
    private Button updateButton;
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateStudent(ActionEvent event) throws IOException {
        Student pp =new Student(this.DateOfBirth.getValue(), this.classe.getText(), Adress.getText(), Mail.getText(), Sex.getText(), Name.getText(), Login.getText(), Password.getText(), student.getId());
        ss.UpdateStudent(student.getId(), pp);
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

    @FXML
    private void DeleteStudent(ActionEvent event) throws IOException {
         ss.DeleteStudent(student.getId());
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
    

    void initData(String selectedItem) {
        student=  ss.SowStudentByLogin(selectedItem) ;
        this.Name.setText(student.getName());
        this.Login.setText(student.getLogin());
        this.Password.setText(student.getPassword());
        this.DateOfBirth.setValue(student.getDateOfBirth());
        this.Adress.setText(student.getAdress());
        this.Sex.setText(student.getSex());
        this.Mail.setText(student.getMail());
        this.classe.setText(student.getClasse());


    }
    
}
