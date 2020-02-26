/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Malek Guemri
 */
public class Event {
    private int ID;
    private String titre;
    private String lieu;
    private int nbp;
    private int nbParticipants;
    private Date dateDebut;
    private Date dateFin;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Event(String titre, String lieu, int nbp, int nbParticipants, Date dateDebut, Date dateFin) {
        this.titre = titre;
        this.lieu = lieu;
        this.nbp = nbp;
        this.nbParticipants = nbParticipants;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbp() {
        return nbp;
    }

    public void setNbp(int nbp) {
        this.nbp = nbp;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Event(String titre, String lieu, int nbp, Date dateDebut, Date dateFin) {
        this.titre = titre;
        this.lieu = lieu;
        this.nbp = nbp;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Event() {
    }

    public Event(int ID, String titre, String lieu, int nbp, int nbParticipants, Date dateDebut, Date dateFin) {
        this.ID = ID;
        this.titre = titre;
        this.lieu = lieu;
        this.nbp = nbp;
        this.nbParticipants = nbParticipants;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    
}
