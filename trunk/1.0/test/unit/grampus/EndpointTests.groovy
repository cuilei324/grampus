package grampus

import grails.test.*

class EndpointTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateEndpoint() {
		def testInstances = []
		mockDomain(Endpoint, testInstances)
		assertEquals 0, Endpoint.count()
		new Endpoint(name : "TCP Server", address : "10.70.2.20", port : "8800").save()
		assertEquals 1, Endpoint.count()
    }
}
