package Controller;

import LoginForm.LoginForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ControllerFenetrePrincipaleAdmin {

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

}
