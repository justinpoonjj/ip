package TaskType;

/**
 * Represents a simple task without a deadline or time constraint.
 * <p>
 * A {@code Todo} task only contains a description and completion status
 * It extends the {@link Task} class and identifies itself with the task type "T"
 */
public class Todo extends Task {

    /**
     * Creates a Todo task with the given description
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for a todo task.
     *
     * @return {@code "T"} indicating a todo task.
     */
    @Override
    public String taskType() {
        return "T";
    }

    /**
     * Prints a confirmation message when the todo task is added to the task list
     *
     * @param index The index of the task in the task list
     */
    @Override
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    /**
     * Prints the todo task in list format with it index.
     *
     * @param index The position of the task in task list
     */
    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + taskType() + "]"
                + "[" + getStatusIcon()+ "] " + getDescription());
    }
}
