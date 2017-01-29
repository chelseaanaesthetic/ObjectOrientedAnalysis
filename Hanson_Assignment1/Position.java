/**
 * ICS 372.01: Assignment 1
 * Position.java
 * Purpose: Outlines what is needed for a coordinate and make it look nice when printed.
 *
 * @author Chelsea Hanson
 * @version 1.0 9/4/15
 */
public abstract class Position {
    private int degree;
    private int minute;

    /**
     * Constructs a coordinate in degree, minute form.
     * @param degree
     * @param minute
     */
    public Position(int degree, int minute){
        this.degree = degree;
        this.minute = minute;
    }

    /**
     * Overrides the toString method.
     * @return A String representation of the object.
     */
    public String toString(){
        return ("degree=" + degree + ", minute=" + minute);        
    }
}