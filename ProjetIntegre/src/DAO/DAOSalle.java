package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Prof;
import Model.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOSalle extends DAO <Salle>{

	String Requete;
	ResultSet res;

	@Override
	public void Ajouter(Salle s) {

		Requete="insert into salle(nom, capacite) values(?,?)";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, s.getNom());
				DAO.preparStat.setInt(2, s.getCapacite());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur d'ajout d'une salle");
				e.printStackTrace();
		     }

	}

	@Override
	public void Modifier(Salle s) {

		Requete="update salle Set nom=?, capacite=? where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, s.getNom());
				DAO.preparStat.setInt(2, s.getCapacite());
				DAO.preparStat.setInt(3, s.getId());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de modification d'une salle");
				e.printStackTrace();
		     }


	}

	@Override
	public void Supprimer(int id) {

		Requete="delete from salle where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, id);

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de suppression d'une salle");
				e.printStackTrace();
		     }
	}

	public ObservableList<Salle> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Salle> oblist = FXCollections.observableArrayList();

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

		return oblist;
	}

	@Override
	public ResultSet getAll() {

		Requete="select nom, capacite from salle";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);
				res = DAO.preparStat.executeQuery();
				return(res);
		    }

		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Salle getById(int id) {

		String Requete = "select * from salle where id=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setInt(1, id);

			ResultSet res = DAO.preparStat.executeQuery();

			Salle s = new Salle();

			if(res.next())
				{
					s.setId(res.getInt("id"));
					s.setNom(res.getString("nom"));
					s.setCapacite(res.getInt("capacite"));

					return s;
				}

			return null;

		    }

		catch (SQLException e)
			{
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public Salle getByNom(String nom) {

		String Requete = "select * from salle where nom=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setString(1, nom);

			ResultSet res = DAO.preparStat.executeQuery();

			Salle s = new Salle();

			if(res.next())
				{
					s.setId(res.getInt("id"));
					s.setNom(res.getString("nom"));
					s.setCapacite(res.getInt("capacite"));

					return s;
				}

			return null;

		    }

		catch (SQLException e)
			{
				e.printStackTrace();
				return null;
			}
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

		Requete="CREATE TABLE IF NOT EXISTS  salle      "
				+" (                                    "
				+"   id INT  NOT NULL  AUTO_INCREMENT,  "
				+"   nom VARCHAR(255),                  "
				+"   capacite INT,                      "
				+"   PRIMARY KEY (id)                   "
				+" );                                   ";

		   try {
					DAO.preparStat=DAO.conn.prepareStatement(Requete);
					DAO.preparStat.execute();
			   }

		   catch (SQLException e)
		       {
					System.out.println("Erreur de creation  du tabe");
					e.printStackTrace();
		       }
	}

}
