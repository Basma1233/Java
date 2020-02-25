/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Student;
import DAO.StudentInterface;
import DAO.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class StudentsController implements StudentInterface {

    private Connection con;
    private Statement ste;

    public StudentsController() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ConsultExamScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consulterAbscence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consulterScheduel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ManagePersonalInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CreateStudent(Student s) {
        System.out.println(  s.getDateOfBirth());
        try {
            ste = con.createStatement();
            String requeteInsert = "INSERT INTO `student` ( `name`, `login`, `password`,`DateOfBirth`,`class`,`adress`,`mail`,`sex`) VALUES ( '" + s.getName() + "', '" + s.getLogin() + "', '" + s.getPassword() + "','" + s.getDateOfBirth()+ "', '" + s.getClasse() + "', '" + s.getAdress() + "', '" + s.getMail() + "', '" + s.getSex() + "');";
            ste.executeUpdate(requeteInsert);

        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateStudent(int id, Student s) {
        try {
            System.out.println(id);
            ste = con.createStatement();
            String requeteInsert = "UPDATE  `student` SET `name`='" + s.getName() + "', `login`='" + s.getLogin() + "', `password`='" + s.getPassword() + "',`DateOfBirth`='" + s.getDateOfBirth() + "',`class`='" + s.getClasse() + "',`adress`='" + s.getAdress() + "',`mail`='" + s.getMail() + "',`sex`='" + s.getSex() + "' where id='" + id + "'";
            ste.executeUpdate(requeteInsert);

        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Student SowStudentByLogin(String id) {
        List<Student> arr=new ArrayList<>();
  Student p=new Student();
        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from `student` where login='"+id+"'");
            while (rs.next()) {
                int id1=rs.getInt(1);
                 String nom = rs.getString("name");
                String login = rs.getString(7);
                String password = rs.getString(8);
                LocalDate DateOfBrith = rs.getDate(2).toLocalDate();
                String Classe = rs.getString(3);
                String Adress = rs.getString(9);
                String Mail = rs.getString(4);
                String Sex = rs.getString(5);

               
              p = new Student(DateOfBrith, Classe, Adress, Mail, Sex, nom, login, password,id1);

                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public void DeleteStudent(int id) {
        try {
            ste = con.createStatement();
            String requeteInsert = "DELETE FROM `student` WHERE id= '" + id + "'";
            ste.executeUpdate(requeteInsert);

        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> ShowStudents() {
        List<Student> arr = new ArrayList<>();

        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select * from student");
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString("name");
                String login = rs.getString(7);
                String password = rs.getString(8);
                LocalDate DateOfBrith = rs.getDate(2).toLocalDate();
                String Classe = rs.getString(3);
                String Adress = rs.getString(9);
                String Mail = rs.getString(4);
                String Sex = rs.getString(5);
                   Student s = new Student(DateOfBrith, Classe, Adress, Mail, Sex, nom, login, password,id);
                arr.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public Student ShowStudentByid(int id) {
        List<Student> arr = new ArrayList<>();
        Student ss =new Student();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select * from Student where id='" + id + "'");
            while (rs.next()) {
                 int idl = rs.getInt(1);
                String nom = rs.getString("name");
                String login = rs.getString(7);
                String password = rs.getString(8);
                LocalDate DateOfBrith = rs.getDate(2).toLocalDate();
                String Classe = rs.getString(3);
                String Adress = rs.getString(9);
                String Mail = rs.getString(4);
                String Sex = rs.getString(5);
                   Student s = new Student(DateOfBrith, Classe, Adress, Mail, Sex, nom, login, password,idl);
                   arr.add(s);
                   ss=s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ss;

    }

    public List<Student> rechercherStudent(String var) {
 List<Student> list = new ArrayList<>();
        
        try {   ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from student where login like '"+var+"%' or name like '"+var+"%'");
            while (rs.next()) {
                 int idl = rs.getInt(1);
                String nom = rs.getString("name");
                String login = rs.getString(7);
                String password = rs.getString(8);
                LocalDate DateOfBrith = rs.getDate(2).toLocalDate();
                String Classe = rs.getString(3);
                String Adress = rs.getString(9);
                String Mail = rs.getString(4);
                String Sex = rs.getString(5);
                   Student s = new Student(DateOfBrith, Classe, Adress, Mail, Sex, nom, login, password,idl);
                   list.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
