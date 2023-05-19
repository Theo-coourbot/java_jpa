package org.example.exo.exo1.dao;

import org.example.exo.exo1.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TodoDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void ajoutDeTodo(String titre){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = new Todo(titre,true);
        todo.setCompleted(false);
        em.persist(todo);
        em.getTransaction().commit();
        em.close();

        System.out.println("ajout reussi");
    }

    public static  void touteLesTodo() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Todo> todos = null;

        todos = em.createQuery("select  t from Todo t ", Todo.class).getResultList();

        if (todos == null){
            System.out.println("aucune todo");
        } else {
            for (Todo t : todos){
                System.out.println(t);
            }
        }
        em.getTransaction().commit();
        em.close();

    }

    public static void suprimerTodo(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        em.getTransaction().commit();


        em.close();

    }

    public static void updateTodo(){

    }


    public static void close(){
        emf.close();
    }
}
