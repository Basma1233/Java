package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Model.Classe;
import Model.Prof;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOClasse extends DAO<Classe>{

	String Requete;
	ResultSet res;

	@Override
	public void Ajouter(Classe c) {

		Requete="insert into classe(nom, niveau, capacite) values(?,?,?)";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, c.getNom());
				DAO.preparStat.setInt(2, c.getNiveau());
				DAO.preparStat.setInt(3, c.getCapacite());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur d'ajout d'un classe");
				e.printStackTrace();
		     }

	}

	@Override
	public void Modifier(Classe c) {

		Requete="update classe Set nom=?, niveau=?, capacite=? where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, c.getNom());
				DAO.preparStat.setInt(2, c.getNiveau());
				DAO.preparStat.setInt(3, c.getCapacite());
				DAO.preparStat.setInt(4, c.getId());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de modification d'un classe");
				e.printStackTrace();
		     }

	}

	@Override
	public void Supprimer(int id) {

		Requete="delete from classe where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, id);

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de suppression d'un classe");
				e.printStackTrace();
		     }
	}

	public ObservableList<Classe> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Classe> oblist = FXCollections.observableArrayList();

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

		return oblist;
	}

	//methode pour tester l'ajout d'un classe
	public ResultSet getByNomEtNiveau(){

		Requete="select * from classe where nom=?, niveau=?";

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
	public ResultSet getAll() {

		Requete="select nom, niveau, capacite from classe";

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
	public Classe getById(int id) {

		String Requete = "select * from classe where id=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setInt(1, id);

			ResultSet res = DAO.preparStat.executeQuery();

			Classe c = new Classe();

			if(res.next())
				{
					c.setId(res.getInt("id"));
					c.setNom(res.getString("nom"));
					c.setNiveau(res.getInt("niveau"));
					c.setCapacite(res.getInt("capacite"));

					return c;
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
	public Classe getByNom(String nom) {

		String Requete = "select * from classe where nom=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setString(1, nom);

			ResultSet res = DAO.preparStat.executeQuery();

			Classe c = new Classe();

			if(res.next())
				{
					c.setId(res.getInt("id"));
					c.setNom(res.getString("nom"));
					c.setNiveau(res.getInt("niveau"));
					c.setCapacite(res.getInt("capacite"));

					return c;
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

		Requete="CREATE TABLE IF NOT EXISTS  classe     "
				+" (                                    "
				+"   id INT  NOT NULL  AUTO_INCREMENT,  "
				+"   nom VARCHAR(255),                  "
				+"   niveau INT,                        "
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
