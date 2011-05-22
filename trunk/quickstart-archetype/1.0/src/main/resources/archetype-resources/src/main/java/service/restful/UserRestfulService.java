/**
 * 
 */
package ${package}.service.restful;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
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
public class UserRestfulService extends HibernateDaoSupport implements UserService {

	/**
	 * 
	 */
	@Autowired
	public UserRestfulService(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub	
		setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see ${package}.service.UserService#create(${package}.model.User)
	 */
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		Long id = (Long) getHibernateTemplate().save(user);
		return (User) getHibernateTemplate().get(User.class, id);
	}
	
	/* (non-Javadoc)
	 * @see ${package}.service.UserService#show(java.lang.Long)
	 */
	@Override
	public User show(Long id) {
		// TODO Auto-generated method stub
		return (User) getHibernateTemplate().get(User.class, id);
	}

}
