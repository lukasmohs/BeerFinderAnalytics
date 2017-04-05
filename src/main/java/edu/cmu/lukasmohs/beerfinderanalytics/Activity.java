package edu.cmu.lukasmohs.beerfinderanalytics;

/**
 *
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

    public Activity(String latitude, String longitude, String device, String os, int numberOfAnswers, String timeStamp, int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.device = device;
        this.numberOfAnswers = numberOfAnswers;
        this.timeStamp = timeStamp;
        this.radius = radius;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDevice() {
        return device;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getRadius() {
        return radius;
    }
    
    public String getOs() {
        return os;
    }
    
}
