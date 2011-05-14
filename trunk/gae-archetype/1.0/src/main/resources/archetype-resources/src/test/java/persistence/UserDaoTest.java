/**
 * 
 */
package ${package}.persistence;

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
import ${package}.persistence.impl.UserDaoImpl;

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
	
	@Mock
	private PersistenceManagerFactory persistenceManagerFactory;
		
	@Before
	public void testSetup() {
		userDao = new UserDaoImpl(persistenceManagerFactory);
		userDao.setJdoTemplate(jdoTemplate);
		user = new User();
		user.setId("asa");
		user.setName("bill");						
	}
	
	@After
	public void testShutdown() {	
		userDao = null;
		user = null;
	}

	@Test
	public void testSave() {
		when(jdoTemplate.makePersistent(user)).thenReturn(user);
		String result = userDao.save(user);
		verify(jdoTemplate).makePersistent(user);
		assertEquals("asa", result);
	}
	
	@Test
	public void testFind() {
		when(jdoTemplate.getObjectById(User.class, user.getId())).thenReturn(user);
		User result = userDao.find(user.getId());
		verify(jdoTemplate).getObjectById(User.class, user.getId());
		assertEquals("bill", result.getName());
	}

}
