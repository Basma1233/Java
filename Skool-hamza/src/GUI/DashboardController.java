/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author hamza
 */
public class DashboardController implements Initializable {

    @FXML
    private Button btnTransport;
    @FXML
    private Button btnForum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToForum(MouseEvent event)  {
         try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("ForumDashboard.fxml"));
       Parent root = loader.load();
       
       ForumDashboardController r = loader.getController();
       btnForum.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GoToTransport(MouseEvent event) {
          try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("TransportDashboard.fxml"));
       Parent root = loader.load();
       
       TransportDashboardController r = loader.getController();
       btnTransport.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
         
    }
    
}
