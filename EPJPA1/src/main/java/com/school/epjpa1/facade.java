/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.epjpa1;

import static com.school.epjpa1.Project_.user;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Orvur
 */
public class facade {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA1PU");
    EntityManager manager = factory.createEntityManager();

    public facade() {

    }

    public void createUser(ProjectUser user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    public ProjectUser findUser(long id) {
        manager.getTransaction().begin();
        ProjectUser user = manager.find(ProjectUser.class, id);
        manager.getTransaction().commit();
        return user;
    }

    public List<ProjectUser> getAllUsers() {
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT p FROM ProjectUser p");
        List<ProjectUser> users = q.getResultList();
        manager.getTransaction().commit();
        return users;
    }

}
