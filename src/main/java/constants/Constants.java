package constants;

import static constants.Constants.Servers.REQRES_URL;
import static constants.Constants.Path.REQRES_PATH;

public class Constants {

    public static class RunVariable {
        public static String server = REQRES_URL;
        public static String path = REQRES_PATH;
    }

    public static class Servers {
        public static String REQRES_URL = "https://reqres.in/";
        public static String GOOGLE_PLACES_URL;
    }

    public static class Path {
        public static String REQRES_PATH = "api/";
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions {
        /**
         * reqres.in/api
         **/
        public static String REQRES_GET_USERS = "users/";
        /**
         * google places
         */
        public static String GOOGLE_PLACES_PATH;
    }
}
