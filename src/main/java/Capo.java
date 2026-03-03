
import java.io.IOException;

import Commands.Command;
import Parser.Parser;
import Storage.Storage;
import TaskType.TaskList;
import Exception.CapoException;

public class Capo {

    private TaskList list;
    private final Ui ui;

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

    public void run() {
        ui.greetings();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(list);
                isExit = c.isExit();
            } catch (CapoException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Capo("data/tasks.txt").run();
    }
}