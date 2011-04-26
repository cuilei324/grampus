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
		user.setPrimaryKey("asa");
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
		String result = userDao.save(user);
		verify(jdoTemplate).save(user);
		assertEquals("asa", result);
	}
	
	@Test
	public void testFind() {
		when(jdoTemplate.find(User.class, user.getPrimaryKey())).thenReturn(user);
		User result = userDao.find(user.getPrimaryKey());
		verify(jdoTemplate).find(User.class, user.getPrimaryKey());
		assertEquals("bill", result.getName());
	}

}
