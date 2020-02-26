/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author hamza
 */
public class Publication {
    private int idPublication;
    private int idAuteur;
    private String titrePublication;
    private String contenu;
    private String datePublication;

    public Publication(int idPublication, String titrePublication, String contenu) {
        this.idPublication = idPublication;
        this.titrePublication = titrePublication;
        this.contenu = contenu;
    }

    public Publication(String titrePublication, String contenu, String datePublication) {
        this.titrePublication = titrePublication;
        this.contenu = contenu;
        this.datePublication = datePublication;
    }

    public Publication(int idPublication, int idAuteur, String titrePublication, String contenu, String datePublication) {
        this.idPublication = idPublication;
        this.idAuteur = idAuteur;
        this.titrePublication = titrePublication;
        this.contenu = contenu;
        this.datePublication = datePublication;
    }

    public Publication(int idAuteur, String titrePublication, String contenu, String datePublication) {
        this.idAuteur = idAuteur;
        this.titrePublication = titrePublication;
        this.contenu = contenu;
        this.datePublication = datePublication;
    }

    
    public int getIdPublication() {
        return idPublication;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public String getTitrePublication() {
        return titrePublication;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public void setTitrePublication(String titrePublication) {
        this.titrePublication = titrePublication;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
    
    
}
