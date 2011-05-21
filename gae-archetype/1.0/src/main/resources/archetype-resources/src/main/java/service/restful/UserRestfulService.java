/**
 * 
 */
package ${package}.service.restful;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.model.User;
import ${package}.service.UserService;

/**
 * @author Bill
 *
 */
@Service
@Transactional
public class UserRestfulService extends JdoDaoSupport implements UserService {

	/**
	 * 
	 */
	@Autowired
	public UserRestfulService(PersistenceManagerFactory persistenceManagerFactory) {
		// TODO Auto-generated constructor stub
		setPersistenceManagerFactory(persistenceManagerFactory);
	}
	
	/* (non-Javadoc)
	 * @see ${package}.service.UserService#create(${package}.model.User)
	 */
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return (User) getJdoTemplate().makePersistent(user);
	}
	
	/* (non-Javadoc)
	 * @see ${package}.service.UserService#show(java.lang.String)
	 */
	@Override
	public User show(String id) {
		// TODO Auto-generated method stub
		return (User) getJdoTemplate().getObjectById(User.class, id);
	}

}
