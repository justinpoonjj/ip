package Commands;

import TaskType.*;

/**
 * Represents a command that marks a task in the {@link TaskList} as incomplete
 * <p>
 * When executed, the command updates the status of the task at the specified
 * index as not done and displays a confirmation message to the user.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Creates an UnmarkCommand that marks the task at the specified index as incomplete
     *
     * @param index The index of the task to be marked as not completed.
     */
    public UnmarkCommand(int index){
        this.index = index;
    }

    /**
     * Executes the unmark command by updating the task status to not done
     * and displaying a confirmation message
     *
     * @param list The task list that the command will operate on.
     */
    @Override
    public void execute(TaskList list) {
        list.getTask(index).setIsDone(false);
        System.out.println("_____________________________________________________________");
        System.out.println("OK!! This task shall be marked as not done yet");
        System.out.println("[" + list.getTask(index).taskType() + "]"
                + "[" + list.getTask(index).getStatusIcon() + "] "
                + list.getTask(index).getDescription());
        System.out.println("_____________________________________________________________");
    }
}
