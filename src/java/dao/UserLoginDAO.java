package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.UserLogin;

public class UserLoginDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public UserLogin save(UserLogin userLogin) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(userLogin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return userLogin;
    }
    
    public UserLogin update(UserLogin userLogin) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(userLogin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return userLogin;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        UserLogin userLogin = em.find(UserLogin.class, id);
        try {
            em.getTransaction().begin();
            em.remove(userLogin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public UserLogin findById(Long id) {
        EntityManager em = getEM();
        UserLogin userLogin = null;
        try {
            userLogin = em.find(UserLogin.class, id);
        } finally {
            em.close();
        }
        return userLogin;
    }
    
}
