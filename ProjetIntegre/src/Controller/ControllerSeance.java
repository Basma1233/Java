package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import DAO.ConnexionBd;
import DAO.DAO;
import DAO.DAOClasse;
import DAO.DAOHoraire;
import DAO.DAOJour;
import DAO.DAOMatiere;
import DAO.DAOProf;
import DAO.DAOSalle;
import DAO.DAOSeance;
import LoginForm.LoginForm;
import Model.Classe;
import Model.Horaire;
import Model.Jour;
import Model.Matiere;
import Model.Prof;
import Model.Salle;
import Model.Seance;
import Utility.EnvoyerEmail;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class ControllerSeance implements Initializable{

	String Requete;
	ResultSet res;

	DAOSeance DAOseance = new DAOSeance();
	DAOProf daoProf = new DAOProf();
	DAOClasse daoClasse = new DAOClasse();
	DAOMatiere daoMatiere = new DAOMatiere();
	DAOSalle daoSalle = new DAOSalle();
	DAOHoraire daoHoraire = new DAOHoraire();
	DAOJour daoJour = new DAOJour();

	@FXML
	private ComboBox<Classe> cbclasse;
	@FXML
	private ComboBox<Matiere> cbmatiere;
	@FXML
	private ComboBox<Salle> cbsalle;
	@FXML
	private ComboBox<Prof> cbprof;
	@FXML
	private ComboBox<Horaire> cbhoraire;
	@FXML
	private ComboBox<Jour> cbjour;

	@FXML
	private ComboBox<Classe> cbclasseemploi;
	@FXML
	private ComboBox<Prof> cbprofemploi;

	@FXML
	private Button ajouterseance;
	@FXML
	private Button supprimerseance;
	@FXML
	private Button modifierseance;

	@FXML
	private Button afficheremploiclasse;
	@FXML
	private Button afficheremploiprof;

	@FXML
	private TableView<Seance> listeseances;
	@FXML
	private TableColumn<Seance, String> col_classe;
	@FXML
	private TableColumn<Seance, String> col_matiere;
	@FXML
	private TableColumn<Seance, String> col_salle;
	@FXML
	private TableColumn<Seance, String> col_prof;
	@FXML
	private TableColumn<Seance, String> col_horaire;
	@FXML
	private TableColumn<Seance, String> col_jour;

	ObservableList<Seance> oblist;

	ObservableList<Prof> listProf;
	ObservableList<Classe> listClasse;
	ObservableList<Matiere> listMatiere;
	ObservableList<Salle> listSalle;
	ObservableList<Horaire> listHoraire;
	ObservableList<Jour> listJour;

	ObservableList<Classe> listClasseEmploi;
	ObservableList<Prof> listProfEmploi;

	private void chargerComboboxProf() {

		listProf = daoProf.getList();
		cbprof.getItems().addAll(listProf);
	}

	private void chargerComboboxClasse() {

		listClasse = daoClasse.getList();
		cbclasse.getItems().addAll(listClasse);
	}

	private void chargerComboboxMatiere() {

		listMatiere = daoMatiere.getList();
		cbmatiere.getItems().addAll(listMatiere);
	}

	private void chargerComboboxSalle() {

		listSalle = daoSalle.getList();
		cbsalle.getItems().addAll(listSalle);
	}

	private void chargerComboboxHoraire() {

		listHoraire = daoHoraire.getList();
		cbhoraire.getItems().addAll(listHoraire);
	}

	private void chargerComboboxJour() {

		listJour = daoJour.getList();
		cbjour.getItems().addAll(listJour);
	}

	private void chargerComboboxClasseEmploi() {

		listClasseEmploi = daoClasse.getList();
		cbclasseemploi.getItems().addAll(listClasseEmploi);
	}

	private void chargerComboboxProfEmploi() {

		listProfEmploi = daoProf.getList();
		cbprofemploi.getItems().addAll(listProfEmploi);
	}


	void chargeTable() {

		Connection con = ConnexionBd.getConnexion();

		oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from seance");
			while(rs.next()){
				Seance senace = new Seance();
				senace.setId(rs.getInt("id"));
				senace.setClasse(rs.getInt("classe"));
				senace.setMatiere(rs.getInt("matiere"));
				senace.setSalle(rs.getInt("salle"));
				senace.setProf(rs.getInt("prof"));
				senace.setHoraire(rs.getInt("horaire"));
				senace.setJour(rs.getInt("jour"));

				oblist.add(senace);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//col_id.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("id"));
		//col_classe.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("classe"));

		col_classe.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nomClasse ="";
		    	 for (Classe classe : listClasse) {
					if(classe.getId()== seanceInstance.getValue().getClasse()){
						nomClasse = (classe.getNom());
						break;
					}}
					return new ReadOnlyObjectWrapper( nomClasse);


		  }
		 });

		col_matiere.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nomMatiere ="";
		    	 for (Matiere matiere : listMatiere) {
					if(matiere.getId()== seanceInstance.getValue().getMatiere()){
						nomMatiere = matiere.getNom();
						break;
					}}
					return new ReadOnlyObjectWrapper( nomMatiere);


		  }
		 });
		col_salle.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nom ="";
		    	 for (Salle salle : listSalle) {
					if(salle.getId()== seanceInstance.getValue().getSalle()){
						nom = salle.getNom();
						break;
					}}
					return new ReadOnlyObjectWrapper( nom);


		  }
		 });
		col_prof.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nom ="";
		    	 for (Prof prof : listProf) {
					if(prof.getId()== seanceInstance.getValue().getProf()){
						nom = prof.getNom();
						break;
					}}
					return new ReadOnlyObjectWrapper( nom);


		  }
		 });
		col_horaire.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nom ="";
		    	 for (Horaire horaire : listHoraire) {
					if(horaire.getId()== seanceInstance.getValue().getHoraire()){
						nom = horaire.getNom();
						break;
					}}
					return new ReadOnlyObjectWrapper( nom);


		  }
		 });
		col_jour.setCellValueFactory(new Callback<CellDataFeatures<Seance, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Seance, String> seanceInstance) {
		         // p.getValue() returns the Person instance for a particular TableView row
				 String nom ="";
		    	 for (Jour jour: listJour) {
					if(jour.getId()== seanceInstance.getValue().getJour()){
						nom = jour.getNom();
						break;
					}}
					return new ReadOnlyObjectWrapper( nom);
		  }
		 });
		//col_matiere.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("matiere"));
		//col_salle.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("salle"));
	/*	col_prof.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("prof"));
		col_horaire.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("horaire"));
		col_jour.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("jour"));
*/
	    cbclasse.setValue(null);
	    cbmatiere.setValue(null);
	    cbsalle.setValue(null);
	    cbprof.setValue(null);
	    cbhoraire.setValue(null);
	    cbjour.setValue(null);

		listeseances.setItems(oblist);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		chargerComboboxProf();
		chargerComboboxClasse();
		chargerComboboxMatiere();
		chargerComboboxSalle();
		chargerComboboxHoraire();
		chargerComboboxJour();

		chargerComboboxClasseEmploi();
		chargerComboboxProfEmploi();

		chargeTable();
	}


	@FXML
	public void ajouterSeance(ActionEvent e){

		if(cbclasse.getValue().equals("") || cbmatiere.getValue().equals("") || cbsalle.getValue().equals("")
				|| cbprof.getValue().equals("") || cbhoraire.getValue().equals("") || cbjour.getValue().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'une séance");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez préciser toutes les informations concernant cette séance !");
			alert.showAndWait();

		}
		// les informations à afficher dans l'eamil
		String matiere = cbmatiere.getValue().getNom();
		String classe = cbclasse.getValue().getNom();
		String salle = cbsalle.getValue().getNom();
		String jour = cbjour.getValue().getNom();
		String horaire = cbhoraire.getValue().getNom();
		Seance seance = new Seance();

		seance.setClasse(cbclasse.getValue().getId());
		seance.setMatiere(cbmatiere.getValue().getId());
		seance.setSalle(cbsalle.getValue().getId());
		seance.setProf(cbprof.getValue().getId());
		seance.setHoraire(cbhoraire.getValue().getId());
		seance.setJour(cbjour.getValue().getId());

		Seance SeanceByClasse = DAOseance.getSeanceByClasse(cbclasse.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());
		Seance SeanceByProf = DAOseance.getSeanceByProf(cbprof.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());
		Seance SeanceBySalle = DAOseance.getSeanceBySalle(cbsalle.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());

		if(SeanceByClasse == null && SeanceByProf == null && SeanceBySalle == null){

				DAOseance.Ajouter(seance);

				chargeTable();

				Thread t = new Thread(){
				    @Override
					public void run() {
						try {



							String message = "Nous vous informons que vous avez une nouvelle séance : "
									+ " Séance de : "+matiere
									+" Pour le classe : "+classe
									+" Dans la salle : "+salle
									+" Le : "+jour+" à : "+horaire;
							System.out.println(LoginForm.user.getEmail());
							EnvoyerEmail.sendMail("sediridhia@gmail.com", "Nouvelle séance", message);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					};
				};
				t.start();
			}
		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'une seance");
				alert.setHeaderText("Ajout");
				alert.setContentText("Séance impossible, veuillez bien vérifier vos chois !");
				alert.showAndWait();
	          }
		}


	@FXML
	public void supprimerSeance(ActionEvent e){

		try {
			    int idSeance = listeseances.getSelectionModel().getSelectedItem().getId();
				DAOseance.Supprimer(idSeance);

				chargeTable();
		    }

		catch (Exception e2) {
			e2.printStackTrace();
		    }
		}


	@FXML
	private void onClickLine(MouseEvent event) {

		Seance seance = listeseances.getSelectionModel().getSelectedItem();

		for (Classe classe : listClasse) {
			if(classe.getId() == seance.getClasse()){
				cbclasse.setValue(classe);
			}
		}
		for (Matiere matiere : listMatiere) {
			if(matiere.getId() == seance.getMatiere()){
				cbmatiere.setValue(matiere);
			}
		}
		for (Salle salle : listSalle) {
			if(salle.getId() == seance.getSalle()){
				cbsalle.setValue(salle);
			}
		}
		for (Prof prof : listProf) {
			if(prof.getId() == seance.getProf()){
				cbprof.setValue(prof);
			}
		}
		for (Horaire horaire : listHoraire) {
			if(horaire.getId() == seance.getHoraire()){
				cbhoraire.setValue(horaire);
			}
		}
		for (Jour jour : listJour) {
			if(jour.getId() == seance.getJour()){
				cbjour.setValue(jour);
			}
		}
		//cbclasse.setValue();
		//cbmatiere.setValue(seance.getMatiere());
		//cbsalle.setValue(seance.getSalle());
		//cbprof.setValue(seance.getProf());
		//cbhoraire.setValue(seance.getHoraire());
		//cbjour.setValue(seance.getJour());
	}


	@FXML
	void modifierSeance(ActionEvent e){

		if(cbclasse.getValue().equals("") || cbmatiere.getValue().equals("") || cbsalle.getValue().equals("")
				|| cbprof.getValue().equals("") || cbhoraire.getValue().equals("") || cbjour.getValue().equals("")){

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ajout d'une séance");
			alert.setHeaderText("Ajout");
			alert.setContentText("Vous devez préciser toutes les informations concernant cette séance !");
			alert.showAndWait();

		}

		int idSeance = listeseances.getSelectionModel().getSelectedItem().getId();

		Seance seance = new Seance();
		seance.setId(idSeance);
		seance.setClasse(cbclasse.getValue().getId());
		seance.setMatiere(cbmatiere.getValue().getId());
		seance.setSalle(cbsalle.getValue().getId());
		seance.setProf(cbprof.getValue().getId());
		seance.setHoraire(cbhoraire.getValue().getId());
		seance.setJour(cbjour.getValue().getId());

		Seance SeanceByClasse = DAOseance.getSeanceByClasse(cbclasse.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());
		Seance SeanceByProf = DAOseance.getSeanceByProf(cbprof.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());
		Seance SeanceBySalle = DAOseance.getSeanceBySalle(cbsalle.getValue().getId(), cbhoraire.getValue().getId(), cbjour.getValue().getId());

		if(SeanceByClasse == null && SeanceByProf == null && SeanceBySalle == null){

			DAOseance.Modifier(seance);
			chargeTable();
		}

		else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ajout d'une seance");
				alert.setHeaderText("Ajout");
				alert.setContentText("Séance impossible, veuillez bien vérifier vos chois !");
				alert.showAndWait();
	          }
	}


	@FXML
	void afficherEmploiClasse(){

		ArrayList<Seance> seancesParClasse = DAOseance.getALLSeanceByClasse(cbclasseemploi.getValue().getId());

		oblist.setAll(seancesParClasse);

		listeseances.setItems(oblist);
	}


	@FXML
	void afficherEmploiProf(){

	/*	ArrayList<Seance> seancesParprof = DAOseance.getALLSeanceByProf(cbprofemploi.getValue().getId());

		oblist.setAll(seancesParprof);

		listeseances.setItems(oblist);
		*/

		final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vue/EmploiProf.fxml"));
		ControllerEmploiProf.idProf = cbprofemploi.getValue().getId();
		 // Create a List from the Iterable
        List<Seance> list = StreamSupport
                           .stream(oblist.spliterator(), false)
                           .collect(Collectors.toList());
        ControllerEmploiProf.seances =  list;
		//ControllerEmploiProf.idProf = oblist.listIterator();
		//  Object scene2Controller = fxmlLoader.getController();
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
