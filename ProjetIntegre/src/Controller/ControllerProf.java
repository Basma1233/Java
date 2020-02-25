package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.ConnexionBd;
import DAO.DAOProf;
import LoginForm.LoginForm;
import Model.Prof;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControllerProf implements Initializable{

	DAOProf daoProf = new DAOProf();

	@FXML
	private TextField txtnom;
	@FXML
	private TextField txtprenom;
	@FXML
	private TextField txttel;
	@FXML
	private TextField txtemail;
	@FXML
	private TextField txtadresse;
	@FXML
	private TextField txtspecialite;
	@FXML
	private TextField txtrecherche;

	@FXML
	private Button ajouterprof;
	@FXML
	private Button supprimerprof;
	@FXML
	private Button modifierprof;

	@FXML
	private TableView<Prof> listeprofs;
	@FXML
	private TableColumn<Prof, String> col_nom;
	@FXML
	private TableColumn<Prof, String> col_prenom;
	@FXML
	private TableColumn<Prof, String> col_tel;
	@FXML
	private TableColumn<Prof, String> col_email;
	@FXML
	private TableColumn<Prof, String> col_adresse;
	@FXML
	private TableColumn<Prof, String> col_specialite;

	ObservableList<Prof> oblist;


	void chargeTable() {

		Connection con = ConnexionBd.getConnexion();

		oblist = FXCollections.observableArrayList();

		try {
				ResultSet rs = con.createStatement().executeQuery("select * from prof");
				while(rs.next()){
					Prof prof = new Prof();
					prof.setId(rs.getInt("id"));
					prof.setNom(rs.getString("nom"));
					prof.setPrenom(rs.getString("prenom"));
					prof.setTel(rs.getString("tel"));
					prof.setEmail(rs.getString("email"));
					prof.setAdresse(rs.getString("adresse"));
					prof.setSpecialite(rs.getString("specialite"));

					oblist.add(prof);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//col_id.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("id"));
		col_nom.setCellValueFactory(new PropertyValueFactory<Prof, String>("nom"));
		col_prenom.setCellValueFactory(new PropertyValueFactory<Prof, String>("prenom"));
		col_tel.setCellValueFactory(new PropertyValueFactory<Prof, String>("tel"));
		col_email.setCellValueFactory(new PropertyValueFactory<Prof, String>("email"));
		col_adresse.setCellValueFactory(new PropertyValueFactory<Prof, String>("adresse"));
		col_specialite.setCellValueFactory(new PropertyValueFactory<Prof, String>("specialite"));

	    txtnom.setText("");
	    txtprenom.setText("");
	    txttel.setText("");
	    txtemail.setText("");
	    txtadresse.setText("");
	    txtspecialite.setText("");

		listeprofs.setItems(oblist);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		chargeTable();
		RechercheAV();
	}

	@FXML
	public void ajouterProf(ActionEvent e){

		/*if(txtnom.getText().equals("") || txtprenom.getText().equals("") ||txttel.getText().equals("") ||
				txtemail.getText().equals("") ||txtadresse.getText().equals("") ||txtspecialite.getText().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'un prof");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez remplir tous les champs !");
			alert.showAndWait();

		}*/

		Prof prof = new Prof();

		prof.setNom(txtnom.getText());
		prof.setPrenom(txtprenom.getText());
		prof.setTel(txttel.getText());
		prof.setEmail(txtemail.getText());
		prof.setAdresse(txtadresse.getText());
		prof.setSpecialite(txtspecialite.getText());

		Prof p = daoProf.getByNom(prof.getNom());
		if(p == null){

				daoProf.Ajouter(prof);

				chargeTable();
			}

		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'un prof");
				alert.setHeaderText("Ajout");
				alert.setContentText("Prof existe déjà !");
				alert.showAndWait();
	          }
		}


	@FXML
	public void supprimerProf(ActionEvent e){

	try {
		    int idProf = listeprofs.getSelectionModel().getSelectedItem().getId();
			daoProf.Supprimer(idProf);

			chargeTable();
	    }

	catch (Exception e2) {
		e2.printStackTrace();
	    }
	}


	@FXML
	private void onClickLine(MouseEvent event) {

		Prof prof = listeprofs.getSelectionModel().getSelectedItem();

		txtnom.setText(prof.getNom());
		txtprenom.setText(prof.getPrenom());
		txttel.setText(prof.getTel());
		txtemail.setText(prof.getEmail());
		txtadresse.setText(prof.getAdresse());
		txtspecialite.setText(prof.getSpecialite());

	}


	@FXML
	void modifierProf(ActionEvent e){

		int idProf = listeprofs.getSelectionModel().getSelectedItem().getId();

		Prof prof = new Prof();

		prof.setId(idProf);
		prof.setNom(txtnom.getText());
		prof.setPrenom(txtprenom.getText());
		prof.setTel(txttel.getText());
		prof.setEmail(txtemail.getText());
		prof.setAdresse(txtadresse.getText());
		prof.setSpecialite(txtspecialite.getText());

		daoProf.Modifier(prof);

		chargeTable();
	}



	public void RechercheAV(){
		// Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Prof> filteredData = new FilteredList<>(oblist, b -> true);

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
		SortedList<Prof> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(listeprofs.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		listeprofs.setItems(sortedData);
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
