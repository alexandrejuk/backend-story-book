package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Customer;

public class CustomerDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public Customer save(Customer customer) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return customer;
    }
    
    public Customer update(Customer customer) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return customer;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        Customer customer = em.find(Customer.class, id);
        try {
            em.getTransaction().begin();
            em.remove(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Customer findById(Long id) {
        EntityManager em = getEM();
        Customer customer = null;
        try {
            customer = em.find(Customer.class, id);
        } finally {
            em.close();
        }
        return customer;
    }
    
     public List<Customer> findAll() {
        EntityManager em = getEM();
        List<Customer> customers = null;
        try {
            customers = em
                    .createQuery("SELECT customer FROM Customer customer", Customer.class)
                    .getResultList();
        } finally {
            em.close();
        }
        return customers;
    }
}
