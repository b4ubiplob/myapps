package sampledbwebapp;

import static org.junit.Assert.fail;

import java.beans.PersistenceDelegate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import sampledbwebapp.entities.TUser;

public class DatabaseTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "sample_db";
    private static EntityManagerFactory factory;
    
    @Before
    public void setUp() {
		Persistence.generateSchema(PERSISTENCE_UNIT_NAME, Collections.EMPTY_MAP);
    }
    
	@Test
	public void testDB() {
		
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	        // read the existing entries and write to console
	        Query q = em.createQuery("select t from TUser t");
	        List<TUser> users = q.getResultList();
	        for (TUser user : users) {
	            System.out.println(user);
	        }
	        System.out.println("Size: " + users.size());

	        // create new todo
	        em.getTransaction().begin();
	        TUser tUser = new TUser();
	        tUser.setUsername("user1");
	        tUser.setPassword("password");
	        tUser.setCreatedOn(new Date());
	        tUser.createHashCode(new Date().toString());
	        em.persist(tUser);
	        em.getTransaction().commit();

	        em.close();	
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Failed to initialize db");
		}
		
	}

}
