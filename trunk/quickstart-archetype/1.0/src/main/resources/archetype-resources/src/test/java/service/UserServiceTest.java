/**
 * 
 */
package ${package}.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
	private SessionFactory sessionFactory;
	
	@Mock
	private HibernateTemplate hibernateTemplate;
		
	@Before
	public void testSetup() {
		userService = new UserRestfulService(sessionFactory);
		userService.setHibernateTemplate(hibernateTemplate);
		user = new User();
		user.setId(1l);
		user.setName("bill");		
	}
	
	@After
	public void testShutdown() {	
		userService = null;
		user = null;
	}

	@Test
	public void testCreate() {
		when(hibernateTemplate.save(user)).thenReturn(user.getId());
		when(hibernateTemplate.get(User.class, user.getId())).thenReturn(user);
		User result = userService.create(user); 
		verify(hibernateTemplate).save(user);
		verify(hibernateTemplate).get(User.class, user.getId());
		assertEquals("bill", result.getName());
	}
	
	@Test
	public void testShow() {
		when(hibernateTemplate.get(User.class, user.getId())).thenReturn(user);
		User result = userService.show(user.getId());
		verify(hibernateTemplate).get(User.class, user.getId());
		assertEquals("bill", result.getName());
	}

}
