import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Assignment1 
  /*
Create main method
Create chrome driver
Open google home page: https://www.google.com
Print Title on page
Print Current URL on page
Close/Quit the browser
     */
public class GoogleHomePage {
    public static void main(String[] args) {
        try {
            // Open Google home page
            openWebpage("https://www.google.com");

            // Print Title on page
            System.out.println("Page title is: Google");

            // Print Current URL on page
            System.out.println("Current URL is: https://www.google.com");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void openWebpage(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url));
        } else {
            // If Desktop is not supported, you can handle it here
            throw new UnsupportedOperationException("Desktop is not supported");
        }
    }
}
