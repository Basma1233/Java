package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.ConnexionBd;
import DAO.DAOSalle;
import LoginForm.LoginForm;
import Model.Salle;
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

public class ControllerSalle implements Initializable{

	DAOSalle DAOsalle = new DAOSalle();

	@FXML
	private TextField txtnom;
	@FXML
	private TextField txtcapacite;
        @FXML
	private TextField txtrecherche;

	@FXML
	private Button ajoutersalle;
	@FXML
	private Button supprimersalle;
	@FXML
	private Button modifiersalle;

	@FXML
	private TableView<Salle> listesalles;
	@FXML
	private TableColumn<Salle, String> col_nom;
	@FXML
	private TableColumn<Salle, Integer> col_capacite;

	ObservableList<Salle> oblist;


	void chargeTable() {

		Connection con = ConnexionBd.getConnexion();

		oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from salle");
			while(rs.next()){
				Salle salle = new Salle();
				salle.setId(rs.getInt("id"));
				salle.setNom(rs.getString("nom"));
				salle.setCapacite(rs.getInt("capacite"));

				oblist.add(salle);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//col_id.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("id"));
		col_nom.setCellValueFactory(new PropertyValueFactory<Salle, String>("nom"));
		col_capacite.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("capacite"));

	    txtnom.setText("");
	    txtcapacite.setText("");;

		listesalles.setItems(oblist);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// force the text field of capacity to be numeric only
		txtcapacite.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					txtcapacite.setText(newValue.replaceAll("[^\\d]", ""));
	        }

			}
		});

		 chargeTable();
                 //RechercheAV();
	}


	@FXML
	public void ajouterSalle(ActionEvent e){

		if(txtnom.getText().equals("") || txtcapacite.getText().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'une salle");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez remplir tous les champs !");
			alert.showAndWait();

		}

		Salle salle = new Salle();

		salle.setNom(txtnom.getText());
		salle.setCapacite(Integer.parseInt(txtcapacite.getText()));

		Salle s = DAOsalle.getByNom(salle.getNom());

		if(s == null){

				DAOsalle.Ajouter(salle);

				chargeTable();
			}

		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'une salle");
				alert.setHeaderText("Ajout");
				alert.setContentText("Salle existe déjà !");
				alert.showAndWait();
	          }

		}


	@FXML
	public void supprimerSalle(ActionEvent e){

	try {
			int idSalle = listesalles.getSelectionModel().getSelectedItem().getId();
			DAOsalle.Supprimer(idSalle);

			chargeTable();
	    }

	catch (Exception e2) {
		e2.printStackTrace();
	    }

	}


	@FXML private void onClickLine(MouseEvent event) {

		Salle salle = listesalles.getSelectionModel().getSelectedItem();

		txtnom.setText(salle.getNom());
		txtcapacite.setText(String.valueOf(salle.getCapacite()));
	}


	@FXML void modifierSalle(ActionEvent e){

		int idSalle = listesalles.getSelectionModel().getSelectedItem().getId();

		Salle salle = new Salle();

		salle.setId(idSalle);
		salle.setNom(txtnom.getText());
		salle.setCapacite(Integer.parseInt(txtcapacite.getText()));

		DAOsalle.Modifier(salle);

		chargeTable();
	}

        public void RechercheAV(){
		// Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Salle> filteredData = new FilteredList<>(oblist, b -> true);

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
		SortedList<Salle> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(listesalles.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		listesalles.setItems(sortedData);
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
