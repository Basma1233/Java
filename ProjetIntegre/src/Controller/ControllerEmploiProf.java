package Controller;


import java.net.URL;
import java.time.temporal.JulianFields;
import java.util.List;
import java.util.ResourceBundle;

import DAO.DAOJour;
import Model.Horaire;
import Model.Jour;
import Model.Matiere;
import Model.Seance;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ControllerEmploiProf implements Initializable{

	DAOJour daoJour = new DAOJour();

	public static int idProf;
	public static List<Seance> seances ;
	@FXML
	private TableView<Horaire> listHoraireEmploi;
	@FXML
	private TableColumn<Horaire, String> col_heure;
	@FXML
	private TableColumn<Horaire, String> col_lundi;
	@FXML
	private TableColumn<Horaire, String> col_mardi;
	@FXML
	private TableColumn<Horaire, String> col_mercredi;
	@FXML
	private TableColumn<Horaire, String> col_jeudi;
	@FXML
	private TableColumn<Horaire, String> col_vendredi;
	@FXML
	private TableColumn<Horaire, String> col_samedi;
	ObservableList<Horaire> listJour;

	private List<Jour> jours;

	public Jour getJour(int id){
		for (Jour jour : jours) {
			if(jour.getId()==id)
				return jour;
		}
		return null;
	}
	
	
	public void chargerTable() {

		col_heure.setCellValueFactory(new Callback<CellDataFeatures<Horaire, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Horaire, String> horaireInstance) {


					return new ReadOnlyObjectWrapper(horaireInstance.getValue().getNom());
		  }
		 });
		col_lundi.setCellValueFactory(new Callback<CellDataFeatures<Horaire, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(CellDataFeatures<Horaire, String> horaireInstance) {

				 	Jour lundi;
				 	for (Seance seance : seances) {
				 		
				 		/* lundi = jours.stream().filter(jour -> (seance.getJour() == jour.getId() && jour.getNom().equals("lundi")) )
				 		  .findAny()
				 		  .orElse(null);
				 		if(lundi != null) break;*/

					}

					return new ReadOnlyObjectWrapper(horaireInstance.getValue().getNom());
		  }
		 });
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		jours = daoJour.getList();



	}


}
