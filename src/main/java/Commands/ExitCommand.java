package Commands;

import java.io.IOException;

import TaskType.*;
import Storage.Storage;

/**
 * Represents a command that terminates the program
 * <p>
 * When executed, this command displays a goodbye message to the user
 * and signals that the application should exit
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit command by displaying a farewell message
     * and saves the current list in to the data storage
     *
     * @param list The task list that the command will operate on.
     */
    @Override
    public void execute (TaskList list) {
        try {
            Storage storage = new Storage("./data/Capo.txt");
            storage.saveFile(list);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");
    }

    /**
     * Indicates that this command should terminate the program
     *
     * @return {@code true} since this command signals program termination.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
