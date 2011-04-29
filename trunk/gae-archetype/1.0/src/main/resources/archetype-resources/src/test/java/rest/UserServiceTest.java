/**
 * 
 */
package ${package}.rest;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.model.User;
import ${package}.persistence.UserDao;
import ${package}.rest.impl.UserServiceImpl;

/**
 * @author Bill
 *
 */
@RunWith(MockitoJUnitRunner.class)  
public class UserServiceTest {

	private User user;
	
	private UserServiceImpl userService; 	
	
	@Mock
	private UserDao userDao;
		
	@Before
	public void testSetup() {
		userService = new UserServiceImpl(userDao);
		user = new User();
		user.setId("asa");
		user.setName("bill");		
	}
	
	@After
	public void testShutdown() {	
		userService = null;
		userDao = null;
		user = null;
	}

	@Test
	public void testCreate() {
		Response result = userService.create(user);
		ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);  
		verify(userDao).save(argument.capture()); 
		assertEquals("bill", argument.getValue().getName());
		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testShow() {
		when(userDao.find(user.getId())).thenReturn(user);
		User result = userService.show(user.getId());
		verify(userDao).find(user.getId());
		assertEquals("bill", result.getName());
	}

}
