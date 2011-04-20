/**
 * 
 */
package ${package}.persistence.impl;

import org.springframework.stereotype.Repository;

import ${package}.model.User;
import ${package}.persistence.UserDao;
import ${package}.utils.AbstractDaoSupport;

/**
 * @author Bill
 *
 */
@Repository
public class UserDaoImpl extends AbstractDaoSupport implements UserDao {

	/**
	 * 
	 */
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub	
	}
	
	public Long save(User newInstance) {
		// TODO Auto-generated method stub
		User user = (User) getJdoTemplate().save(newInstance);
		return user.getId();
	}
	
	public User find(Long primaryKey) {
		// TODO Auto-generated method stub
		return (User) getJdoTemplate().find(User.class, primaryKey);
	}

}
