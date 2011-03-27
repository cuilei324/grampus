/**
 * 
 */
package ${package}.rest.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.model.User;
import ${package}.persistence.UserDao;
import ${package}.rest.UserService;

/**
 * @author Bill
 *
 */
@Service("${package}.rest.UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public Response create(String name) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(name);
		dao.save(user);
		return Response.status(Status.OK).build();
	}
	
	public User show(Long id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

}
