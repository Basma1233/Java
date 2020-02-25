package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Horaire;
import Model.Prof;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOHoraire extends DAO <Horaire>{

	public ObservableList<Horaire> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Horaire> oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from horaire");
			while(rs.next()){
				Horaire horaire = new Horaire();
				horaire.setId(rs.getInt("id"));
				horaire.setNom(rs.getString("nom"));

				oblist.add(horaire);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oblist;
	}

	@Override
	public void Ajouter(Horaire o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modifier(Horaire o) {
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
	public Horaire getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Horaire getByNom(String nom) {
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
