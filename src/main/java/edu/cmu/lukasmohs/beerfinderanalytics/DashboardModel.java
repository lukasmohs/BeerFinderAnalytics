package edu.cmu.lukasmohs.beerfinderanalytics;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * This class plays the role of the model within the MVC pattern used for this Web application.
 * Whenever the Analytics web site is accessed, this model queries the third party MongoDB instance to
 * retrieve the required data, which is used in the View (JSP)
 * @author lukasmohs
 */
public class DashboardModel {
    // MongoDB credentials
    private static String MONGOUSERNAME = Credentials.getMONGOUSERNAME();
    private static String MONGODBNAME = Credentials.getMONGODBNAME();
    private static String MONGODBCOLLECTIONNAME = Credentials.getMONGODBCOLLECTIONNAME();
    private static char[] MONGOPASSWORD = Credentials.getMONGOPASSWORD();
    private static String MONGODBADRESS = Credentials.getMONGODBADRESS();
    private static int MONGOPORT = Credentials.getMONGOPORT();
    // Google Maps API key
    private static String GOOGLEMAPSAPIKEY = Credentials.getGOOGLEMAPSAPIKEY();
    
    /**
     * 
     * @return The Google Maps API key
     */    
    public static String getGoogleMapsAPIKey() {
        return GOOGLEMAPSAPIKEY;
    }
    
    /**
     * This method queries the MongoDB instance to retrieve the last 25 activities of the Android Application 
     * and saves them in Activity objects
     * @return List of Activity objects
     */
    public static ArrayList<Activity> getActivities() {
        ArrayList<Activity> activities = new ArrayList<>();
        // Create credential object based on usernamane, password and DB name
        MongoCredential credential = MongoCredential.createCredential(MONGOUSERNAME,MONGODBNAME , MONGOPASSWORD);
        // Initialize the MongoDB client with a remote instance by using address, port and the credentials
        MongoClient mongoClient = new MongoClient(new ServerAddress(MONGODBADRESS,MONGOPORT), Arrays.asList(credential));
        DB db = mongoClient.getDB(MONGODBNAME);
        // Get the MongoDB collection
        DBCollection coll = db.getCollection(MONGODBCOLLECTIONNAME);
        // Query for the last 25 entries by sorting on a timestamp and limiting the result to 25
        DBCursor curser = coll.find().sort(new BasicDBObject("timeStamp",-1)).limit(25);
        // Iterate over all results
        while(curser.hasNext()) {
            // Get the next item as DBObject
            DBObject myDoc = curser.next();
            JSONTokener tokener = new JSONTokener(myDoc.toString());
            JSONObject js = new JSONObject(tokener);     
            // Parse the JSON into an Activity object and add it to the returned list
            activities.add(new Activity(js.getString("lat"),js.getString("lon"),js.getString("device"), js.getString("os"),
                new Integer(js.getString("numberOfAnswers")),js.getString("timeStamp"),new Integer(js.getString("radius"))));
        }
        // Return all retrieved Activitie
        return activities;
    }
    
    
    /**
     * Calculates the average time between two requests in minutes
     * @return a String formatted representation of the average time in minutes
     */
    public static String getAverageTimeBetweenRequest() {
        long sum = 0;
        long last = 0;
        long count = 0;
        // Go through all activities
        for(Activity a : getActivities()){
            if(last != 0) {
                // Except for the first element, calculate the difference of the timestamps and add it to sum
                sum = sum + (last - new Long(a.getTimeStamp()));
                count ++;
            }
            // Assign the last value the current value of the current activity
            last = new Long(a.getTimeStamp());
        }
        // calculate the average and convert it to minutes
        return (((sum/count) / (1000*60)) % 60) + " Minutes";
    }
    
    /**
     * This method calculates the average search radius
     * @return a String representation of the calculated average
     */
    public static String getAverageRadius(){
        long sum = 0;
        long count = 0;
        // Go through all activities
        for(Activity a : getActivities()){
            // Add all radiuses together
            sum += a.getRadius();
            count++;
        }
        // Return average by deviding total by the number
        return sum/count + " Meters";
    }
    
    /**
     * This method calculates the average number of returned answers by the Yelp API
     * @return a String representation of the calculated average
     */
    public static String getAverageNumberOfAnswers() {
        long sum = 0;
        long count = 0;
        // Go through all activities
        for(Activity a : getActivities()){
            // Add all number of answers together
            sum += a.getNumberOfAnswers();
            count++;
        }
        // Return average by deviding total by the number
        return sum/count + " Bars";
    }
    
}
