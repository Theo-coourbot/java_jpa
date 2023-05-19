package org.example.impl;

import org.example.dao.CategorieDAO;
import org.example.model.Categorie;
import org.example.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CategorieDAOImpl implements CategorieDAO {

    private EntityManagerFactory entityManagerFactory;

    public CategorieDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public void addCategorie(Categorie categorie) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(categorie);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteCategorie(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Categorie categorie = entityManager.find(Categorie.class, id);
        if(categorie != null){
            entityManager.remove(categorie);
        }
        transaction.commit();
        entityManager.close();

    }
}
