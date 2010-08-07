package grampus

class Device {
	
	String name
	String address
	String port

    static constraints = {
		port(blank : false)
    }
}
