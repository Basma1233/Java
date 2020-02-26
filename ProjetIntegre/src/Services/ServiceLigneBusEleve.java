/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.LigneBusEleve;
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
public class ServiceLigneBusEleve implements IServiceEntities<LigneBusEleve> {
    
    private Connection con;
    private Statement ste;

    public ServiceLigneBusEleve() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(LigneBusEleve t) throws SQLException {
         PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`lignesbuseleves` ( `idLigne`, `idEleve`, `nomEleve`, `prenomEleve` ) VALUES ( ?, ?, ?, ?);");
        pre.setInt(1, t.getIdLigne());
        pre.setInt(2, t.getIdEleve());
        pre.setString(3, t.getNom());
        pre.setString(4, t.getPrenom());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(LigneBusEleve t) throws SQLException {
       PreparedStatement pre = con.prepareStatement("delete from lignesbuseleves where idEleve =?");
        pre.setInt(1,t.getIdEleve());
        pre.execute();
         return false;
    }

    @Override
    public boolean update(LigneBusEleve t) throws SQLException {
      try {
            PreparedStatement pst = con.prepareStatement("update lignesbusEleves set idLigne=? where idEleve=?");
            pst.setInt(1,t.getIdLigne());
            pst.setInt(2,t.getIdEleve());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    @Override
    public ObservableList<LigneBusEleve> readAll() throws SQLException {
              ObservableList<LigneBusEleve> arr= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from lignesbuseleves");
        while (rs.next()) {
            int idLigne = rs.getInt(1);
            int idEleve = rs.getInt(2);

            LigneBusEleve lbe =new LigneBusEleve(idLigne, idEleve);
            arr.add(lbe);
        }
    return arr;
    }
    
    
      public ObservableList<LigneBusEleve> Display(String idLigneP) throws SQLException {
              ObservableList<LigneBusEleve> arr= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("SELECT DISTINCT idLigne, idEleve, nomEleve, prenomEleve FROM `lignesbuseleves` WHERE idLigne =" + idLigneP);
        while (rs.next()) {
            int idLigne = rs.getInt(1);
            int idEleve = rs.getInt(2);
            String prenom = rs.getString(3);
            String nom = rs.getString(4);

            LigneBusEleve lbe =new LigneBusEleve(idLigne, idEleve,prenom,nom);
            arr.add(lbe);
        }
    return arr;
    }
    
}
