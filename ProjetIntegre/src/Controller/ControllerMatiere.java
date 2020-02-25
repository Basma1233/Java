package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.ConnexionBd;
import DAO.DAOMatiere;
import LoginForm.LoginForm;
import Model.Matiere;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControllerMatiere implements Initializable{

	DAOMatiere DAOmatiere = new DAOMatiere();

	@FXML
	private TextField txtnom;
	@FXML
	private TextField txtcoefficient;
        @FXML
	private TextField txtrecherche;

	@FXML
	private Button ajoutermatiere;
	@FXML
	private Button supprimermatiere;
	@FXML
	private Button modifiermatiere;

	@FXML
	private TableView<Matiere> listematieres;
	@FXML
	private TableColumn<Matiere, String> col_nom;
	@FXML
	private TableColumn<Matiere, Integer> col_coefficient;

	ObservableList<Matiere> oblist;


	void chargeTable() {

		Connection con = ConnexionBd.getConnexion();

		oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from matiere");
			while(rs.next()){
				Matiere matiere = new Matiere();
				matiere.setId(rs.getInt("id"));
				matiere.setNom(rs.getString("nom"));
				matiere.setCoefficient(rs.getInt("coefficient"));

				oblist.add(matiere);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//col_id.setCellValueFactory(new PropertyValueFactory<Matiere, Integer>("id"));
		col_nom.setCellValueFactory(new PropertyValueFactory<Matiere, String>("nom"));
		col_coefficient.setCellValueFactory(new PropertyValueFactory<Matiere, Integer>("coefficient"));

	    txtnom.setText("");
	    txtcoefficient.setText("");;

		listematieres.setItems(oblist);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// force the text field of capacity to be numeric only
				txtcoefficient.textProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
						if (!newValue.matches("\\d*")) {
							txtcoefficient.setText(newValue.replaceAll("[^\\d]", ""));
			        }

					}
				});

		 chargeTable();
                 //RechercheAV();
	}


	@FXML
	public void ajouterMatiere(ActionEvent e){

		if(txtnom.getText().equals("") || txtcoefficient.getText().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'une matiere");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez remplir tous les champs !");
			alert.showAndWait();

		}

		Matiere matiere = new Matiere();

		matiere.setNom(txtnom.getText());
		matiere.setCoefficient(Integer.parseInt(txtcoefficient.getText()));

		Matiere m = DAOmatiere.getByNom(matiere.getNom());
		if(m == null){

				DAOmatiere.Ajouter(matiere);

				chargeTable();
			}

		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'une matiere");
				alert.setHeaderText("Ajout");
				alert.setContentText("Matiere existe déjà !");
				alert.showAndWait();
	          }

		}


	@FXML
	public void supprimerMatiere(ActionEvent e){

	try {
			int idMatiere = listematieres.getSelectionModel().getSelectedItem().getId();
			DAOmatiere.Supprimer(idMatiere);

			chargeTable();
	    }

	catch (Exception e2) {
		e2.printStackTrace();
	    }

	}


	@FXML private void onClickLine(MouseEvent event) {

		Matiere matiere = listematieres.getSelectionModel().getSelectedItem();

		txtnom.setText(matiere.getNom());
        txtcoefficient.setText(String.valueOf(matiere.getCoefficient()));
	}


	@FXML void modifierMatiere(ActionEvent e){

		int idMatiere = listematieres.getSelectionModel().getSelectedItem().getId();

		Matiere matiere = new Matiere();

		matiere.setId(idMatiere);
		matiere.setNom(txtnom.getText());
		matiere.setCoefficient(Integer.parseInt(txtcoefficient.getText()));

		DAOmatiere.Modifier(matiere);

		chargeTable();
	}
        
        
        public void RechercheAV(){
		// Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Matiere> filteredData = new FilteredList<>(oblist, b -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		    txtrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(groupe -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (groupe.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (String.valueOf(groupe.getId()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else
				    	 return false; // Does not match.
			});
		});
		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Matiere> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(listematieres.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		listematieres.setItems(sortedData);
		}


	@FXML void afficherFenetrePrincipal(ActionEvent actionEvent) {

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

}
