import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//Assignment4
//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.


public class OpenCartSearch {
    public static void main(String[] args) {
        try {
            // Login to the website
            login("clarusway@gmail.com", "123456789");

            // Search for products
            searchProduct("Mac");
            searchProduct("iPad");
            searchProduct("Samsung");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void login(String email, String password) throws IOException {
        URL url = new URL("http://opencart.abstracta.us/index.php?route=account/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] postData = getPostDataString(parameters).getBytes();
            os.write(postData);
            os.flush();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String response;
            while ((response = br.readLine()) != null) {
                System.out.println(response);
            }
        }

        connection.disconnect();
    }

    private static void searchProduct(String keyword) throws IOException {
        URL url = new URL("http://opencart.abstracta.us/index.php?route=product/search");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("search", keyword);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] postData = getPostDataString(parameters).getBytes();
            os.write(postData);
            os.flush();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String response;
            while ((response = br.readLine()) != null) {
                System.out.println(response);
            }
        }

        connection.disconnect();
    }

    private static String getPostDataString(Map<String, String> params) throws IOException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
            result.append("&");
        }
        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}
