package Controller;

import GUI.ForumDashboardController;
import GUI.TransportDashboardController;
import LoginForm.LoginForm;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerFenetrePrincipaleAdmin {

    @FXML
    private Button btnTransport;
    @FXML
    private Button btnForum;

	@FXML
	public void gestionClasse(){

		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/Classe.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));


		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}


	@FXML
	public void gestionMatiere(){

		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/Matiere.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));


		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}
        
	@FXML
	public void gestionEvent(){
		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/GUI/AfficheEvents.fxml"));
			    Parent root1 = (Parent) fxmlLoader.load();
			    LoginForm.window.setScene(new Scene(root1));
		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}


	@FXML
	public void gestionSalle(ActionEvent enActionEvent){

		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/Salle.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));
			   // stage.show();


		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}


	@FXML
	public void gestionSeance(ActionEvent enActionEvent){

		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/Seance.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));
			   // stage.show();


		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}
        
        
        @FXML
	public void gestionProf(ActionEvent enActionEvent){

		try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/Prof.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));
			   // stage.show();


		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}


	@FXML
	public void deconnecter(ActionEvent actionEvent){
		try
		{
		   LoginForm.window.setScene(LoginForm.primaryScene);
		}

		catch(Exception e1) {
			System.out.println("une exeption");
			e1.printStackTrace();
		}

	}

    @FXML
    private void gestionEtudiant(ActionEvent event) {
        try
		{
			final FXMLLoader fxmlLoader =
					new FXMLLoader(this.getClass().getResource("/Vue/HomePage.fxml"));

			    Parent root1 = (Parent) fxmlLoader.load();

			    LoginForm.window.setScene(new Scene(root1));
			   // stage.show();


		} catch(Exception e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    private void goToTransport(MouseEvent event) {
        
         try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("/GUI/TransportDashboard.fxml"));
       Parent root = loader.load();
       
       TransportDashboardController r = loader.getController();
       btnTransport.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goToForum(MouseEvent event) {
        
          try {
       FXMLLoader loader = new   FXMLLoader(getClass().getResource("/GUI/ForumDashboard.fxml"));
       Parent root = loader.load();
       
       ForumDashboardController r = loader.getController();
       btnForum.getScene().setRoot(root);
       

          
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
