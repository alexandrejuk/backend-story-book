package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Product;

public class ProductDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public Product save(Product product) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return product;
    }
    
    public Product update(Product product) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return product;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        Product product = em.find(Product.class, id);
        try {
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Product findById(Long id) {
        EntityManager em = getEM();
        Product product = null;
        try {
            product = em.find(Product.class, id);
        } finally {
            em.close();
        }
        return product;
    }
    
     public List<Product> findAll() {
        EntityManager em = getEM();
        List<Product> products = null;
        try {
            products = em
                    .createQuery("SELECT product FROM Product product", Product.class)
                    .getResultList();
        } finally {
            em.close();
        }
        return products;
    }
}
