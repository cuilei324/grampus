package grampus

import grails.test.*

class DeviceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateDevice() {
		def testInstances = []
		mockDomain(Device, testInstances)
		assertEquals 0, Device.count()
		new Device(name : "Amplifier", address : "20", state : "offline",
				   endpoint : new Endpoint(name : "TCP Server", port : "8800", 
				   protocol : "modbus", state : "offline")).save()
		assertEquals 1, Device.count()
    }
}
