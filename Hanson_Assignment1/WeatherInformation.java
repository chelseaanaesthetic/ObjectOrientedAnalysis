/**
 * ICS 372.01: Assignment 1
 * WeatherInformation.java
 * Purpose: Gives record temperatures to a location and makes it look nice when printed.
 *
 * @author Chelsea Hanson
 * @version 1.0 9/4/15
 */
public class WeatherInformation implements WeatherRecord{
	public Latitude latitude;
    public Longitude longitude;
    private double maxTemperature;
	private double minTemperature;

    /**
     * Constructs an Object to store weather data about a particular location.
     * @param latitude coordinate of the location north or south
     * @param longitude coordinate of the location east or west
     * @param maxTemperature the new maximum temperature
     * @param minTemperature the new minimum temperature
     */
	public WeatherInformation(Latitude latitude, Longitude longitude, 
							  double maxTemperature, double minTemperature){
        this.latitude = latitude;
        this.longitude = longitude;
        setMaxTemperature(maxTemperature);
        setMinTemperature(minTemperature);
	}

    /**
     * Sets the maximum recorded temperature.
     * @param maxTemperature the new maximum temperature
     */
	public void setMaxTemperature(double maxTemperature){
        if (maxTemperature > this.maxTemperature) {
            this.maxTemperature = maxTemperature;
        }
	}

    /**
     * Sets the minimum recorded temperature.
     * @param minTemperature the new minimum temperature
     */
	public void setMinTemperature(double minTemperature){
        if (minTemperature < this.maxTemperature){
            this.minTemperature = minTemperature;
        }
	}

    /**
     * Overrides the toString method.
     * @return A string representation of the object
     */
    public String toString(){
        return ("WeatherInformation [latitude=" + latitude + ", \r\nlongitude=" + longitude +
                ", \r\nmaxTemperature=" + maxTemperature + ", minTemperature=" + minTemperature + "]");
    }
	
}