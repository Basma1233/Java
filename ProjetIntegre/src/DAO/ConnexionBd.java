package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBd {

	static  String login="root";
	   static String  mot_de_pass="";
	   static String  urlPilot="com.mysql.jdbc.Driver";
	   static  String nomBase_de_donne="ecole";

	   static String  urlBase_de_donne="jdbc:mysql://localhost:3306/"+nomBase_de_donne;


	   /*========================================================================================================================*/
	   	/*========================================================================================================================*/
	   	/*========================================================================================================================*/

	   /*Singleton===>Il n'est pas possible de creer plus qu'un seul instance du classe
	   private static ConnexionBd cnxBD;
	   private ConnexionBd(){

	   }
	   public static ConnexionBd getInstance(){
		   if(cnxBD==null)
			   cnxBD=new ConnexionBd();
		   return cnxBD;
	   }
	   Singleton*/

	   public static Connection getConnexion()
	   {

			Connection con = null;

			try{

					 Class.forName(urlPilot);
					 con =DriverManager.getConnection(urlBase_de_donne,login,mot_de_pass);
					 System.out.println("connection avec la base ok");

			    } catch(Exception ex){System.out.println(" Pas de connection ");  return null;}

			   return con;

	   }

}
