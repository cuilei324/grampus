package grampus

class Record {
	
	String variableValue
	Date timestamp
	static belongsTo = [ variable : Variable ] 

    static constraints = {
    }
}
