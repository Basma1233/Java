/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controller.ParentController;
import Entity.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateParentController implements Initializable {
    ParentController p = new ParentController();
    Parent parent=new Parent();
   
    

    @FXML
    private TextField name;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) throws IOException {
        Parent pp =new Parent(name.getText(), login.getText(), password.getText(),parent.getId());
        p.UpdateParent(parent.getId(), pp);
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

    void initData(String selectedItem) {
 parent=  p.ShowParentByLogin(selectedItem);
        System.out.println(parent.getName());
        this.name.setText(parent.getName());
        this.login.setText(parent.getLogin());
        this.password.setText(parent.getPassword());
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
        p.DeleteParent(parent.getId());
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
    
}
