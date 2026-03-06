import java.util.Scanner;

/**
 * Handles all user interaction for the CAPO application.
 * <p>
 * The {@code Ui} class is responsible for displaying messages to the user
 * and reading commands from standard input.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Creates a UI object and initializes the input scanner.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints a horizontal line separator.
     */
    public void showLine() {
        System.out.println("_____________________________________________________________");
    }

    /**
     * Displays the greeting message when the application starts.
     */
    public void greetings() {
        showLine();
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        showLine();
    }

    /**
     * Reads a command entered by the user.
     *
     * @return The command string entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays error message when the saved task file cannot be loaded
     */
    public void showLoadingError() {
        showLine();
        System.out.println("OOPS!!! I couldn't load your save file!");
        System.out.println("Starting with an empty task list instead.");
        showLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be shown.
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
