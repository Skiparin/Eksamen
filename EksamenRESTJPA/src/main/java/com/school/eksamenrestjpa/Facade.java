/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenrestjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Orvur
 */
public class Facade {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.school_EksamenRESTJPA_war_1.0-SNAPSHOTPU");
    EntityManager manager = factory.createEntityManager();

    public List<Country> getCountries() {
        TypedQuery<Country> cQuery = manager.createQuery("SELECT c.code, c.name, c.continent, c.capital FROM Country c", Country.class);
        List<Country> countries = cQuery.getResultList();
        return countries;
    }

    public List<Country> getCountriesByPop(int num) {
        TypedQuery<Country> cQuery = manager.createQuery("SELECT c FROM Country c WHERE c.population > :pop", Country.class);
        cQuery.setParameter("pop", num);
        List<Country> countries = cQuery.getResultList();
        return countries;
    }

    
    
    public List<City> getCityByCode(String code) {
        TypedQuery<City> cQuery = manager.createQuery("SELECT c.name, c.population FROM City c WHERE c.countryCode.code = :code", City.class);
        cQuery.setParameter("code", code);
        List<City> city = cQuery.getResultList();
        return city;
    }
    
    public void createCity (){
        Country country = manager.find(Country.class, "DNK");
        City city = new City();
        city.setId(1000000000);
        city.setName("Tim er en bitch");
        city.setCountryCode(country);
        city.setDistrict(country.getRegion());
        city.setPopulation(100000);
        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
    }

    public static void main(String[] args) {

        System.out.println(new Facade().getCountries());
        System.out.println(new Facade().getCountriesByPop(1000000000).get(0).getName());
        System.out.println(new Facade().getCityByCode("DNK"));
        new Facade().createCity();
    }
}
