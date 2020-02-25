/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Student extends User{
private LocalDate dateOfBirth;
private String Class;
private String Adress;
private String mail;
private String sex;

    public Student() {
    }

    public Student(LocalDate dateOfBirth, String Class, String Adress, String mail, String sex, String name, String login, String password,int id) {
        super(name, login, password,id);
        this.dateOfBirth = dateOfBirth;
        this.Class = Class;
        this.Adress = Adress;
        this.mail = mail;
        this.sex = sex;
       
    }
     public Student(String Class, String Adress, String mail, String sex, String name, String login, String password,int id) {
        super(name, login, password,id);
        this.Class = Class;
        this.Adress = Adress;
        this.mail = mail;
        this.sex = sex;
       
    }

   

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getClasse() {
        return Class;
    }

    public String getAdress() {
        return Adress;
    }

    public String getMail() {
        return mail;
    }

    public String getSex() {
        return sex;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }








}
