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
	
	/* (non-Javadoc)
	 * @see ${package}.persistence.UserDao#save(${package}.model.User)
	 */
	@Override
	public String save(User newInstance) {
		// TODO Auto-generated method stub
		return ((User) getJdoTemplate().save(newInstance)).getPrimaryKey();
	}

	/* (non-Javadoc)
	 * @see ${package}.persistence.UserDao#find(java.lang.String)
	 */
	@Override
	public User find(String primaryKey) {
		// TODO Auto-generated method stub
		return (User) getJdoTemplate().find(User.class, primaryKey);
	}

}
