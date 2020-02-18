/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class ServicePersonne {

    Connexion C = (Connexion) Connexion.getInstance().getCnx();

    public void AjouterPersonne(Personne P) {
        
        Statement st = C.CreateStatement();
      String reg = "inset into personne values('p.getId,p.getNom,p.getPrenom,p.getAdress')";

    }
public void ModifierPersonne (Personne P){
    
    Pt.setString(1.nom);
    Ptsetint(2.getId)
} 

public void SupprimerPersonne (Personne P){
    
}
public void AfficherPersonne (){
    PreparedStatement pt = c.prepareStatement;
    Redultat
}

}

