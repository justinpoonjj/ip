package Commands;

import TaskType.*;

/**
 * Represents an executable command in the application
 * <p>
 * Each command performs a specific action on the {@link TaskList}
 * when the {@code execute} method is called.
 */
public abstract class Command {

    /**
     * Executes the command on the given task list
     *
     * @param list The task list that the command will operate on.
     */
    public abstract void execute(TaskList list);

    /**
     * Returns whether this command signals the program to exit
     *
     * @return {@code true} if this command should terminate the progra,
     *         {@code false} otherwise
     */
    public boolean isExit() {
        return false;
    }
}