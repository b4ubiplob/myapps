package sampledbwebapp.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sampledbwebapp.entities.TUser;

public class UserDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "sample_db";
    private static EntityManager em;;
     
    
    public UserDao() {
    		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }
    
    public List<TUser> getAllUsers() {
        Query q = em.createQuery("select t from TUser t");
        return q.getResultList();
    }

    
    public TUser createUser(TUser tUser) {
    		tUser.setCreatedOn(new Date());
    		tUser.createHashCode(new Date().toString());
    		em.getTransaction().begin();
    		em.persist(tUser);
    		em.getTransaction().commit();
    		return tUser;
    }
}
