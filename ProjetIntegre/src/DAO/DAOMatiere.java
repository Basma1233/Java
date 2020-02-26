package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Matiere;
import Model.Prof;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOMatiere extends DAO <Matiere>{

	String Requete;
	ResultSet res;

	@Override
	public void Ajouter(Matiere m) {

		Requete="insert into matiere(nom, coefficient) values(?,?)";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, m.getNom());
				DAO.preparStat.setInt(2, m.getCoefficient());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur d'ajout d'une matiere");
				e.printStackTrace();
		     }

	}

	@Override
	public void Modifier(Matiere m) {

		Requete="update matiere Set nom=?, coefficient=? where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setString(1, m.getNom());
				DAO.preparStat.setInt(2, m.getCoefficient());
				DAO.preparStat.setInt(3, m.getId());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de modification d'une matiere");
				e.printStackTrace();
		     }

	}

	@Override
	public void Supprimer(int id) {

		Requete="delete from matiere where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, id);

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de suppression d'une matiere");
				e.printStackTrace();
		     }
	}

	public ObservableList<Matiere> getList(){

		Connection con = ConnexionBd.getConnexion();
		ObservableList<Matiere> oblist = FXCollections.observableArrayList();

		try {
			ResultSet rs = con.createStatement().executeQuery("select * from matiere");
			while(rs.next()){
				Matiere matiere = new Matiere();
				matiere.setId(rs.getInt("id"));
				matiere.setNom(rs.getString("nom"));
				matiere.setCoefficient(rs.getInt("coefficient"));

				oblist.add(matiere);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oblist;

	}

	@Override
	public ResultSet getAll() {

		Requete="select nom, coefficient from matiere";

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
	public Matiere getById(int id) {

		String Requete = "select * from matiere where id=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setInt(1, id);

			ResultSet res = DAO.preparStat.executeQuery();

			Matiere m = new Matiere();

			if(res.next())
				{
					m.setId(res.getInt("id"));
					m.setNom(res.getString("nom"));
					m.setCoefficient(res.getInt("coefficient"));

					return m;
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
	public Matiere getByNom(String nom) {

		String Requete = "select * from matiere where nom=?";

		try {

			DAO.preparStat=DAO.conn.prepareStatement(Requete);
			DAO.preparStat.setString(1, nom);

			ResultSet res = DAO.preparStat.executeQuery();

			Matiere m = new Matiere();

			if(res.next())
				{
					m.setId(res.getInt("id"));
					m.setNom(res.getString("nom"));
					m.setCoefficient(res.getInt("coefficient"));

					return m;
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

		Requete="CREATE TABLE IF NOT EXISTS  matiere    "
				+" (                                    "
				+"   id INT  NOT NULL  AUTO_INCREMENT,  "
				+"   nom VARCHAR(255),                  "
				+"   coefficient INT,                   "
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
