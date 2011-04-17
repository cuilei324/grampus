/**
 * 
 */
package ${package}.persistence.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
