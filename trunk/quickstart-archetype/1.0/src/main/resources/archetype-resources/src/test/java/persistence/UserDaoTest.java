/**
 * 
 */
package ${package}.persistence;

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
	private SessionFactory sessionFactory;
	
	@Mock
	private HibernateTemplate hibernateTemplate;
		
	@Before
	public void testSetup() {
		userDao = new UserDaoImpl(sessionFactory);
		userDao.setHibernateTemplate(hibernateTemplate);
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
		when(hibernateTemplate.save(user)).thenReturn(user.getId());
		Long result = userDao.save(user);
		verify(hibernateTemplate).save(user);
		assertEquals(Long.valueOf(1), result);
	}
	
	@Test
	public void testFind() {
		when(hibernateTemplate.get(User.class, user.getId())).thenReturn(user);
		User result = userDao.find(user.getId());
		verify(hibernateTemplate).get(User.class, user.getId());
		assertEquals("bill", result.getName());
	}

}
