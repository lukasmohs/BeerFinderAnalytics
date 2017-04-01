package edu.cmu.lukasmohs.beerfinderanalytics;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lukasmohs
 */
public class DashboardModel {
    
    public static String getActivities() {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        System.out.println("MyDoc:");
        MongoCredential credential = MongoCredential.createCredential("lukasmohs", "beerfinder", "sesame".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("ds137110.mlab.com",37110), Arrays.asList(credential));

        DB db = mongoClient.getDB( "beerfinder" );
        
        DBCollection coll = db.getCollection("activity");
        
        DBObject myDoc = coll.findOne();
        
        System.out.println(myDoc);
        
        return myDoc.toString();
    }
    
}
