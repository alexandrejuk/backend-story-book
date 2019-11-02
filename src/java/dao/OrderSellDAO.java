package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.OrderSell;

public class OrderSellDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public OrderSell save(OrderSell orderSell) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(orderSell);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return orderSell;
    }
    
    public OrderSell update(OrderSell orderSell) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(orderSell);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return orderSell;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        OrderSell orderSell = em.find(OrderSell.class, id);
        try {
            em.getTransaction().begin();
            em.remove(orderSell);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public OrderSell findById(Long id) {
        EntityManager em = getEM();
        OrderSell orderSell = null;
        try {
            orderSell = em.find(OrderSell.class, id);
        } finally {
            em.close();
        }
        return orderSell;
    }
    
     public List<OrderSell> findAll() {
        EntityManager em = getEM();
        List<OrderSell> ordersSell = null;
        try {
            ordersSell = em
                    .createQuery("SELECT orderSell FROM OrderSell orderSell", OrderSell.class)
                    .getResultList();
        } finally {
            em.close();
        }
        return ordersSell;
    }
}
