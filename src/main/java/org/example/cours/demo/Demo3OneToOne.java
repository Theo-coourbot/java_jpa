package org.example.cours.demo;

import org.example.cours.entity.onToOne.Adresse;
import org.example.cours.entity.onToOne.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class Demo3OneToOne {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Adresse adresse = new Adresse(46,"rue des coucou","59650","Lille",7865);
        House house = new  House();
        house.setTaille(432);
        house.setAdresse(adresse);


        em.persist(house);

        em.getTransaction().commit();
        House housesearch = em.find(House.class, house.getId());
        System.out.println(housesearch);

        em.close();
        emf.close();

    }
}
