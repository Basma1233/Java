/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skool;

import Entities.Comment;
import Entities.Event;
import Entities.Reservation;
import Services.CommentService;
import Services.EventService;
import Services.ReservationService;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malek Guemri
 */
public class Skool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Date d1 = new Date(2015-05-03);
        Date d2 = new Date(2015-03-05);
        Event e = new Event("faydra", "faydra", 25, 25,d1, d2);
        Event e1 = new Event("ouss", "lieu1", 20, 20, d1, d2);
        EventService es = new EventService();
        ReservationService rs = new ReservationService();
        
        Reservation r = new Reservation(3, 50,32, "aloo", d2);
                Reservation r1 = new Reservation(2, 3, 155, 32, "aloo", d2);

        
        //es.ajouterEvent(e1);
        //es.ajouterEvent(e1);
        //es.afficherEvent();
        //es.ajouterEvent(e);
       // es.supprimerEvent(31);
        //es.modifierEvent(e1);
    // es.modifierEvent(e1, "khalil", "lieu", 0, 0, d2, d2,32);
        Comment c = new Comment(3, 32, "asslema");
        Comment c1 = new Comment(4, 31, "hihihihi");
        Comment c2=new Comment(13, 4 , 31, "asslemaaaaaaaaa");
       // es.modifierEvent(e);
        //es.modifierEvent(e, Titre, Lieu, 0, 0, d2, d2);
        //es.modifierEvent(e, Titre, Lieu, 0, 0, d2, d2);
        CommentService cs = new CommentService();
        //cs.ajouterComment(c);
        //cs.modifierComment(c2);
        //cs.ajouterComment(c1);
        //cs.supprimerComment(c2);
        //cs.afficherComment();
       /*  List<Comment> L=new ArrayList<Comment>();
            L = cs.rechercherCommentParUserID(3);
          for (Comment cc: L)
      {
          System.out.println(cc);
      }
        
        */
       
       
      // rs.ajouterReservation(r);
     // rs.afficherReservation();
   /*  List<Reservation> lr = rs.getReservationByUser(3);
     for(Reservation rr : lr){
         System.out.println("skool.Skool.main()"+rr);
     
     }*/
   
   
   //rs.findReservatinById(11);
   
  List<Event> l = es.getEventBytitre("aaa");
   for(Event m : l)
            System.out.println(m);
   
    }
    
}
