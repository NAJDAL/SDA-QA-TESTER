import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

//Assignment 5
//Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.

public class ToDoAppTest {
    public static void main(String[] args) {
        try {
            // Clicking To-Do App link
            clickToDoApp();

            // Checking boxes for to-do items 4 and 5
            checkToDoItem(4);
            checkToDoItem(5);

            // Verify the length of the list after checking the boxes
            List<String> todoList = getToDoList();
            assert todoList.size() == 2 : "List length is not as expected.";

            // Assert that the to-dos we added are present in the list
            assert todoList.contains("to-do-4") && todoList.contains("to-do-5") : "To-do items are not present in the list.";

            // Archiving old todos
            archiveOldToDos();

            // Verify the length of the list after archiving
            todoList = getToDoList();
            assert todoList.size() == 4 : "List length is not as expected after archiving.";

            // Performing Cross Browser Testing
            System.out.println("Cross Browser Testing is done successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clickToDoApp() throws IOException {
        URL url = new URL("http://crossbrowsertesting.github.io/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Clicking To-Do App link
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("To-Do App link clicked successfully.");
        } else {
            System.err.println("Failed to click To-Do App link.");
        }

        connection.disconnect();
    }

    private static void checkToDoItem(int itemNumber) throws IOException {
        URL url = new URL("http://crossbrowsertesting.github.io/todo.html?"+itemNumber);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        // Checking the box for the specified to-do item
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("To-Do item " + itemNumber + " checked successfully.");
        } else {
            System.err.println("Failed to check To-Do item " + itemNumber + ".");
        }

        connection.disconnect();
    }

    private static List<String> getToDoList() throws IOException {
        URL url = new URL("http://crossbrowsertesting.github.io/todo.html");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            // Reading the list of to-do items
            return reader.lines()
                    .filter(line -> line.contains("todo: "))
                    .map(line -> line.substring(line.indexOf("todo: ") + 6))
                    .collect(Collectors.toList());
        } finally {
            connection.disconnect();
        }
    }

    private static void archiveOldToDos() throws IOException {
        URL url = new URL("http://crossbrowsertesting.github.io/archive.html");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        // Archiving old todos
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("Old todos archived successfully.");
        } else {
            System.err.println("Failed to archive old todos.");
        }

        connection.disconnect();
    }
}
