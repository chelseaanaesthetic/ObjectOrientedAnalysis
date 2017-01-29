/**
 * ICS 372.01: Assignment 1
 * Longitude.java
 * Purpose: Creates a coordinate for a location and makes it look nice when printed.
 *
 * @author Chelsea Hanson
 * @version 1.0 9/4/15
 */
public class Longitude extends Position{
	private String eastOrWest;

	/**
	 * Constructs a coordinate in degree, minute form.
	 * @param degree distance from the prime meridian
	 * @param minute fractional part of degree
	 * @param eastOrWest direction from the prime meridian
	 */
	public Longitude(int degree, int minute, String eastOrWest){
		super(degree, minute);
		this.eastOrWest = eastOrWest;
	}

	/**
	 * Overrides the toString method.
	 * @return A string representation of the object
	 */
    public String toString(){
		return ("Longitude: [" + super.toString() + " eastOrWest=" + eastOrWest + "]");
    }
}