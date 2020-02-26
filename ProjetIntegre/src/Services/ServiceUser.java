/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import IServices.IServiceEntities;
import DAO.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hamza
 */
public class ServiceUser implements IServiceEntities<User> {
    
     private Connection con;
     private Statement ste;

    public ServiceUser() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(User t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`users` ( `email`, `nom`, `prenom`, `role`) VALUES ( ?, ?, ?, ?);");
        pre.setString(1, t.getEmail());
        pre.setString(2, t.getNom());
        pre.setString(3, t.getPrenom());
        pre.setString(4, t.getRole());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(User t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("delete from users where id =?");
        pre.setInt(1,t.getId());
        pre.execute();
        
        return false;
    }

    @Override
    public boolean update(User t) throws SQLException {
        try {
            PreparedStatement pst = con.prepareStatement("update users set email=?, nom=?, prenom=?, role=? where id=?");
            pst.setString(1,t.getEmail());
            pst.setString(2,t.getNom());
            pst.setString(3,t.getPrenom());
            pst.setString(4,t.getRole());
            pst.setInt(5,t.getId());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from users");
        while (rs.next()) {
            int id = rs.getInt(1);
            String email = rs.getString(2);
            String nom = rs.getString(3);
            String prenom = rs.getString(4);
            String role = rs.getString(5);
            User u =new User(id, email, nom, prenom, role);
            arr.add(u);
        }
    return arr;
    }
    
             public ObservableList<String> ListeChauffeur() throws SQLException {
         ObservableList<String> arr=FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select nom, prenom from users where role='chauffeur' ");
        while (rs.next()) {
           
            String idChauffeur = rs.getString(1) + " "+  rs.getString(2);
            
          
        
            
            arr.add(idChauffeur);
        }
    return arr;
    }
    
              public ObservableList<User> ListeEleve() throws SQLException {
         ObservableList<User> arr=FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select id, nom, prenom, email, numTel from users where role='eleve' ");
        while (rs.next()) {
           
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            int numTel = rs.getInt(5);
            
            User u = new User(id,email,nom,prenom,numTel);
            
            arr.add(u);
        }
    return arr;
    }
              
                public ObservableList<User> RecherchePrenom(String nom) throws SQLException {
         ObservableList<User> arr=FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from users where prenom like '" + nom +"%'");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomm = rs.getString(3);
            String prenom = rs.getString(4);

            User u =new User(id, nomm, prenom);
            arr.add(u);
        }
    return arr;
    }
}
