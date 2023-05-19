package org.example.cours.demo;


import org.example.cours.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void main() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person("le rouge", "bubule");
        System.out.println("Id de la personne avant persistance : " + person.getId());
        em.persist(person);
        System.out.println("Id de la personne après persistance : " + person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void main2(){
        EntityManager em = emf.createEntityManager();

        Person person = em.find(Person.class, 2L);
        System.out.println(person);




        em.close();
        emf.close();

    }

    public static void remover(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1L);
        em.remove(person);
        em.getTransaction().commit();


        em.close();
        emf.close();

    }

    public  static  void createQuerry(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person("le rouge", "bubule");
        Person person2 = new Person("le blob", "bloupy");
        em.persist(person);
        em.persist(person2);

        List<Person> personList = null;

        personList = em.createQuery("select p from Person p ", Person.class).getResultList();

        for (Person p : personList){
            System.out.println(p);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
