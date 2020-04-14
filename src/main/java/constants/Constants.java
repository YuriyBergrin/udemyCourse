package constants;

import static constants.Constants.Servers.JSON_PLACEHOLDER_URL;
import static constants.Constants.Servers.REQRES_URL;
import static constants.Constants.Servers.REQUEST_BIN_URL;
import static constants.Constants.Path.JSON_PLACEHOLDER_PATH;

public class Constants {

    public static class RunVariable {
        public static String server = JSON_PLACEHOLDER_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String REQRES_URL = "https://reqres.in/";
        public static String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String REQUEST_BIN_URL = "https://enqhtc12qo59.x.pipedream.net";
        public static String GOOGLE_PLACES_URL;
    }

    public static class Path {
        public static String REQRES_PATH = "api/";
        public static String JSON_PLACEHOLDER_PATH = "";
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

        /**
         * json placeholder
         */
        public static String JSON_PLACEHOLDER_GET_POSTS = "comments/";
        public static String JSON_PLACEHOLDER_PUT_POST = "posts/1";
        public static String JSON_PLACEHOLDER_POST_DELETE = "posts/1";
        public static String JSON_PLACEHOLDER_POST_POST = "posts/";
    }
}
