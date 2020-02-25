/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Parent;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ParentInterface {
    void ConsultExamScore();
    void consulterAbscence();
    void consulterScheduel();
    void AddParent(Parent p);
    void UpdateParent(int id ,Parent p);
    void DeleteParent(int id);
    List<Parent> ShowParents();
        List<Parent> rechercherParent(String var);

    Parent ShowParentById(int id);
    
    
}
