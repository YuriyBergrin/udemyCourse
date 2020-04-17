package constants;

import api.utils.UtilsMethod;

public class Constants {
    /**
     * URL = https://maps.googleapis.com/maps/api/place/findplacefromtext/output?parameters
     * where
     * domain name = https://maps.googleapis.com/
     * path = maps/api/place/
     * endpoint = findplacefromtext/
     * type output (XML or JSON)
     * parameters
     */

    public static class ServerName {
        public static String GOOGLE_PLACES_SERVER = "https://maps.googleapis.com/";
    }

    public static class Path {
        public static String GOOGLE_PLACES_PATH = "maps/api/";
    }

    public static class EndPoint {
        public static String GOOGLE_PLACES_ENDPOINT_SEARCH = "place/findplacefromtext/json";
    }

    public static String API_TOKEN = UtilsMethod.getValue("TOKEN");
}
