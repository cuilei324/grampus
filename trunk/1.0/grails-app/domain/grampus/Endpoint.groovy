package grampus

class Endpoint {
	
	String name
	String address
	String port
	static hasMany = [ devices : Device ]
	
    static constraints = {
		address(nullable : true)
    }
}
