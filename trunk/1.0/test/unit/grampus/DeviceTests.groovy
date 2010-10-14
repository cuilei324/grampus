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
		new Device(name : "Amplifier", address : "20", protocol : "Modbus",
				   endpoint : new Endpoint(name : "Serial Peer", port : "COM1")).save()
		assertEquals 1, Device.count()
    }
}
