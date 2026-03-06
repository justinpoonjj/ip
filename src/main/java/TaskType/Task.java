package TaskType;

/**
 * Represents a generic task in the task list
 * <p>
 * A {@code Task} contains a description and a completion status
 * Specific task types such as {@link Deadline}, {@link Event}, and {@link Todo}
 * extend this class and provide their own task-specific behavior
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Sets the completion status of the task
     *
     * @param value {@code true} if the task is completed, else {@code false}
     */
    public void setIsDone(boolean value) {
        this.isDone = value;
    }

    /**
     * Returns the description of the task
     *
     * @return The task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Creates a task with the given description
     * The task is initially marked as not completed
     *
     * @param description The description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon representing whether the task is completed.
     *
     * @return {@code "X"} if the task is completed, otherwise a blank space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Prints a confirmation message when the task is added to the task list.
     *
     * @param index The index of the task in the task list
     */
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"
                + "["+ getStatusIcon()+"] "
                + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    /**
     * Prints the task in list format
     *
     * @param index The position of the task in task list
     */
    public void printList(int index) {
        System.out.println((index+1) + "." + description);
    }

    /**
     * Returns the identifier of the task type
     * Subclasses override this method to return their specific type
     *
     * @return The task type identifier
     */
    public String taskType() {
        return "Task";
    }
}
