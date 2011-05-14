/**
 * 
 */
package ${package}.persistence.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import ${package}.model.User;
import ${package}.persistence.UserDao;

/**
 * @author Bill
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class UserDaoIntegrationTest {
	
	@Autowired
	private UserDao userDao;
	
	private LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	
	@Before
	public void testSetup() {
		helper.setUp();
	}
	
	@After
	public void testShutdown() {
		helper.tearDown();
	}
		
	@Test
	public void testSaveAndFind() {
		User newUser = new User();
		newUser.setName("bill");	
		String primaryKey = userDao.save(newUser);
		assertNotNull(primaryKey);	
		User user = userDao.find(primaryKey);
		assertEquals("bill", user.getName());
	}
	
}

