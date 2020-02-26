/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class Reservation {
    
    private int id ;
        private int id_user ,nbr ;
    private int id_even ;
    private String type ;
    private Date dateres ; 

    public Reservation() {
    }

    public Reservation(int id_user, int id_even, String type, Date dateres) {
        this.id_user = id_user;
        this.id_even = id_even;
        this.type = type;
        this.dateres = dateres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_even() {
        return id_even;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateres() {
        return dateres;
    }

    public void setDateres(Date dateres) {
        this.dateres = dateres;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_user=" + id_user + ", id_even=" + id_even + ", type=" + type + ", dateres=" + dateres + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.id_user;
        hash = 31 * hash + this.id_even;
        hash = 31 * hash + Objects.hashCode(this.type);
        hash = 31 * hash + Objects.hashCode(this.dateres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_even != other.id_even) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.dateres, other.dateres)) {
            return false;
        }
        return true;
    }

    public Reservation(int id_user, int id_even, String type) {
        this.id_user = id_user;
        this.id_even = id_even;
        this.type = type;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public Reservation(int id_user, int nbr, int id_even, String type, Date dateres) {
        this.id_user = id_user;
        this.nbr = nbr;
        this.id_even = id_even;
        this.type = type;
        this.dateres = dateres;
    }

    public Reservation(int id, int id_user, int nbr, int id_even, String type, Date dateres) {
        this.id = id;
        this.id_user = id_user;
        this.nbr = nbr;
        this.id_even = id_even;
        this.type = type;
        this.dateres = dateres;
    }
    
    
    
    
}
