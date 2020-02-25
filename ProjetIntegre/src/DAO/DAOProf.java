package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Classe;
import Model.Prof;
import Model.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

public class DAOProf extends DAO <Prof>{

	String Requete;
	ResultSet res;

	@Override
	public void Ajouter(Prof p) {

		Requete="insert into prof(nom, prenom, tel, email, adresse, specialite) values(?,?,?,?,?,?)";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, p.getNom());
				DAO.preparStat.setString(2, p.getPrenom());
				DAO.preparStat.setString(3, p.getTel());
				DAO.preparStat.setString(4, p.getEmail());
				DAO.preparStat.setString(5, p.getAdresse());
				DAO.preparStat.setString(6, p.getSpecialite());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur d'ajout d'un prof");
				e.printStackTrace();
		     }


	}

	@Override
	public void Modifier(Prof p) {

		Requete="update prof Set nom=?, prenom=?, tel=?, email=?, adresse=?, specialite=? where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, p.getNom());
				DAO.preparStat.setString(2, p.getPrenom());
				DAO.preparStat.setString(3, p.getTel());
				DAO.preparStat.setString(4, p.getEmail());
				DAO.preparStat.setString(5, p.getAdresse());
				DAO.preparStat.setString(6, p.getSpecialite());
                                DAO.preparStat.setInt(7, p.getId());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de modification d'un prof");
				e.printStackTrace();
		     }

	}

	@Override
	public void Supprimer(int id) {

		Requete="delete from prof where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, id);

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de suppression d'un prof");
				e.printStackTrace();
		     }
	}



	public ObservableList<Prof> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Prof> oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from prof");
			while(rs.next()){
				Prof prof = new Prof();
				prof.setId(rs.getInt("id"));
				prof.setNom(rs.getString("nom"));
				prof.setPrenom(rs.getString("prenom"));
				prof.setTel(rs.getString("tel"));
				prof.setEmail(rs.getString("adresse"));
				prof.setAdresse(rs.getString("adresse"));
				prof.setSpecialite(rs.getString("specialite"));

				oblist.add(prof);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oblist;
	}

	@Override
	public ResultSet getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prof getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prof getByNom(String nom) {
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
