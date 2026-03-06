package Commands;

import TaskType.*;

/**
 * Represents a command that adds a {@link Task} to the {@link TaskList}
 * <p>
 * When executed, this command inserts the specified task into the task list
 * and displays a confirmation message to the user
 */

public class AddCommand extends Command {
    private final Task t;

    /**
     * Creates an AddCommand to add the specified task
     *
     * @param t The task to be added to the task list.
     */
    public AddCommand(Task t) {
        this.t = t;
    }

    /**
     * Executes the add command by adding the task to the task list
     * and printing a confirmation message
     * @param list The task list to which the task will be added
     */
    @Override
    public void execute(TaskList list){
        list.add(t);
        t.printMessage(list.getSize() - 1);
    }
}
