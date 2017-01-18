/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import Entity.Student;
import Entity.Studypoint;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Orvur
 */
public class tester {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAEX3PU");
    EntityManager manager = factory.createEntityManager();

    public static void main(String[] args) {


        
    }

    public List<Student> findAllStudents() {
        Query query = manager.createNamedQuery("Student.findAll");
        return query.getResultList();
    }
    
    public List<Student> findAllStudentsWithFirstName() {
        Query query = manager.createNamedQuery("Student.findByFirstname");
        query.setParameter("firstname", "jan");
        return query.getResultList();
    }
    
    public List<Student> findAllStudentsWithLastName() {
        Query query = manager.createNamedQuery("Student.findByLastname");
        query.setParameter("lastname", "Olsen");
        return query.getResultList();
    }
    
    public int SumOfStudyPoints(long l) {
        Query query = manager.createNamedQuery("Student.findById");
        query.setParameter("id", l);
        Student student = (Student) query.getResultList().get(0);
        List<Studypoint> list = (List<Studypoint>) student.getStudypointCollection();
        int sum = 0;
        for (Studypoint studypoint : list) {
            sum += studypoint.getScore();
        }
        return sum;
    }
    
    public int SumOfAllStudyPoints(){
        Query query = manager.createNamedQuery("Student.findAll");
        List<Student> students = (List<Student>) (Student) query.getResultList();
        List<Studypoint> SP = new ArrayList<Studypoint>();
        for (Student s : students) {
            SP.addAll(s.getStudypointCollection());
        }
        int sum = 0;
        for (Studypoint studypoint : SP) {
            sum += studypoint.getScore();
        }
        return sum;
    }
    
    
    
    
}
