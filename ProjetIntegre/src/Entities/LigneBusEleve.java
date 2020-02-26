/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hamza
 */
public class LigneBusEleve {
    
    int idLigneBusEleve;
    int idLigne;
    int idEleve;   
    String prenom;
    String nom;
    
    

    public LigneBusEleve(int idLigne, int idEleve, String prenom, String nom) {
        this.idLigne = idLigne;
        this.idEleve = idEleve;
        this.prenom = prenom;
        this.nom = nom;
    }

    public LigneBusEleve(int idLigne, int idEleve) {
        this.idLigne = idLigne;
        this.idEleve = idEleve;
    }

    public LigneBusEleve(int idLigne1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLigne() {
        return idLigne;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public int getIdLigneBusEleve() {
        return idLigneBusEleve;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setIdLigneBusEleve(int idLigneBusEleve) {
        this.idLigneBusEleve = idLigneBusEleve;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
