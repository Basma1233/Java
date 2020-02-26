/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Malek Guemri
 */
public class Comment {
    private int ID;
    private int idu;

   

    @Override
    public String toString() {
        return "Comment{" + "ID=" + ID + ", idu=" + idu + ", ide=" + ide + ", comment=" + comment + ", dateComment=" + dateComment + '}';
    }

    public Comment(int ID, int idu, int ide, String comment) {
        this.ID = ID;
        this.idu = idu;
        this.ide = ide;
        this.comment = comment;
    }

    public Comment(int idu, int ide, String comment) {
        this.idu = idu;
        this.ide = ide;
        this.comment = comment;
    }

    
    public Comment() {
    }

  

   

    public Comment(int idu, int ide, String comment, Date dateComment) {
        this.idu = idu;
        this.ide = ide;
        this.comment = comment;
        this.dateComment = dateComment;
    }
    
    private int ide;
    private String comment;
    private Date dateComment;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }
}
