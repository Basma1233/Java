package Entities;

public class LigneBus {
    private int idLigne;    
    private String idChauffeur;
    private String departAdresse;
    int capacite;
    private String departHeure; 

    public LigneBus(int idLigne, String idChauffeur, String departAdresse, int capacite, String departHeure) {
        this.idLigne = idLigne;
        this.idChauffeur = idChauffeur;
        this.departAdresse = departAdresse;
        this.capacite = capacite;
        this.departHeure = departHeure;
    }

    public LigneBus(String idChauffeur, String departAdresse, int capacite, String departHeure) {
        this.idChauffeur = idChauffeur;
        this.departAdresse = departAdresse;
        this.capacite = capacite;
        this.departHeure = departHeure;
    }

    public int getIdLigne() {
        return idLigne;
    }

    public String getIdChauffeur() {
        return idChauffeur;
    }

    public String getDepartAdresse() {
        return departAdresse;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getDepartHeure() {
        return departHeure;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public void setIdChauffeur(String idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public void setDepartAdresse(String departAdresse) {
        this.departAdresse = departAdresse;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDepartHeure(String departHeure) {
        this.departHeure = departHeure;
    }

    
}