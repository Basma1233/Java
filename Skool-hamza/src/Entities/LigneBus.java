package Entities;

import java.sql.Date;

public class LigneBus {
    private int idLigne;    
    private int idChauffeur;
    private String departAdresse;
    int capacite;
    private String departHeure; 

    public LigneBus(int idChauffeur, String departAdresse, int capacite, String departHeure) {
        this.idChauffeur = idChauffeur;
        this.departAdresse = departAdresse;
        this.capacite = capacite;
        this.departHeure = departHeure;
    }
    

    public LigneBus(int idLigne, int idChauffeur, String departAdresse, int capacite, String departHeure) {
        this.idLigne = idLigne;
        this.idChauffeur = idChauffeur;
        this.departAdresse = departAdresse;
        this.capacite = capacite;
        this.departHeure = departHeure;
    }

    

    public int getIdLigne() {
        return idLigne;
    }

    public int getIdChauffeur() {
        return idChauffeur;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getDepartAdresse() {
        return departAdresse;
    }

    public String getDepartHeure() {
        return departHeure;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public void setIdChauffeur(int idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDepartAdresse(String departAdresse) {
        this.departAdresse = departAdresse;
    }

    public void setDepartHeure(String departHeure) {
        this.departHeure = departHeure;
    }
    
    
}