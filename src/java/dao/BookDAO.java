package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Book;

public class BookDAO {
    public EntityManager getEM() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("PapPU");
        return factory.createEntityManager();
    }
    
    public Book save(Book book) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return book;
    }
    
    public Book update(Book book) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return book;
    }
    
    public void delete(Long id) {
        EntityManager em = getEM();
        Book book = em.find(Book.class, id);
        try {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Book findById(Long id) {
        EntityManager em = getEM();
        Book book = null;
        try {
            book = em.find(Book.class, id);
        } finally {
            em.close();
        }
        return book;
    }
    
     public List<Book> findAll() {
        EntityManager em = getEM();
        List<Book> books = null;
        try {
            books = em
                    .createQuery("SELECT book FROM Book book", Book.class)
                    .getResultList();
        } finally {
            em.close();
        }
        return books;
    }

    
}
