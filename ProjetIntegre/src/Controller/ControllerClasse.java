package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.ConnexionBd;
import DAO.DAOClasse;
import LoginForm.LoginForm;
import Model.Classe;
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

public class ControllerClasse implements Initializable{

	DAOClasse DAOclasse = new DAOClasse();

	@FXML
	private TextField txtnom;
	@FXML
	private ComboBox<Integer> cbniveau;
	@FXML
	private TextField txtcapacite;
        @FXML
	private TextField txtrecherche;

	@FXML
	private Button ajoutermatiere;
	@FXML
	private Button supprimermatiere;
	@FXML
	private Button modifiermatiere;

	@FXML
	private TableView<Classe> listeclasses;
	@FXML
	private TableColumn<Classe, String> col_nom;
	@FXML
	private TableColumn<Classe, Integer> col_niveau;
	@FXML
	private TableColumn<Classe, Integer> col_capacite;

	ObservableList<Classe> oblist;



	void chargerCombobox(){

		cbniveau.getItems().addAll(1,2,3,4,5,6);
		cbniveau.setValue(1);

	}

	void chargeTable() {

		Connection con = ConnexionBd.getConnexion();

		oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from classe");
			while(rs.next()){
				Classe classe = new Classe();
				classe.setId(rs.getInt("id"));
				classe.setNom(rs.getString("nom"));
				classe.setNiveau(rs.getInt("niveau"));
				classe.setCapacite(rs.getInt("capacite"));

				oblist.add(classe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//col_id.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("id"));
		col_nom.setCellValueFactory(new PropertyValueFactory<Classe, String>("nom"));
		col_niveau.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("niveau"));
		col_capacite.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("capacite"));

	    txtnom.setText("");
	    cbniveau.setValue(null);
	    txtcapacite.setText("");

		listeclasses.setItems(oblist);
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
		 chargerCombobox();
                 //RechercheAV();
	}


	@FXML
	public void ajouterClasse(ActionEvent e){

		if(txtnom.getText().equals("") || cbniveau.getValue().equals("") || txtcapacite.getText().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'un classe");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez remplir tous les champs !");
			alert.showAndWait();

		}

		Classe classe = new Classe();

		classe.setNom(txtnom.getText());
		classe.setNiveau(cbniveau.getValue());
		classe.setCapacite(Integer.parseInt(txtcapacite.getText()));

		Classe c = DAOclasse.getByNom(classe.getNom());
		if(c == null){

				DAOclasse.Ajouter(classe);

				chargeTable();
			}

		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'un classe");
				alert.setHeaderText("Ajout");
				alert.setContentText("Classe existe deja !");
				alert.showAndWait();
	          }

		}


	@FXML
	public void supprimerClasse(ActionEvent e){

	try {
		    int idClasse = listeclasses.getSelectionModel().getSelectedItem().getId();
			DAOclasse.Supprimer(idClasse);

			chargeTable();
	    }

	catch (Exception e2) {
		e2.printStackTrace();
	    }

	}


	@FXML
	private void onClickLine(MouseEvent event) {

		Classe classe = listeclasses.getSelectionModel().getSelectedItem();

		txtnom.setText(classe.getNom());
		cbniveau.setValue(classe.getNiveau());
		txtcapacite.setText(String.valueOf(classe.getCapacite()));
	}


	@FXML
	void modifierClasse(ActionEvent e){

		int idClasse = listeclasses.getSelectionModel().getSelectedItem().getId();

		Classe classe = new Classe();

		classe.setId(idClasse);
		classe.setNom(txtnom.getText());
		classe.setNiveau(cbniveau.getValue());
		classe.setCapacite(Integer.parseInt(txtcapacite.getText()));

		DAOclasse.Modifier(classe);

		chargeTable();
	}

        
        public void RechercheAV(){
		// Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Classe> filteredData = new FilteredList<>(oblist, b -> true);

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
		SortedList<Classe> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(listeclasses.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		listeclasses.setItems(sortedData);
		}

	@FXML
	void afficherFenetrePrincipal(ActionEvent actionEvent) {

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
