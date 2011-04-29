/**
 * 
 */
package ${package}.utils;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

/**
 * @author Bill
 *
 */
public class JdoTemplate {

	private static final PersistenceManagerFactory persistenceManagerFactory = 
		JDOHelper.getPersistenceManagerFactory("transactions-optional");
		
	/**
	 * 
	 */
	public JdoTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param newInstance
	 * @return
	 */
	public Object save(Object newInstance) {
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		Transaction transaction = persistenceManager.currentTransaction();
		Object obj = null;
		try {
            transaction.begin();      
            obj = persistenceManager.makePersistent(newInstance);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
            	transaction.rollback();
            }
            persistenceManager.close();
        }
		return obj;
	}

	/**
	 * 
	 * @param objClass
	 * @param id
	 * @return
	 */
	public Object find(Class<?> objClass, String id) {
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		Transaction transaction = persistenceManager.currentTransaction();
		Object obj = null;
		try {
            transaction.begin();      
            obj = persistenceManager.getObjectById(objClass, id);
            transaction.commit();
        } finally {  
        	if (transaction.isActive()) {
            	transaction.rollback();
            }
            persistenceManager.close();
        }
		return obj;
	}

}
