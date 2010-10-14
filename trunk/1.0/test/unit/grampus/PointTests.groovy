package grampus

import grails.test.*

class PointTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreatePoint() {
		def testInstances = []
		mockDomain(Point, testInstances)
		assertEquals 0, Point.count()
		new Point(name : "azimuth", device : new Device(name : "Amplifier", address : "20", protocol : "Modbus",
				  endpoint : new Endpoint(name : "Serial Peer", port : "COM1"))).save()
		assertEquals 1, Point.count()
    }
}
