
import java.io.IOException;

import Commands.Command;
import Parser.Parser;
import Storage.Storage;
import TaskType.TaskList;
import Exception.CapoException;

/**
 * Represents the main entry point of the CAPO application.
 * <p>
 * A {@code Capo} object manages the application's user interface,
 * task list, and storage. It is responsible for loading saved tasks
 * at startup and running the main command loop.
 */
public class Capo {
    private TaskList list;
    private final Ui ui;

    /**
     * Creates a CAPO application using the specified storage file path.
     * <p
     * If previously saved tasks cannot be loaded, an empty task list is created
     * and an error message is shown to user.
     *
     * @param filepath The path of the file used for task storage
     */
    public Capo(String filepath){
        ui = new Ui();
        Storage storage = new Storage(filepath);
        try {
            list = storage.loadFile();
        } catch (CapoException | IOException e) {
            ui.showLoadingError();
            list = new TaskList();
        }
    }

    /**
     * Starts the CAPO application.
     * <p>
     * This method displays the greeting message and repeatedly reads,
     * parses, and executes user commands until an exit command is given.
     */
    public void run() {
        ui.greetings();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(list);
                isExit = c.isExit();
            } catch (CapoException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Starts the CAPO prgram.
     *
     * @param args Command-line arguments supplied to the program.
     */
    public static void main(String[] args) {
        new Capo("data/Capo.txt").run();
    }
}