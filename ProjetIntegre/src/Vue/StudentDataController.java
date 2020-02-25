/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Entity.Student;
import LoginForm.LoginForm;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class StudentDataController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label Lnom;
    @FXML
    private Label Lemail;
    @FXML
    private Label Lclasse;
    @FXML
    private Label Ldate;
    @FXML
    private Button deco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Student s = LoginForm.s;
        Lnom.setText(s.getName());
        Lemail.setText(s.getMail());
        Lclasse.setText(s.getClasse());
        Ldate.setText(LoginForm.date);

    }

    @FXML
    private void deconnecter(ActionEvent event) {
        try {
            LoginForm.window.setScene(LoginForm.primaryScene);
        } catch (Exception e1) {
            System.out.println("une exeption");
            e1.printStackTrace();
        }
    }

}
