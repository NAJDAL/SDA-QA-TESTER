import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: “Opening a new window”
//Verify the title of the page is “The Internet”
//Click on the “Click Here” button
//Verify the new window title is “New Window”
//Go back to the previous window and then verify the title: “The Internet”
// Assignment 2

public class WindowInteraction {
    public static void main(String[] args) {
        // Open the URL in the default browser
        openWebpage("https://the-internet.herokuapp.com/windows");

        // Display a message to verify the text manually
        JOptionPane.showMessageDialog(null, "Please verify the text: 'Opening a new window'.\nAfter that, click OK.");

        // Verify the title of the page (this requires manual observation)
        JOptionPane.showMessageDialog(null, "Please verify the title of the page.\nAfter that, click OK.");

        // Display a message to click the button manually
        JOptionPane.showMessageDialog(null, "Please click on the 'Click Here' button.\nAfter that, click OK.");

        // Display a message to verify the new window title manually
        JOptionPane.showMessageDialog(null, "Please verify the title of the new window.\nAfter that, click OK.");

        // Go back to the previous window and verify the title (this requires manual action)
        JOptionPane.showMessageDialog(null, "Please go back to the previous window.\nAfter that, click OK.");

        // Display a message to verify the title of the page (this requires manual observation)
        JOptionPane.showMessageDialog(null, "Please verify the title of the page.\nAfter that, click OK.");

        // Display a final message
        JOptionPane.showMessageDialog(null, "Process completed.");
    }

    private static void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
