package Storage;

import Parser.Parser;
import TaskType.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Scanner;
import Exception.CapoException;

/**
 * Handles reading from and writing to the application's storage file.
 * <p>
 * The {@code Storage} class is responsible for persisting tasks to a file
 * and reconstructing them when the program starts
 */
public class Storage {
    private final String filePath;
    private final File file;

    /**
     * Creates a Storage object with the specified file path
     *
     * @param filePath The path of the file used to store task data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    /**
     * Returns the completion status of the given task as an integer.
     *
     * @param t The task whose status is being checked.
     * @return {@code 1} if the task is completed, otherwise {@code 0}.
     */
    public int Status(Task t) {
        if (t.getStatusIcon().equals("X")) {
            return 1;
        }
        return 0;
    }

    /**
     * Converts an event task description into the storage format.
     *
     * @param input The original event description string.
     * @return A formatted string representing the event for storage.
     */
    public String parseEvent(String input) {
        int open = input.indexOf('(');
        int close = input.indexOf(')',open);

        String description = input.substring(0,open).trim();
        String inside = input.substring(open+1,close).trim();
        inside = inside.substring("from:".length()).trim();
        int toIndex = inside.indexOf("to:");
        String from = inside.substring(0,toIndex).trim();
        String to = inside.substring(toIndex+3).trim();
        return description+ " /from " +from+ " /to " +to;
    }

    /**
     * Converts a deadline task description into the storage format.
     *
     * @param input The original deadline description string.
     * @return A formatted string representing the deadline for storage
     */
    public String parseDeadline(String input) {
        int open = input.indexOf('(');
        int close = input.indexOf(')',open);
        String description = input.substring(0,open).trim();
        String inside = input.substring(open+1,close).trim();
        String by = inside.substring("by:".length());
        return description + " /by " +by;
    }

    /**
     * Converts the given task list into a string suitable for file storage.
     *
     * @param list The task list to be written to the storage file.
     * @return A formatted string representing all tasks in the list.
     */
    public String fileWrite(TaskList list) {
        StringBuilder content = new StringBuilder();
        for (Task t : list) {
            content.append(t.taskType());
            content.append(" | ");
            content.append(Status(t));
            content.append(" | ");
            switch (t.taskType()) {
            case "T":
                content.append(t.getDescription());
                break;
            case "D":
                content.append(parseDeadline(t.getDescription()));
                break;
            case "E":
                content.append(parseEvent(t.getDescription()));
                break;
            }

            content.append("\n");
        }
        return content.toString();
    }

    /**
     * Loads tasks from the storage file and reconstructs a {@link TaskList}.
     *
     * @return A task list containing tasks loaded from storage.
     * @throws CapoException If the stored task format is invalid.
     * @throws IOException If an error occurs while reading the file.
     */
    public TaskList loadFile() throws CapoException, IOException {
        TaskList list = new TaskList();

        if (!file.exists()){
            File parent = file.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }
            file.createNewFile();
            return list;
        }

        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            Task t = Parser.parseStoredFile(line);
            list.add(t);
        }
        s.close();
        return list;
    }

    /**
     * Saves the given task list to the storage file
     *
     * @param list The task list to be written to the file.
     * @throws IOException If an error occurs while writing to the file.
     */
    public void saveFile(TaskList list) throws IOException {
        File parent = file.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        try (FileWriter fw = new FileWriter(filePath)) {
            String content = fileWrite(list);
            fw.write(content);
        }
    }
}
