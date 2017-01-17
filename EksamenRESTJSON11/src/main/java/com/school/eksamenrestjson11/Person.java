/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenrestjson11;

/**
 *
 * @author Orvur
 */
public class Person {
    
    private String fName;
    private String lName;
    private String street;
    private String city;

    public Person(String fName, String lName, String street, String city) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
    }

    Person() {
    }

    
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
