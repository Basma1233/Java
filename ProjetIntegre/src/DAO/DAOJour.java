package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Horaire;
import Model.Jour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOJour extends DAO <Jour>{

	public ObservableList<Jour> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Jour> oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from jour");
			while(rs.next()){
				Jour jour = new Jour();
				jour.setId(rs.getInt("id"));
				jour.setNom(rs.getString("nom"));

				oblist.add(jour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oblist;
	}

	@Override
	public void Ajouter(Jour o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modifier(Jour o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Supprimer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jour getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jour getByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet Find_ById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet Find_ByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateTable() {
		// TODO Auto-generated method stub

	}

}
