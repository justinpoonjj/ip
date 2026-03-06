package Commands;

import TaskType.TaskList;

/**
 * Represents a command that deletes a task from the {@link TaskList}
 * <p>
 * When executed, the command removes the task at the specified index
 * from the task list and prints a confirmation message to the user
 */
public class DeleteCommand extends Command{
    private final int index;

    /**
     * Creates a DeleteCommand to remove the task at the specified index
     *
     * @param index The index of the task to be deleted from the task list
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the delete command by removing the task at the given index
     * from the task list and displaying  a confirmation message.
     *
     * @param list The task list that the command will operate on.
     */
    public void execute(TaskList list) {
        System.out.println("_____________________________________________________________");
        System.out.println("Alrightttt, this task has been removed from the list:");
        System.out.println("\t[" + list.getTask(index).taskType() + "]"
                +"[" + list.getTask(index).getStatusIcon()+"] "
                + list.getTask(index).getDescription());
        System.out.println("Now you have " + (list.getSize() - 1) + " in the list :)");
        System.out.println("_____________________________________________________________");
        list.removeIndex(index);
    }
}
