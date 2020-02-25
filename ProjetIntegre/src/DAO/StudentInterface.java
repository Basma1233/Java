/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Student;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface StudentInterface {
    void ConsultExamScore();
    void consulterAbscence();
    void consulterScheduel();
    void ManagePersonalInformation();
    
    void CreateStudent(Student s);
    void UpdateStudent(int id, Student s);
    void DeleteStudent(int id);
    List<Student> ShowStudents();
    Student ShowStudentByid(int id);
}
