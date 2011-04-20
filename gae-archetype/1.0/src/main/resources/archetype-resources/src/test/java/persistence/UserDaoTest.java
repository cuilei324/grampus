/**
 * 
 */
package ${package}.persistence;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.model.User;
import ${package}.persistence.impl.UserDaoImpl;
import ${package}.utils.JdoTemplate;

/**
 * @author Bill
 *
 */
@RunWith(MockitoJUnitRunner.class)  
public class UserDaoTest {
		
	private User user;
	
	private UserDaoImpl userDao; 	
	
	@Mock
	private JdoTemplate jdoTemplate;
		
	@Before
	public void testSetup() {
		userDao = new UserDaoImpl();
		userDao.setJdoTemplate(jdoTemplate);
		user = new User();
		user.setId(1l);
		user.setName("bill");						
	}
	
	@After
	public void testShutdown() {	
		userDao = null;
		user = null;
	}

	@Test
	public void testSave() {
		when(jdoTemplate.save(user)).thenReturn(user);
		Long result = userDao.save(user);
		verify(jdoTemplate).save(user);
		assertEquals(Long.valueOf(1), result);
	}
	
	@Test
	public void testFind() {
		when(jdoTemplate.find(User.class, user.getId())).thenReturn(user);
		User result = userDao.find(user.getId());
		verify(jdoTemplate).find(User.class, user.getId());
		assertEquals("bill", result.getName());
	}

}
