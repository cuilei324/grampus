package grampus

class Variable {
	
	String name
	String type
	String value
	String state
	static hasMany = [ records : Record ]
	static belongsTo = [ command : Command ]
	
    static constraints = {
		type(inList : ["ReadOnly", "ReadWrite", "WriteOnly"])
		state(inList : ["OK", "ERROR"])
    }
}
