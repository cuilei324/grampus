package grampus

class Device {
	
	String name
	String address
	String port
	String protocol
	static hasMany = [ points : Point ]
	static belongsTo = [ endpoint : Endpoint ] 

    static constraints = {
		port(nullable : true)
    }
}
