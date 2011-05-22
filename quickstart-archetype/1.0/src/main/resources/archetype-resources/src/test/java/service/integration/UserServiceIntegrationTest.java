/**
 * 
 */
package ${package}.service.integration;

import static junit.framework.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Test;

import ${package}.model.User;

/**
 * @author Bill
 *
 */
public class UserServiceIntegrationTest {
	
	@Test
    public void testCRUD() throws Exception {
		ClientRequest request = new ClientRequest("http://localhost:8080/${artifactId}/api/user");
        request.body(MediaType.APPLICATION_JSON, "{\"user\":{\"name\":\"bill\"}}").accept(MediaType.APPLICATION_JSON);
        ClientResponse<?> response = request.post();
        assertEquals(200, response.getStatus());
        User user = response.getEntity(User.class);
        assertEquals("bill", user.getName());
        response.releaseConnection();
        request = new ClientRequest("http://localhost:8080/${artifactId}/api/user/{id}");
        request.pathParameter("id", user.getId()).accept(MediaType.APPLICATION_JSON);
        response = request.get();
        assertEquals(200, response.getStatus());
        assertEquals("bill", response.getEntity(User.class).getName());
        response.releaseConnection();
    }
	
}