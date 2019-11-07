package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Address;

public class AddressDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public Address save(Address address) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return address;
    }
    
    public Address update(Address address) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(address);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return address;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        Address address = em.find(Address.class, id);
        try {
            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Address findById(Long id) {
        EntityManager em = getEM();
        Address address = null;
        try {
            address = em.find(Address.class, id);
        } finally {
            em.close();
        }
        return address;
    }
    
     public List<Address> findAll() {
        EntityManager em = getEM();
        List<Address> addresses = null;
        try {
            addresses = em
                    .createQuery("SELECT address FROM Address address", Address.class)
                    .getResultList();
        } finally {
            em.close();
        }
        return addresses;
    }
}
