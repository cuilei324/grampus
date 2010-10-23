package grampus

class SerialEndpoint extends Endpoint {
	
	int baudRate
	int dataBits
	int stopBits
	String parity
	String flowControl

    static constraints = {
		
    }
}
