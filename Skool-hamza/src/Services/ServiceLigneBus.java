/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.LigneBus;
import IServices.IServiceEntities;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hamza
 */

public class ServiceLigneBus implements IServiceEntities<LigneBus> {
    
    private Connection con;
    private Statement ste;

    public ServiceLigneBus() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(LigneBus t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `skool`.`lignesbus` ( `idChauffeur`, `adresseDepart`, `capacite`, `heureDepart`) VALUES ( ?, ?, ?, ?);");
        pre.setInt(1, t.getIdChauffeur());
        pre.setString(2, t.getDepartAdresse());
        pre.setInt(3, t.getCapacite());
        pre.setString(4, t.getDepartHeure());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(LigneBus t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("delete from lignesbus where idLigne =?");
        pre.setInt(1,t.getIdLigne());
        pre.execute();
         return false;
    }

    @Override
    public boolean update(LigneBus t) throws SQLException {
        try {
            PreparedStatement pst = con.prepareStatement("update lignesbus set idChauffeur=?, adresseDepart=?, capacite=?, heureDepart=? where idLigne=?");
            pst.setInt(1,t.getIdChauffeur());
            pst.setString(2,t.getDepartAdresse());
            pst.setInt(3,t.getCapacite());
            pst.setString(4, t.getDepartHeure());
            pst.setInt(5,t.getIdLigne());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    @Override
    public ObservableList<LigneBus> readAll() throws SQLException {
         ObservableList<LigneBus> arr=FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from lignesbus");
        while (rs.next()) {
            int idLigne = rs.getInt(1);
            int idChauffeur = rs.getInt(2);
            String adresseDepart = rs.getString(3);
            int capacite = rs.getInt(4);
            String heureDepart = rs.getString(5);
            LigneBus lb =new LigneBus(idLigne, idChauffeur, adresseDepart, capacite, heureDepart);
            arr.add(lb);
        }
    return arr;
    }
    
        public ObservableList<LigneBus> RechercheID(String id) throws SQLException {
         ObservableList<LigneBus> arr=FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from lignesbus where idLigne =" + id);
        while (rs.next()) {
            int idLigne = rs.getInt(1);
            int idChauffeur = rs.getInt(2);
            String adresseDepart = rs.getString(3);
            int capacite = rs.getInt(4);
            String heureDepart = rs.getString(5);
            LigneBus lb =new LigneBus(idLigne, idChauffeur, adresseDepart, capacite, heureDepart);
            arr.add(lb);
        }
    return arr;
    }
    
}
