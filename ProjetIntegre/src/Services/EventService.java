/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ConnexionBd;
import Entities.Event;
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
 * @author Malek Guemri
 */
public class EventService {
    Connection c = ConnexionBd.getConnexion();
     
     public void ajouterEvent(Event a)
    {
        try {
            Statement st=c.createStatement();
            String req="insert into event values("+a.getID()+",'"+a.getTitre()+"','"+a.getLieu()+"',"+a.getNbp()+
                    ","+a.getNbParticipants()+",'"+a.getDateDebut()+"','"+a.getDateFin()+"')";
            
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public Event findEvenementById(int id) {
        
       try {
             Event evt=new Event();
             int cc=0;
             String req="select * from event where id="+id;
             Statement st=c.createStatement();
             ResultSet rs=st.executeQuery(req);
             while(rs.next())
             {
                 evt.setID(rs.getInt(1));
                 evt.setLieu(rs.getString(3));
                 evt.setTitre(rs.getString(2));
                 evt.setNbp(rs.getInt(4));
                 evt.setNbParticipants(rs.getInt(5));
                 evt.setDateDebut(rs.getDate(6));
                 evt.setDateFin(rs.getDate(7));

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
     
     public void modifierEvent(Event e,String titre,String lieu,int nbp,int nbparticipant,Date datedebut,Date datefin,int id){
       
        try {
            
     
           String query = "UPDATE `event` SET `titre`=?,`lieu`=?,`nbp`=?,`nbparticipant`=?,`datedebut`=?,`datefin`=? WHERE `id`="+id;
	   PreparedStatement st  = c.prepareStatement(query);
                
                
                st.setString(1,titre);
                st.setString(2,lieu);
                st.setInt(3,nbp);
                st.setInt(4,nbparticipant);
                st.setDate(5,datedebut);
                st.setDate(6, datefin);
               //st.setInt(7,e.getID());
               st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void afficherEvent(){
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("select * from Event");

        ResultSet rs = pt.executeQuery();

        while (rs.next()){
            System.out.println("ID : "+rs.getInt(1)+" , Titre :"+rs.getString(2)+" , Lieu :"+rs.getString(3)+
                    " , Nombre de places disponibles :"+rs.getInt(4)+", Nombre de participants :"+rs.getInt(5)
                    +" , Date de début :"+rs.getDate(6)+",Date de fin :"+rs.getDate(7));
        }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean supprimerEvent(int id){

        try {
         Statement st=c.createStatement();
         String req="DELETE FROM `event` WHERE `id`="+id;
         st.execute(req);
         return true ;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public void rechercherEvent(int id){
        
        PreparedStatement ps ;
         try {
             ps= c.prepareStatement("select * from event where id =?");
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                System.out.println("ID : "+rs.getInt(1)+" , Titre :"+rs.getString(2)+" , Lieu :"+rs.getString(3)+
                    " , Nombre de places disponibles :"+rs.getInt(4)+", Nombre de participants :"+rs.getInt(5)
                    +" , Date de début :"+rs.getDate(6)+",Date de fin :"+rs.getDate(7));
                }
         } catch (SQLException ex) {
             Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public void triEventParID_ASC(){
        PreparedStatement ps ;
         try {
             ps= c.prepareStatement("select * from event order by id ASC ");
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                System.out.println("ID : "+rs.getInt(1)+" , Titre :"+rs.getString(2)+" , Lieu :"+rs.getString(3)+
                    " , Nombre de places disponibles :"+rs.getInt(4)+", Nombre de participants :"+rs.getInt(5)
                    +" , Date de début :"+rs.getDate(6)+",Date de fin :"+rs.getDate(7));
                }
         } catch (SQLException ex) {
             Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void triEventParID_DESC(){
        PreparedStatement ps ;
         try {
             ps= c.prepareStatement("select * from Event order by id DESC ");
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                System.out.println("ID : "+rs.getInt(1)+" , Titre :"+rs.getString(2)+" , Lieu :"+rs.getString(3)+
                    " , Nombre de places disponibles :"+rs.getInt(4)+", Nombre de participants :"+rs.getInt(5)
                    +" , Date de début :"+rs.getDate(6)+",Date de fin :"+rs.getDate(7));
                }
         } catch (SQLException ex) {
             Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public ObservableList<Event> getAllEvenement() throws SQLDataException {

        
        List<Event> list =new ArrayList<Event>();
        int count =0;
        
        String requete="select * from event";
         try{
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Event e = new Event();
                 e.setID(rs.getInt(1));
                e.setLieu(rs.getString(3));
                e.setTitre(rs.getString(2));
                e.setNbp(rs.getInt(4));
                e.setNbParticipants(rs.getInt(5));
                e.setDateDebut(rs.getDate(6));
                e.setDateFin(rs.getDate(7));
                  
                
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
    
    
        public ObservableList<Event> getEventBytitre(String titre) throws SQLDataException {

        
        List<Event> list =new ArrayList<Event>();
        int count =0;
        
        String requete="select * from event where titre='"+titre+"' " ;
         try{
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Event e = new Event();
                 e.setID(rs.getInt(1));
                e.setLieu(rs.getString(3));
                e.setTitre(rs.getString(2));
                e.setNbp(rs.getInt(4));
                e.setNbParticipants(rs.getInt(5));
                e.setDateDebut(rs.getDate(6));
                e.setDateFin(rs.getDate(7));
                  
                
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
    
    
    
    
    
    
    
}