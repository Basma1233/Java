/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ConnexionBd;
import Entities.Event;
import Entities.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
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
 * @author USER
 */
public class ReservationService {
    
    Connection c = ConnexionBd.getConnexion();
    
    public void ajouterReservation(Reservation s)
    {
          String query ="INSERT INTO `reservation`(`type`,`id_user`,`date`,`id_evenement`,`nbr`) VALUES (?,?,?,?,?)";
 
         PreparedStatement st;
        
        try {
            
            st = c.prepareStatement(query);
                st.setString(1,s.getType());
                st.setInt(2,s.getId_user());
                st.setDate(3, s.getDateres());
                st.setInt(4,s.getId_even());
                st.setInt(5,s.getNbr());
                
                st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void modifierReservation(Reservation s){
       
         try {
             PreparedStatement pst=c.prepareStatement("UPDATE `reservation` SET `nbr`=? WHERE `id` = ?");
             pst.setInt(1,s.getNbr());
             pst.setInt(2,s.getId());
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
         
    }
     }
     
  public void afficherReservation() throws SQLException{
       PreparedStatement pt;
        try {
            pt = c.prepareStatement("select * from reservation");

            ResultSet rs = pt.executeQuery();

        while (rs.next()){
            System.out.println("ID : "+rs.getInt(1)+" , Titre :"+rs.getDate(2)+" , Lieu :"+rs.getString(3)+
                    " , Nombre de places disponibles :"+rs.getInt(4)+", Nombre de participants :"+rs.getInt(5)
                    +" , Date de début :"+rs.getInt(6));
        }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
  
   public void supprimerReservation(Reservation s){

        try {
        PreparedStatement pt = c.prepareStatement("delete from reservation where id =?");
        pt.setInt(1,s.getId());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<Reservation> getAllReservation() throws SQLDataException {

        
        List<Reservation> list =new ArrayList<Reservation>();
        int count =0;
        
        String requete="select * from reservation";
         try{
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reservation e = new Reservation();
                 e.setId(rs.getInt(1));
                e.setId_even(rs.getInt(5));
                e.setDateres((Date)rs.getDate(2));
                e.setId_user(rs.getInt(4));
                e.setNbr(rs.getInt(6));
               
                e.setType(rs.getString(3));
                  
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}

  public ObservableList<Reservation> getReservationByUser(int id ) throws SQLDataException {

        
        List<Reservation> list =new ArrayList<Reservation>();
        int count =0;
        
        String requete="select * from reservation where id_user="+id;
         try{
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reservation e = new Reservation();
                 e.setId(rs.getInt(1));
                e.setId_even(rs.getInt(5));
                e.setDateres((Date)rs.getDate(2));
                e.setNbr(rs.getInt(6));
               
                e.setType(rs.getString(3));
                  
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
        
  
  public Reservation findReservatinById(int id) {
        
       try {
             Reservation evt=new Reservation();
             int cc=0;
             String req="select * from reservation where id = "+id ;
             Statement st=c.createStatement();
             ResultSet rs=st.executeQuery(req);
             while(rs.next())
             {
                 evt.setId(rs.getInt(1));
                 evt.setDateres(rs.getDate(2));
                 evt.setType(rs.getString(3));
                 evt.setNbr(rs.getInt(6));
                 evt.setId_user(rs.getInt(4));
                 evt.setId_even(rs.getInt(5));

                 cc++;
                         }
             if(cc==0)
             {
                 return null;
             }else {
                 return evt;
             }
         } catch (SQLException ex) {
             Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
             return null;

         }
       }
        
     
    
}
