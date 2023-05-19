package org.example.cours.demo;

import org.example.cours.entity.oneToMany.GroupUser;
import org.example.cours.entity.oneToMany.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();

        user.setUsername("Brigitte");
        user.setPassword("1234");

        GroupUser groupUser = new GroupUser();

        groupUser.setName("CDA-Lille");
        groupUser.getUserSet().add(user);

        em.persist(user);
        em.persist(groupUser);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
