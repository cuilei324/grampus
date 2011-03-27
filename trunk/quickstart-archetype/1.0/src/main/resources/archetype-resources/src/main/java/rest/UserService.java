/**
 * 
 */
package ${package}.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import ${package}.model.User;

/**
 * @author Bill
 *
 */
@Path("/user")
public interface UserService {

	/**
	 * 
	 * @param name
	 * @return
	 */
	@POST
	Response create(@FormParam("name") String name);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	User show(@PathParam("id") Long id);
	
}
