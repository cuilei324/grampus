/**
 * 
 */
package ${package}.persistence;

import ${package}.model.User;

/**
 * @author Bill
 *
 */
public interface UserDao {

	/**
	 * 
	 * @param newInstance
	 * @return
	 */
	String save(User newInstance);
	
	/**
	 * 
	 * @param primaryKey
	 * @return
	 */
	User find(String primaryKey);
	
}
