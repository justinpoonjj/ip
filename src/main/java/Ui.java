import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showLine() {
        System.out.println("_____________________________________________________________");
    }

    public void greetings() {
        showLine();
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLoadingError() {
        showLine();
        System.out.println("OOPS!!! I couldn't load your save file!");
        System.out.println("Starting with an empty task list instead.");
        showLine();
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
