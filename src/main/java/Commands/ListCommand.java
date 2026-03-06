package Commands;

import TaskType.*;

/**
 * Represents a command that display all tasks in the {@link TaskList}.
 * <p>
 * When executed, this command prints the current list of tasks to the user.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all tasks in the task list.
     *
     * @param list The task list that the command will operate on.
     */
    @Override
    public void execute(TaskList list) {
        list.printTaskList();
    }
}
