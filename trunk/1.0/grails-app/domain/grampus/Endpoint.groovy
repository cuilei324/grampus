package grampus

class Endpoint {
	
	String name
	String port
	String protocol
	String state
	static hasMany = [ devices : Device ]
	
    static constraints = {
		state(inList : ["offline", "online", "fault"])
    }
}
