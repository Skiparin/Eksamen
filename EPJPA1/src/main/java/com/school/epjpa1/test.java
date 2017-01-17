/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.epjpa1;

import java.util.List;

/**
 *
 * @author Orvur
 */
public class test {

    public static void main(String[] args) {
        facade fac = new facade();
        ProjectUser user = new ProjectUser();
        user.setEmail("tim@tim.com");
        user.setUserName("Haifag");
        ProjectUser userr = new ProjectUser();
        userr.setEmail("timmmmmmmm@tim.com");
        userr.setUserName("Haiiiiiifag");
        fac.createUser(user);
        fac.createUser(userr);
        ProjectUser userrrr = fac.findUser(1);
        System.out.println(userrrr.getUserName());
        List<ProjectUser> userrr = fac.getAllUsers();
        System.out.println(userrr.get(1).getUserName());

    }
}
