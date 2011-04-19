/**
 * 
 */
package ${package}.persistence.impl;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.springframework.stereotype.Repository;

import ${package}.model.User;
import ${package}.persistence.UserDao;

/**
 * @author Bill
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	private static final PersistenceManagerFactory persistenceManagerFactory = 
		JDOHelper.getPersistenceManagerFactory("transactions-optional");

	/**
	 * 
	 */
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub	
	}
	
	public Long save(User newInstance) {
		// TODO Auto-generated method stub
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		Transaction transaction = persistenceManager.currentTransaction();
		User user = null;
		try {
            transaction.begin();      
            user = persistenceManager.makePersistent(newInstance);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
            	transaction.rollback();
            }
            persistenceManager.close();
        }
		return user.getId();
	}
	
	public User find(Long primaryKey) {
		// TODO Auto-generated method stub
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		Transaction transaction = persistenceManager.currentTransaction();
		User user = null;
		try {
            transaction.begin();      
            user = persistenceManager.getObjectById(User.class, primaryKey);
            transaction.commit();
        } finally {            
            persistenceManager.close();
        }
		return user;
	}

}
