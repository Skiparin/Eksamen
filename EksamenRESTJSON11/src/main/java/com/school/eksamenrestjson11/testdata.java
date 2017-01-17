/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenrestjson11;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Orvur
 */
public class testdata {

    final static java.util.Random rand = new java.util.Random();
    static String[] fName = {"bobo", "tim", "olivereeer", "haifag", "reyyyyggna"};
    static String[] lName = {"BisRogueBotSkiparin", "BisPriestSkiparinYolo", "BisEmil"};
    static String[] city = {"Lyngby", "Amager", "Højby", "yoloking", "wtfman", "waat"};
    static String[] street = {"Á Tungu 2", "Frederiksborgvej 159", "Amagerbrogade 268", "Yolo"};

    public static String getData(int i) {
        ArrayList<Person> names = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Person person = new Person(fName[rand.nextInt(fName.length)], lName[rand.nextInt(lName.length)], city[rand.nextInt(city.length)], street[rand.nextInt(street.length)]);
            names.add(person);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(names); //The JSON string is ready
        System.out.println(jsonStr);
        return jsonStr;
    }

    public static String getData(int i, String ss) {
        List<String> s = Arrays.asList(ss.split(","));
        ArrayList<Person> names = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Person person = new Person();
            names.add(person);
        }
        if (s.contains("fName")) {
            for (Person person : names) {
                person.setfName(fName[rand.nextInt(fName.length)]);
            }
        }

        if (s.contains("lName")) {
            for (Person person : names) {
                person.setlName(lName[rand.nextInt(lName.length)]);
            }
        }

        if (s.contains("city")) {
            for (Person person : names) {
                person.setCity(city[rand.nextInt(city.length)]);
            }
        }

        if (s.contains("street")) {
            for (Person person : names) {
                person.setStreet(street[rand.nextInt(street.length)]);
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(names); //The JSON string is ready
        System.out.println(jsonStr);
        return jsonStr;
    }
}
