/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenprepjpa2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Orvur
 */
public class Facade {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAPrep2PU"); //Wrong name yolo
    EntityManager manager = factory.createEntityManager();

    public boolean add(Object o) {
        manager.getTransaction().begin();
        manager.persist(o);
        manager.getTransaction().commit();
        return true;
    }

    public boolean edit(int l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        person.setFirstName("Tim");
        manager.getTransaction().commit();
        return true;
    }

    public Person find(int l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        manager.getTransaction().commit();
        return person;
    }

    public boolean delete(int l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        manager.remove(person);
        manager.getTransaction().commit();
        return true;
    }
    
    //--------------------------------------------

    public boolean editStudent(int l) {
        manager.getTransaction().begin();
        Student student = manager.find(Student.class, l);
        student.setMatNr(10);
        manager.getTransaction().commit();
        return true;
    }

    public Student findStudent(Long l) {
        manager.getTransaction().begin();
        Student student = manager.find(Student.class, l);
        manager.getTransaction().commit();
        return student;
    }

    public boolean deleteStudent(int l) {
        manager.getTransaction().begin();
        Student student = manager.find(Student.class, l);
        manager.remove(student);
        manager.getTransaction().commit();
        return true;
    }
    
        //--------------------------------------------

    public boolean editb(Long l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        person.setFirstName("Tim");
        manager.getTransaction().commit();
        return true;
    }

    public Person find(Long l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        manager.getTransaction().commit();
        return person;
    }

    public boolean delete(Long l) {
        manager.getTransaction().begin();
        Person person = manager.find(Person.class, l);
        manager.remove(person);
        manager.getTransaction().commit();
        return true;
    }
    
        //--------------------------------------------
    
    
    
}
