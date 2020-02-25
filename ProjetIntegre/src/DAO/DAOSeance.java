package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Seance;

public class DAOSeance extends DAO <Seance>{

	String Requete;
	ResultSet res;

	@Override
	public void Ajouter(Seance s) {

		Requete="insert into seance(classe, matiere, salle, prof, horaire, jour) values(?,?,?,?,?,?)";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, s.getClasse());
				DAO.preparStat.setInt(2, s.getMatiere());
				DAO.preparStat.setInt(3, s.getSalle());
				DAO.preparStat.setInt(4, s.getProf());
				DAO.preparStat.setInt(5, s.getHoraire());
				DAO.preparStat.setInt(6, s.getJour());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur d'ajout d'une seance");
				e.printStackTrace();
		     }

	}

	@Override
	public void Modifier(Seance s) {

		Requete="update seance Set classe=?, matiere=?, salle=?, prof=?, horaire=?, jour=? where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, s.getClasse());
				DAO.preparStat.setInt(2, s.getMatiere());
				DAO.preparStat.setInt(3, s.getSalle());
				DAO.preparStat.setInt(4, s.getProf());
				DAO.preparStat.setInt(5, s.getHoraire());
				DAO.preparStat.setInt(6, s.getJour());
				DAO.preparStat.setInt(7, s.getId());

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de modification d'une seance");
				e.printStackTrace();
		     }

	}

	@Override
	public void Supprimer(int id) {

		Requete="delete from seance where id=?";

		try {
				DAO.preparStat=DAO.conn.prepareStatement(Requete);

				DAO.preparStat.setInt(1, id);

				DAO.preparStat.execute();
		    }

		catch (SQLException e)
		     {
				System.out.println("Erreur de suppression d'une seance");
				e.printStackTrace();
		     }

	}


	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public ArrayList<Seance> getALLSeanceByClasse(int classe){

		ArrayList<Seance> tab=new ArrayList<Seance>();

		Requete = "select * from seance where classe=? ";

  	   try {
	  		      DAO.preparStat = DAO.conn.prepareStatement(Requete);
	              DAO.preparStat.setInt(1,classe);
	              res = DAO.preparStat.executeQuery();

	              while(res.next())
		              {
		            	 Seance s =new Seance();

		            	 s.setId(res.getInt("id"));
		            	 s.setClasse(res.getInt("classe"));
		            	 s.setMatiere(res.getInt("matiere"));
		            	 s.setSalle(res.getInt("salle"));
		            	 s.setProf(res.getInt("prof"));
		            	 s.setHoraire(res.getInt("horaire"));
		            	 s.setJour(res.getInt("jour"));

		           	     tab.add(s);
		              }

	            }

  	   catch (SQLException ex)
	  	   {
	  		   System.out.print("Erreur liste seances");
	  		   return null;
	  	   }

		return tab;

	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public ArrayList<Seance> getALLSeanceByProf(int prof){

		ArrayList<Seance> tab=new ArrayList<Seance>();

        Requete = "select * from seance where prof=? ";

        try {
		        DAO.preparStat = DAO.conn.prepareStatement(Requete);
	            DAO.preparStat.setInt(1,prof);
	            res = DAO.preparStat.executeQuery();

            while(res.next())
	              {
	            	 Seance s =new Seance();

	            	 s.setId(res.getInt("id"));
	            	 s.setClasse(res.getInt("classe"));
	            	 s.setMatiere(res.getInt("matiere"));
	            	 s.setSalle(res.getInt("salle"));
	            	 s.setProf(res.getInt("prof"));
	            	 s.setHoraire(res.getInt("horaire"));
	            	 s.setJour(res.getInt("jour"));

	           	     tab.add(s);
	              }

          }

	   catch (SQLException ex)
		   {
			   System.out.print("Erreur liste seances");
			   return null;
		   }

	return tab;
	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public ArrayList<String> ListeDesJours(){

		ArrayList<String> tab=new ArrayList<String>();

         Requete = "select nom from jour ";

   	   try {
   		      DAO.preparStat=DAO.conn.prepareStatement(Requete);
              res=DAO.preparStat.executeQuery();

              while(res.next())
              {
            	  tab.add(res.getString("nom"));
              }

           }

   	   catch (SQLException ex){
   		   System.out.print("Erreur liste jours");
   		   return null;
   		   }


		return tab;
	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public int getidSeance(Seance s){

	   Requete = "select id  from seance where (classe=?) and (matiere=?) and (salle=?) and (prof=?) and (horaire=?) and (jour=?) ";

	   try {

		      DAO.preparStat=DAO.conn.prepareStatement(Requete);

	          DAO.preparStat.setInt(1, s.getClasse());
	          DAO.preparStat.setInt(2, s.getMatiere());
	          DAO.preparStat.setInt(3, s.getSalle());
	          DAO.preparStat.setInt(4, s.getProf());
	          DAO.preparStat.setInt(5, s.getHoraire());
	          DAO.preparStat.setInt(6, s.getJour());

              res=DAO.preparStat.executeQuery();

              if(res.next())
              {
                   int idSeance = res.getInt("id");
          	       return idSeance;
              }
              else
                  return -1;
            }

	    catch (SQLException ex)
	        {
		        System.out.print("Erreur de recupération idSeance");
			    return -1;
	        }
	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public ArrayList<String> ListeDesHoraires(){

		ArrayList<String> tab=new ArrayList<String>();

         Requete = "select nom from horaire ";

   	   try {
   		      DAO.preparStat=DAO.conn.prepareStatement(Requete);
              res=DAO.preparStat.executeQuery();

              while(res.next())
              {
            	  tab.add(res.getString("nom"));
              }

            }
   	   catch (SQLException ex)
	   	   {
	   		   System.out.print("Erreur liste horaires");
	   	       return null;
	   	   }

		return tab;
	}
	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceByProf(int prof,int horaire,int jour){

         Seance s = null;

         Requete = "select * from seance where (prof=?) and (horaire=?) and (jour=?)";

   	   try {
   		      DAO.preparStat=DAO.conn.prepareStatement(Requete);

	          DAO.preparStat.setInt(1, prof);
	          DAO.preparStat.setInt(2, horaire);
	          DAO.preparStat.setInt(3, jour);

              res=DAO.preparStat.executeQuery();

              if(res.next())
	              {
	            	 s = new Seance();

	            	 s.setId(res.getInt("id"));
	            	 s.setClasse(res.getInt("classe"));
	            	 s.setMatiere(res.getInt("matiere"));
	            	 s.setSalle(res.getInt("salle"));
	            	 s.setProf(res.getInt("prof"));
	            	 s.setHoraire(res.getInt("horaire"));
	            	 s.setJour(res.getInt("jour"));
	              }
            }

   	   catch (SQLException ex)
	   	   {
	   		   System.out.print("Erreur getSeanceProf");
	   		   return null;
	   	   }

	return s;
	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceByClasse(int classe,int horaire,int jour)
	{
         Seance s = null;

         Requete = "select * from seance where (classe=?) and (horaire=?) and (jour=?)";

   	   try {
   		      DAO.preparStat=DAO.conn.prepareStatement(Requete);

	          DAO.preparStat.setInt(1, classe);
	          DAO.preparStat.setInt(2, horaire);
	          DAO.preparStat.setInt(3, jour);

              res=DAO.preparStat.executeQuery();

              if(res.next())
              {
            	 s = new Seance();

            	 s.setId(res.getInt("id"));
            	 s.setClasse(res.getInt("classe"));
            	 s.setMatiere(res.getInt("matiere"));
            	 s.setSalle(res.getInt("salle"));
            	 s.setProf(res.getInt("prof"));
            	 s.setHoraire(res.getInt("horaire"));
            	 s.setJour(res.getInt("jour"));
              }
        }

	   catch (SQLException ex)
	   	   {
	   		   System.out.print("Erreur getSeanceClasse");
	   		   return null;
	   	   }

	return s;

	}
	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceBySalle(int salle,int horaire,int jour)
	{
         Seance s = null;

         Requete = "select * from seance where (salle=?) and (horaire=?) and (jour=?)";

   	   try {
   		      DAO.preparStat=DAO.conn.prepareStatement(Requete);

	          DAO.preparStat.setInt(1, salle);
	          DAO.preparStat.setInt(2, horaire);
	          DAO.preparStat.setInt(3, jour);

              res=DAO.preparStat.executeQuery();

              if(res.next())
              {
            	 s = new Seance();

            	 s.setId(res.getInt("id"));
            	 s.setClasse(res.getInt("classe"));
            	 s.setMatiere(res.getInt("matiere"));
            	 s.setSalle(res.getInt("salle"));
            	 s.setProf(res.getInt("prof"));
            	 s.setHoraire(res.getInt("horaire"));
            	 s.setJour(res.getInt("jour"));
              }
        }

	   catch (SQLException ex)
	   	   {
	   		   System.out.print("Erreur getSeanceSalle");
	   		   return null;
	   	   }

	return s;

	}

	/*========================================================================================================================*/
	/*========================================================================================================================*/
	/*========================================================================================================================*/

	@Override
	public ResultSet getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seance getByNom(String nom) {
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
