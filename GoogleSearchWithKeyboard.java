import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//Assignment 4
( This task should be managed with keyboard actions )
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
    
public class GoogleSearchWithKeyboard {
    public static void main(String[] args) {
        try {
            // Open Google homepage in default browser
            openWebpage("https://www.google.com/");

            // Search for "Scroll Methods" using keyboard actions
            searchWithKeyboard("Scroll Methods");

        } catch (IOException | URISyntaxException | AWTException e) {
            e.printStackTrace();
        }
    }

    private static void openWebpage(String url) throws IOException, URISyntaxException {
        // Open URL in default browser
        URI uri = new URI(url);
        java.awt.Desktop.getDesktop().browse(uri);
    }

    private static void searchWithKeyboard(String searchTerm) throws AWTException {
        Robot robot = new Robot();

        // Type the search term
        type(robot, searchTerm);

        // Press Enter to perform the search
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private static void type(Robot robot, String text) {
        // Type each character in the string
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}
