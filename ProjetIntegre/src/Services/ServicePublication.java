/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Publication;
import IServices.IServiceEntities;
import DAO.DataBase;
import java.sql.Connection;
import java.sql.Date;
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
public class ServicePublication implements IServiceEntities<Publication> {
    
     private Connection con;
     private Statement ste;

    public ServicePublication() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Publication t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`publications` ( `idAuteur`, `datePublication`, `titre`, `contenu`) VALUES ( ?, ?, ?, ?);");
        pre.setInt(1, t.getIdAuteur());
        pre.setString(2, t.getDatePublication());
        pre.setString(3, t.getTitrePublication());
        pre.setString(4, t.getContenu());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Publication t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("delete from publications where idPublication =?");
        pre.setInt(1,t.getIdPublication());
        pre.execute();
        
        return false;
    }

    @Override
    public boolean update(Publication t) throws SQLException {
        try {
            PreparedStatement pst = con.prepareStatement("update publication set titre=?, contenu=?, where idPublication=?");
            pst.setString(1,t.getTitrePublication());
            pst.setString(2,t.getContenu());
            pst.setInt(3,t.getIdPublication());

            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    @Override
    public ObservableList<Publication> readAll() throws SQLException {
        ObservableList<Publication> arr= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from publications");
        while (rs.next()) {
            int idPublication = rs.getInt(1);
            int idAuteur = rs.getInt(2);
            String datePublication = rs.getString(3);
            String titrePublication = rs.getString(4);
            String contenuPublication = rs.getString(5);
            
            Publication p =new Publication(idPublication, idAuteur, titrePublication, contenuPublication, datePublication);
            arr.add(p);
        }
    return arr;
    }
   
}
