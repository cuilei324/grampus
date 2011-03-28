/**
 * 
 */
package ${package}.rest;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.model.User;
import ${package}.rest.impl.UserServiceImpl;

/**
 * @author Bill
 *
 */
@RunWith(MockitoJUnitRunner.class)  
public class UserServiceTest {

	private User user;
	
	private Response response;
	
	@Mock
	private UserServiceImpl userService; 	
		
	@Before
	public void testSetup() {
		user = new User();
		user.setId(1l);
		user.setName("bill");		
		response = Response.status(Status.OK).build();
	}
	
	@After
	public void testShutdown() {	
		userService = null;
		user = null;
	}

	@Test
	public void testCreate() {
		when(userService.create(user.getName())).thenReturn(response);
		Response result = userService.create(user.getName());
		verify(userService).create(user.getName());
		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testFind() {
		when(userService.show(user.getId())).thenReturn(user);
		User result = userService.show(user.getId());
		verify(userService).show(user.getId());
		assertEquals("bill", result.getName());
	}

}
