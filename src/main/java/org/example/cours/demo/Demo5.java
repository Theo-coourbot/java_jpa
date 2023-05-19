package org.example.cours.demo;

import org.example.cours.entity.ManyToMany.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void start(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post post = new Post("les dates en JAVA !!!");
        Post post1 = new Post("les exam java cool");


    }
}
