/**
 * 
 */
package ${package}.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ${package}.model.User;

/**
 * @author Bill
 *
 */
@Path("/api/user")
public interface UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	Response create(User user);
	
	/**
	 * 
	 * @param primaryKey
	 * @return
	 */
	@GET
	@Path("/{primaryKey}")
	@Produces(MediaType.APPLICATION_JSON)
	User show(@PathParam("primaryKey") String primaryKey);
	
}
