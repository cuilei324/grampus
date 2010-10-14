package grampus

class Point {
	
	String name
	String value
	static belongsTo = [ device : Device ]

    static constraints = {
		value(nullable : true)
    }
}
