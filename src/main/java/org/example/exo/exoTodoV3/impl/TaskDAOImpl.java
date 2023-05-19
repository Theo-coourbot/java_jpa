package org.example.exo.exoTodoV3.impl;





import org.example.exo.exoTodoV3.model.TaskV3;
import org.example.exo.exoTodoV3.dao.TaskDAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    private EntityManagerFactory entityManagerFactory;

    public TaskDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean addTask(TaskV3 task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }


    public List<TaskV3> getAllTasksByUser(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query q  = entityManager.createQuery("SELECT t FROM TaskV3 t where t.userTodoId.id = :id ", TaskV3.class);
        q.setParameter("id",id);
        List<TaskV3> tasks = q.getResultList();
        entityManager.close();
        return tasks;
    }

    @Override
    public List<TaskV3> getAllTasks() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<TaskV3> tasks = entityManager.createQuery("SELECT t FROM TaskV3 t", TaskV3.class).getResultList();
        entityManager.close();
        return tasks;
    }

    @Override
    public boolean deleteTask(Long taskId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TaskV3 task = entityManager.find(TaskV3.class,taskId);
            if(task != null){
                entityManager.remove(task);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public boolean markTaskAsCompleted(Long taskId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            org.example.exo.exoTodoV3.model.TaskV3 task = entityManager.find(org.example.exo.exoTodoV3.model.TaskV3.class,taskId);
            if(task != null){
                task.setCompleted(true);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }
}
