/**
 * 
 */
package ${package}.persistence.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import ${package}.model.User;
import ${package}.persistence.UserDao;
import ${package}.persistence.impl.UserDaoImpl;

/**
 * @author Bill
 *
 */
public class UserDaoIntegrationTest {
	
	private UserDao userDao;
	
	private LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	
	@Before
	public void testSetup() {
		userDao = new UserDaoImpl();
		helper.setUp();
	}
	
	@After
	public void testShutdown() {
		userDao = null;
		helper.tearDown();
	}
		
	@Test
	public void testSaveAndFind() {
		User newUser = new User();
		newUser.setName("bill");	
		long userId = userDao.save(newUser);
		assertNotNull(userId);	
		User user = userDao.find(userId);
		assertEquals("bill", user.getName());
	}
	
}

