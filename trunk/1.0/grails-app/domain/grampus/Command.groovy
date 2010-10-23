package grampus

class Command {
	
	String name
	String state
	static hasMany = [ variables : Variable ]
	static belongsTo = [ device : Device ]

    static constraints = {
		state(inList : ["OK", "Sending", "Sent", "Receiving", "Received", "Rejected"])
    }
}
