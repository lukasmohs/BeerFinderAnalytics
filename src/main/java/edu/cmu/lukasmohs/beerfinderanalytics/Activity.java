package edu.cmu.lukasmohs.beerfinderanalytics;

/**
 * This entity class models the requests of clients into activities
 * @author lukasmohs
 */
public class Activity {
   
    private String latitude;
    private String longitude;
    private String os;
    private String device;
    private int numberOfAnswers;
    private String timeStamp;
    private int radius;

    /**
     * Constructor
     * @param latitude
     * @param longitude
     * @param device
     * @param os
     * @param numberOfAnswers
     * @param timeStamp
     * @param radius 
     */
    public Activity(String latitude, String longitude, String device, String os, int numberOfAnswers, String timeStamp, int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.device = device;
        this.numberOfAnswers = numberOfAnswers;
        this.timeStamp = timeStamp;
        this.radius = radius;
        this.os = os;
    }

    /**
     * 
     * @return the latitude of the  request as a String
     */
    public String getLatitude() {
        return latitude;
    }
    /**
     * 
     * @return the longitude of the  request as a String
     */
    public String getLongitude() {
        return longitude;
    }
    /**
     * 
     * @return the device type of the  request as String
     */
    public String getDevice() {
        return device;
    }
    /**
     * 
     * @return the number of answer the service could provide to the request as an int
     */
    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }
    /**
     * 
     * @return timestamp of the  request as a String
     */
    public String getTimeStamp() {
        return timeStamp;
    }
    /**
     * 
     * @return the specified search radius of the  request as an int
     */
    public int getRadius() {
        return radius;
    }
    /**
     * 
     * @return the Operating System specification of the device that did the request as a String
     */
    public String getOs() {
        return os;
    }
    
}
