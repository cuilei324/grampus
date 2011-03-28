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

/**
 * @author Bill
 *
 */
@RunWith(MockitoJUnitRunner.class)  
public class UserDaoTest {
		
	private User user;
	
	@Mock
	private UserDaoImpl userDao; 	
		
	@Before
	public void testSetup() {		
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
		when(userDao.save(user)).thenReturn(user.getId());
		Long result = userDao.save(user);
		verify(userDao).save(user);
		assertEquals(Long.valueOf(1), result);
	}
	
	@Test
	public void testFind() {
		when(userDao.find(user.getId())).thenReturn(user);
		User result = userDao.find(user.getId());
		verify(userDao).find(user.getId());
		assertEquals("bill", result.getName());
	}

}
