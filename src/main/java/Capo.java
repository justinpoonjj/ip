// import java.text.NumberFormat;
import java.util.Scanner;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        // int index = 0;
        TaskList list = new TaskList();
        Scanner input = new Scanner(System.in);
        greetings();
        while (true) {
            try {
                userInput = input.nextLine();
                Commands cmd = Parser.parse(userInput);
                if (cmd == null) {
                    continue;
                }
                cmd.execute(list);
                if (cmd.isExit()) {
                    break;
                }
            }catch (CapoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void greetings() {
        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
    }
}