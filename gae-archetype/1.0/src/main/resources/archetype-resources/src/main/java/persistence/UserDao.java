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
	Long save(User newInstance);
	
	/**
	 * 
	 * @param primaryKey
	 * @return
	 */
	User find(Long primaryKey);
	
}
