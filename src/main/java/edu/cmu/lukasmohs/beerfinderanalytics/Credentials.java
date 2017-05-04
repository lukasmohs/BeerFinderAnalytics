/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.lukasmohs.beerfinderanalytics;

/**
 *
 * @author lukasmohs
 */
public class Credentials {
    private static String MONGOUSERNAME = "lukasmohs";
    private static String MONGODBNAME = "beerfinder";
    private static String MONGODBCOLLECTIONNAME = "activity";
    private static char[] MONGOPASSWORD = "sesame".toCharArray();
    private static String MONGODBADRESS = "ds137110.mlab.com";
    private static int MONGOPORT = 37110;
    // Google Maps API key
    private static String GOOGLEMAPSAPIKEY = "AIzaSyBRFczRVk2JzEpzyyYdlwoonvjDu3ul2Cc";

    public static String getMONGOUSERNAME() {
        return MONGOUSERNAME;
    }

    public static String getMONGODBNAME() {
        return MONGODBNAME;
    }

    public static String getMONGODBCOLLECTIONNAME() {
        return MONGODBCOLLECTIONNAME;
    }

    public static char[] getMONGOPASSWORD() {
        return MONGOPASSWORD;
    }

    public static String getMONGODBADRESS() {
        return MONGODBADRESS;
    }

    public static int getMONGOPORT() {
        return MONGOPORT;
    }

    public static String getGOOGLEMAPSAPIKEY() {
        return GOOGLEMAPSAPIKEY;
    }
    
    
}
