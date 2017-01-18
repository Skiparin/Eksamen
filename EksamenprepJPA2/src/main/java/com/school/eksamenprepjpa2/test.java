/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenprepjpa2;

import javax.persistence.Persistence;

/**
 *
 * @author Orvur
 */
public class test {
    
    public static void main(String[] args) {
        Persistence.generateSchema("com.school_EksamenprepJPA2_war_1.0-SNAPSHOTPU", null);
    }
}
