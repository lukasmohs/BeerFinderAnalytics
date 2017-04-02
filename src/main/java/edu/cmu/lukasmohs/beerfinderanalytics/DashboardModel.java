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
 *
 * @author lukasmohs
 */
public class DashboardModel {
    
    public static ArrayList<Activity> getActivities() {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        System.out.println("MyDoc:");
        MongoCredential credential = MongoCredential.createCredential("lukasmohs", "beerfinder", "sesame".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("ds137110.mlab.com",37110), Arrays.asList(credential));

        DB db = mongoClient.getDB( "beerfinder" );
        
        DBCollection coll = db.getCollection("activity");
        
        DBCursor curser = coll.find().sort(new BasicDBObject("timeStamp",-1)).limit(25);
        while(curser.hasNext()) {
            DBObject myDoc = curser.next();
            JSONTokener tokener = new JSONTokener(myDoc.toString());
            JSONObject js = new JSONObject(tokener);     
            System.out.println(myDoc.toString());
            activities.add(new Activity(js.getString("lat"),js.getString("lon"),js.getString("device"),
                new Integer(js.getString("numberOfAnswers")),js.getString("timeStamp"),new Integer(js.getString("radius"))));
        }
        

        return activities;
    }
    
}
