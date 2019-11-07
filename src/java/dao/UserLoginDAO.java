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
    
    public UserLogin findByName(String username, String password) {
        EntityManager em = getEM();
        UserLogin userLogin = null;
        try {
            userLogin = em.find(UserLogin.class, username);
            if (!userLogin.getPassword().equals(password)) {
                userLogin = null;
            }
        } finally {
            em.close();
        }
        return userLogin;
    }
 
}
