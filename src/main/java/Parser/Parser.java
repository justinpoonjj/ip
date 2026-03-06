package Parser;

import Commands.*;
import TaskType.*;
import Exception.CapoException;
import Storage.Storage;

/**
 * Parses user input and converts it into executable {@link Command} objects
 * <p>
 * This class is responsible for interpreting commands entered by the user
 * and reconstructing tasks from saved storage data
 */
public class Parser {

    /**
     * Parses a user input string and returns the corresponding {@link Command}
     *
     * @param userInput The full command entered by the user.
     * @return The {@link Command} object representing the user instruction.
     * @throws CapoException If the command format is invalid or not recognised.
     */
    public static Command parse (String userInput) throws CapoException {
        String[] split = userInput.split(" ");
        String keyword = split[0].toLowerCase();
        Task t;

        switch(keyword) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "find":
            String find_word = split[1];
            return new FindCommand(find_word);
        case "mark":
            if (split.length < 2) {
                throw new CapoException("Please specify the task number");
            }
            int markIndex = Integer.parseInt(split[1]) - 1;
            return new MarkCommand(markIndex);
        case "unmark":
            if (split.length < 2) {
                throw new CapoException("Please specify the task number");
            }
            int unmarkIndex = Integer.parseInt(split[1]) - 1;
            return new UnmarkCommand(unmarkIndex);
        case "delete":
            if (split.length < 2) {
                throw new CapoException("Please specify the task number");
            }
            int deleteIndex = Integer.parseInt(split[1]) - 1;
            return new DeleteCommand(deleteIndex);
        case "todo":
            if (split.length < 2) {
                throw new CapoException("Please follow the format\n todo [task name]");
            }
            t = new Todo(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        case "deadline":
            if (split.length < 2 || !userInput.contains("/by")) {
                throw new CapoException("Please follow the format\n deadline [task name] /by [date]");
            }
            t = new Deadline(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        case "event":
            if (split.length < 2 || !userInput.contains("/from") || !userInput.contains("to")) {
                throw new CapoException("Please follow the format\n event [task name] /from [time] /to [time]");
            }
            t = new Event(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        default:
            throw new CapoException("I'm sorry there is no such command. Please try either:\n- todo\n- deadline\n- event");
        }
    }

    /**
     * Parses a line from the stored data file and reconstructs the corresponding {@link Task}
     *
     * @param input A line from the save file representing a stored task
     * @return The reconstructed {@link Task} object
     * @throws CapoException If the stored format is invalid or the task type is unknown.
     */
    public static Task parseStoredFile(String input) throws CapoException {
        String[] split = input.split("\\|");
        if (split.length < 3){
            throw new CapoException("Invalid save line: " + input);
        }
        String type = split[0].trim();
        String isDone = split[1].trim();
        String description = split[2].trim();
        Task t;
        //description may want to change to the orginal user format
        switch(type) {
        case "T":
            t = new Todo(description);
            break;
        case "D":
            t = new Deadline(description);
            break;
        case"E":
            t = new Event(description);
            break;
        default:
            throw new CapoException("Unknown task type: " + type);
        }
        if (isDone.equals("1")) {
            t.setIsDone(true);
        }
        return t;
    }
}
