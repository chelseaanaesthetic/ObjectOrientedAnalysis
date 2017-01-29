/**
 * ICS 372.01: Assignment 1
 * Latitude.java
 * Purpose: Creates a coordinate for a location and makes it look nice when printed.
 *
 * @author Chelsea Hanson
 * @version 1.0 9/4/15
 */
public class Latitude extends Position{
	private String northOrSouth;

	/**
	 * Constructs a coordinate in degree, minute form.
	 * @param degree
	 * @param minute
	 * @param northOrSouth
	 */
	public Latitude(int degree, int minute, String northOrSouth){
		super(degree, minute);
		this.northOrSouth = northOrSouth;
	}

	/**
	 * Overrides the toString method.
	 * @return A string representation of the object
	 */
    public String toString(){
        return ("Latitude: [" + super.toString() + " NorthOrSouth=" + northOrSouth + "]");
    }
}