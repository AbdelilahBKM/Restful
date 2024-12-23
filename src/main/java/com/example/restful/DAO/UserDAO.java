package com.example.restful.DAO;

import com.example.restful.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class UserDAO implements IUser {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("Restful");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUser(Long id) {
        entityManager.getTransaction().begin();
        User user = null;
        try {
            user = entityManager.find(User.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        try{
            User user1 = entityManager.find(User.class, user.getId());
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.getTransaction().begin();
        try{
            User u = entityManager.find(User.class, id);
            entityManager.remove(u);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
