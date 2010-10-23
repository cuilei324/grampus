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
		new Endpoint(name : "TCP Server", port : "8800", protocol : "modbus", state : "offline").save()
		assertEquals 1, Endpoint.count()
    }
}
