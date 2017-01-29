/**
 * ICS 372.01: Assignment 1
 * Driver.java
 * Purpose: Builds and displays weather records for various locations.
 *
 * @author Chelsea Hanson
 * @version 1.0 9/4/15
 */
public class Driver{

    /**
     * The main method to drive the weather classes.
     *
     * Coordinates sourced from http://dateandtime.info/
     * Record temps sourced from http://www.meteorologyclimate.com/extreme-temperature-records.htm
     *
     * @param args Not used
     */
    public static void main(String[] args){

        WeatherInformation[] locations = new WeatherInformation[10];

        // Los Angeles, California, USA
        locations[0] = new WeatherInformation(new Latitude(34, 03, "N"), new Longitude(118, 15, "W"), 111.92, 23);
        // Santiago, Chile
        locations[1] = new WeatherInformation(new Latitude(33, 27, "S"), new Longitude(70, 39, "W"), 98.96, 19.4);
        // Brisbane, Australia
        locations[2] = new WeatherInformation(new Latitude(27, 28, "S"), new Longitude(153, 02, "E"), 109.76, 36.14);
        // Mc Murdo, Antarctica
        locations[3] = new WeatherInformation(new Latitude(77, 51, "S"), new Longitude(166, 41, "E"), 48.2, -58);
        // Dubai, United Arab Emirates
        locations[4] = new WeatherInformation(new Latitude(25, 15, "N"), new Longitude(55, 18, "E"), 120.2, 45.32);
        // Saint-Petersburg, Russia
        locations[5] = new WeatherInformation(new Latitude(59, 56, "N"), new Longitude(30, 19, "E"), 94.28, -32.62);
        // Johannesburg, South Africa
        locations[6] = new WeatherInformation(new Latitude(26, 12, "S"), new Longitude(28, 03, "E"), 95.72, 17.24);
        // Montreal, Canada
        locations[7] = new WeatherInformation(new Latitude(45, 31, "N"), new Longitude(73, 35, "W"), 99.68, -43.6);
        // Ushuaia, Argentina
        locations[8] = new WeatherInformation(new Latitude(54, 48, "S"), new Longitude(68, 18, "W"), 84.2, -5.8);
        // Kodiak, Alaska, USA
        locations[9] = new WeatherInformation(new Latitude(57, 47, "N"), new Longitude(152, 24, "W"), 82.04, -19.66);

        // A loop to display all 10 weather records.
        for (int i = 0; i < 10; i++){
            System.out.println(locations[i]);
        }
    }
}