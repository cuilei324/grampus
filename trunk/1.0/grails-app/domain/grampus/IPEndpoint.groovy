package grampus

class IPEndpoint extends Endpoint {
	
	String address
	String type

    static constraints = {
		type(inList : ["TCPServer", "TCPClient", "UDPServer", "UDPClient"])
    }
}
