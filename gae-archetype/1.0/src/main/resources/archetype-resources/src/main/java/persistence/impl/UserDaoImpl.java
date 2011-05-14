/**
 * 
 */
package ${package}.persistence.impl;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.stereotype.Repository;

import ${package}.model.User;
import ${package}.persistence.UserDao;

/**
 * @author Bill
 *
 */
@Repository
public class UserDaoImpl extends JdoDaoSupport implements UserDao {

	/**
	 * 
	 */
	@Autowired
	public UserDaoImpl(PersistenceManagerFactory persistenceManagerFactory) {
		// TODO Auto-generated constructor stub	
		setPersistenceManagerFactory(persistenceManagerFactory);
	}
	
	/* (non-Javadoc)
	 * @see ${package}.persistence.UserDao#save(${package}.model.User)
	 */
	@Override
	public String save(User newInstance) {
		// TODO Auto-generated method stub
		return ((User) getJdoTemplate().makePersistent(newInstance)).getId();
	}

	/* (non-Javadoc)
	 * @see ${package}.persistence.UserDao#find(java.lang.String)
	 */
	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return (User) getJdoTemplate().getObjectById(User.class, id);
	}

}
