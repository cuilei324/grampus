package grampus

class Device {
	
	String name
	String address
	String state
	static hasMany = [ commands : Command ]
	static belongsTo = [ endpoint : Endpoint ] 

    static constraints = {
		state(inList : ["offline", "online", "fault"])
    }
}
