package org.example.cours.demo;

import org.example.cours.entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {

      public static void main() {

          EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
          EntityManager em = emf.createEntityManager();

          EntityTransaction transaction =  em.getTransaction();

          transaction.begin();

//          Person person = new Person("toto","titi");
//          em.persist(person);
//
//          transaction.commit();


          Person person1 = em.find(Person.class,8L);
          System.out.println(person1);



          Person personRef = em.getReference(Person.class,8L);
          System.out.println(personRef);

          // recup avec query
          Query query = em.createQuery( "select p from Person p where p.prenom ='titi'");
          Person person3 = (Person) query.getSingleResult();
          System.out.println(person3);

          // recup avec query avec liste
          System.out.println("personne dont le nom est bubule");
          Query query2 = em.createQuery( "select p from Person p where p.prenom ='bubule'");

          List<Person> personList  =  query2.getResultList();
          for (Person p : personList){
              System.out.println(p);
          }


          // recup avec query parametre
          System.out.println("personne dont l'id est superieur a 7 avec param");
          Query query3 = em.createQuery( "select p from Person p where p.id > :id");
          query3.setParameter("id",7L);

          List<Person> person5  =  query3.getResultList();
          for (Person p : person5){
              System.out.println(p);
          }

          //modif
          System.out.println("je modifie");
//          transaction.begin();
          Person personUpdate = em.find(Person.class,7L);
          System.out.println(personUpdate);
          personUpdate.setNom("requin");
          personUpdate.setPrenom("marcus");
          em.flush();
          transaction.commit();
          personUpdate = em.find(Person.class,7L);
          System.out.println(personUpdate);


          // suppression
          System.out.println("suprimer perso avc id 6");
          transaction.begin();
          Person personDelete =  em.find(Person.class,6L);

          if (personDelete != null){

          em.remove(personDelete);
          transaction.commit();
          System.out.println("suppression ok");

          Query selctBetween = em.createQuery("select p from Person p where p.id between  5 and 9");
          List<Person> personList2 = selctBetween.getResultList();

          for (Person p : personList2){
              System.out.println(p);
          }

          } else {
              System.out.println("non trouver");
          }


          // native query
          System.out.println("native query");
          List<Person> results = em.createNativeQuery("select  * from person",Person.class).getResultList();
          for (Person p : results){
              System.out.println(p);
          }
          em.close();
          emf.close();





    }
}
