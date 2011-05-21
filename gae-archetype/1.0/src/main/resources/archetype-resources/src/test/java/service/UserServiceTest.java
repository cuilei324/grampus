/**
 * 
 */
package ${package}.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.jdo.JdoTemplate;

import ${package}.model.User;
import ${package}.service.restful.UserRestfulService;

/**
 * @author Bill
 *
 */
@RunWith(MockitoJUnitRunner.class)  
public class UserServiceTest {

	private User user;
	
	private UserRestfulService userService; 	
	
	@Mock
	private PersistenceManagerFactory persistenceManagerFactory;
	
	@Mock
	private JdoTemplate jdoTemplate;
		
	@Before
	public void testSetup() {
		userService = new UserRestfulService(persistenceManagerFactory);
		userService.setJdoTemplate(jdoTemplate);
		user = new User();
		user.setId("asa");
		user.setName("bill");		
	}
	
	@After
	public void testShutdown() {	
		userService = null;
		user = null;
	}

	@Test
	public void testCreate() {
		when(jdoTemplate.makePersistent(user)).thenReturn(user);
		User result = userService.create(user);
		verify(jdoTemplate).makePersistent(user); 
		assertEquals("bill", result.getName());
	}
	
	@Test
	public void testShow() {
		when(jdoTemplate.getObjectById(User.class, user.getId())).thenReturn(user);
		User result = userService.show(user.getId());
		verify(jdoTemplate).getObjectById(User.class, user.getId());
		assertEquals("bill", result.getName());
	}

}
