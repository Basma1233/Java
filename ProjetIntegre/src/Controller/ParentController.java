/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Parent;
import DAO.ParentInterface;
import DAO.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ParentController implements ParentInterface{
    private Connection con;
    private Statement ste;
    StudentsController s = new StudentsController();

    public ParentController() {
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
    public void AddParent(Parent p) {
        try {
            ste = con.createStatement();
            String requeteInsert = "INSERT INTO `parent` ( `name`, `login`, `password`,`studentid`) VALUES ( '" + p.getName()+ "', '" + p.getLogin()+ "', '" + p.getPassword()+ "', '" + p.getStudent().getId()+ "');";
            ste.executeUpdate(requeteInsert);
           
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void UpdateParent(int id, Parent p) {
 try {
     System.out.println(id);
            ste = con.createStatement();
            String requeteInsert = "UPDATE  `parent` SET `name`='"+p.getName()+"', `login`='"+p.getLogin()+"', `password`='"+p.getPassword()+"' where id='"+id+"'";
            ste.executeUpdate(requeteInsert);
           
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteParent(int id) {

        try {
            ste = con.createStatement();
            String requeteInsert = "DELETE FROM `parent` WHERE id= '"+id+"'";
            ste.executeUpdate(requeteInsert);
           
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Parent> ShowParents() {
            List<Parent> arr=new ArrayList<>();

        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from parent");
            while (rs.next()) {
                int id=rs.getInt(1);
                String nom=rs.getString("name");
                String login=rs.getString(3);
                String password=rs.getString(4);
                int stid = rs.getInt("studentid");

               
                Parent p=new Parent(nom, login, password,id);
                p.setStudent(s.ShowStudentByid(stid));
                p.setStudentname(p.getStudent().getName());
                arr.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return arr;
    }
  
    public Parent ShowParentByLogin(String id) {
        List<Parent> arr=new ArrayList<>();
  Parent p=new Parent();
        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from `parent` where login='"+id+"'");
            while (rs.next()) {
                int id1=rs.getInt(1);
                String nom=rs.getString("name");
                String login=rs.getString(3);
                String password=rs.getString(4);

               
              
                p.setId(id1);
                p.setLogin(login);
                p.setName(nom);
                p.setPassword(password);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    @Override
    public Parent ShowParentById(int id) {
        List<Parent> arr=new ArrayList<>();

        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from parent where id='"+id+"'");
            while (rs.next()) {
                int id1=rs.getInt(1);
                String nom=rs.getString("name");
                String login=rs.getString(3);
                String password=rs.getString(4);

               
                Parent p=new Parent(nom, login, password,id);
                arr.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return arr.get(0);
    }
    @Override
    public   List<Parent> rechercherParent(String var)
 {
        List<Parent> list = new ArrayList<>();
        
        try {   ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from parent where login like '"+var+"%' or name like '"+var+"%'");
            while (rs.next()) {
                int id1=rs.getInt(1);
                String nom=rs.getString("name");
                String login=rs.getString(3);
                String password=rs.getString(4);

               
                Parent p=new Parent(nom, login, password,id1);
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
