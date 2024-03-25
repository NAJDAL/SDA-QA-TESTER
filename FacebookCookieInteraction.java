import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

//Assignment 5
/*   Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
*/

public class FacebookCookieInteraction {
    public static void main(String[] args) {
        try {
            // Go to URL: http://facebook.com
            URL url = new URL("http://facebook.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get cookies
            Map<String, List<String>> cookies = connection.getHeaderFields();
            System.out.println("Cookies:");
            for (Map.Entry<String, List<String>> entry : cookies.entrySet()) {
                if (entry.getKey() != null && entry.getKey().equalsIgnoreCase("Set-Cookie")) {
                    System.out.println(entry.getValue());
                }
            }

            // Add a cookie
            connection.setRequestProperty("Cookie", "custom_cookie_name=custom_cookie_value");

            // Delete a cookie named "cookie_name"
            connection.setRequestProperty("Cookie", "");

            // Delete all cookies
            connection.setRequestProperty("Cookie", "");

            // Close the connection
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
