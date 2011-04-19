/**
 * 
 */
package ${package}.integration;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.springmvc.tjws.TJWSEmbeddedSpringMVCServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Bill
 *
 */
public class UserIntegrationTest {

	private static TJWSEmbeddedSpringMVCServer server;
	
	@Before
	public void testSetup() {
		server = new TJWSEmbeddedSpringMVCServer("classpath:/beans.xml", 8080);
	    server.start();
	}
	
	@After
	public void testShutdown() {
		server.stop();
	}
	
	@Test
	public void testCreate() throws HttpException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8080/api/user");
		post.setEntity(new StringEntity("{\"user\":{\"name\":\"bill\"}}"));
		post.setHeader("Content-Type", "application/json;charset=UTF-8");
		HttpResponse response = client.execute(post);
        assertEquals(200, response.getStatusLine().getStatusCode());
	}
	
}