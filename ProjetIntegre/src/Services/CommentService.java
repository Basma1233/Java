/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ConnexionBd;
import Entities.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malek Guemri
 */
public class CommentService {
    
    Connection c = ConnexionBd.getConnexion();
    
    public void ajouterComment(Comment s)
    {
          String query ="INSERT INTO `comment`( `idu`, `ide`,`commentaire`) VALUES (?,?,?)";
 
         PreparedStatement st;
        
        try {
            st = c.prepareStatement(query);
                st.setInt(1,s.getIdu());
                st.setInt(2,s.getIde());
                st.setString(3,s.getComment());
                
                st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    


        
        
     }
     
     public void modifierComment(Comment s){
       
         try {
             PreparedStatement pst=c.prepareStatement("UPDATE `comment` SET `commentaire`=? WHERE `id` = ?");
             pst.setString(1,s.getComment());
             pst.setInt(2,s.getID());
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
     public void afficherComment(){
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("select * from Comment");

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            System.out.println("User ID : "+rs.getInt(1)+" , Event ID :"+rs.getInt(2)+" , Comment :"
                    +rs.getString(3)+" ,Comment Date :"+rs.getDate(4)+" , Comment ID :"+rs.getInt(5));
        }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerComment(Comment s){

        try {
        PreparedStatement pt = c.prepareStatement("delete from comment where id =?");
        pt.setInt(1,s.getID());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Comment> rechercherCommentParUserID(int id){
         List<Comment> list = new ArrayList<Comment>();
        int count =0;
        
        String requete="select * from comment where idu="+id;
        
         try{
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                Comment c = new Comment();
                c.setIde(rs.getInt(1));
                c.setIdu(rs.getInt(2));
                c.setComment(rs.getString(3));
                c.setID((rs.getInt(5)));
                 
                
                list.add(c);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.ALL.SEVERE, null, ex);
            return null;
        }
     }
  
    
    public void triCommentParUserID_ASC(){
        PreparedStatement ps ;
         try {
             ps= c.prepareStatement("select * from comment order by idu ASC ");
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                System.out.println("User ID : "+rs.getInt(1)+" , Event ID :"+rs.getInt(2)+" , Comment :"
                    +rs.getString(3)+" ,Comment Date :"+rs.getDate(4)+" , Comment ID :"+rs.getInt(5));
                }
         } catch (SQLException ex) {
             Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void triSponsorsParUserID_DESC(){
        PreparedStatement ps ;
         try {
             ps= c.prepareStatement("select * from comment order by idu DESC ");
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                System.out.println("User ID : "+rs.getInt(1)+" , Event ID :"+rs.getInt(2)+" , Comment :"
                    +rs.getString(3)+" ,Comment Date :"+rs.getDate(4)+" , Comment ID :"+rs.getInt(5));
                }
         } catch (SQLException ex) {
             Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
