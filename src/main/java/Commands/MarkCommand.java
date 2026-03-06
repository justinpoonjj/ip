package Commands;

import TaskType.*;

/**
 * Represents a command that marks a task in the {@link TaskList} as completed.
 * <p>
 * When executed, this command updates the status of the task at the specified
 * index to marked and displays a confirmation message to the user.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Creates a MarkCommand that marks the task at the specified index.
     *
     * @param index The index of the task to be marked as completed.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the mark command by marking the task at the given index as done
     * and displaying a confirmation message.
     *
     * @param list The task list that the command will operate on.
     */
    @Override
    public void execute(TaskList list) {
        list.getTask(index).setIsDone(true);
        System.out.println("_____________________________________________________________");
        System.out.println("Alrighty!! I've marked this task as done:");
        System.out.println("[" + list.getTask(index).taskType() + "]"
                + "[" + list.getTask(index).getStatusIcon() + "] "
                + list.getTask(index).getDescription());
        System.out.println("_____________________________________________________________");
    }
}
