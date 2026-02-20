
import java.io.IOException;
import java.util.Scanner;

import Commands.Command;
import Parser.Parser;
import TaskType.TaskList;
import Exception.CapoException;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        // int index = 0;
        Scanner input = new Scanner(System.in);
        Storage s = new Storage("./data/Capo.txt");
        try {
            TaskList list = s.loadFile();
            greetings();
            while (true) {
                try {
                    userInput = input.nextLine();
                    Command cmd = Parser.parse(userInput);
                    cmd.execute(list);
                    if (cmd.isExit()) {
                        s.saveFile(list);
                        break;
                    }
                } catch (CapoException | IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (CapoException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void greetings() {
        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
    }
}