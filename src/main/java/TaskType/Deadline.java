package TaskType;

/**
 *Represents a task with a deadline
 * <p>
 * A {@code Deadline} task contains a description and a due date
 * The due data is stored as part of the description string and is
 * extracted when needed for display
 */
public class Deadline extends Task {
    int separationIndex = this.description.indexOf('/');

    /**
     * Creates a Deadline task with the given description
     *
     * @param description The full description of the task
     */
    public Deadline(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for a deadline task.
     *
     * @return {@code "D"} indicating a deadline task.
     */
    @Override
    public String taskType() {
        return "D";
    }

    /**
     * Extracts and formats the deadline information from the task description.
     *
     * @return A formatted string representing the deadline
     */
    public String getDeadline() {
        String deadlineMessage = description.substring(separationIndex + 1);
        String[] splitDeadline = deadlineMessage.split(" ");
        String returnDate = deadlineMessage.substring(splitDeadline[0].length());
        return splitDeadline[0] + ":" + returnDate;
    }

    /**
     * Extracts the main task description without the deadline information
     *
     * @return The description of the task.
     */
    public String getTaskDescription() {
        return description.substring(0, separationIndex);
    }

    /**
     * Prints a confirmation message when the task is added to the list.
     *
     * @param index The index of the task in the task list.
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
     * Returns the formatted description of the task including the deadline.
     *
     * @return A string containing the task description and deadline
     */
    @Override
    public String getDescription() {
        return getTaskDescription() + "(" + getDeadline() + ")";
    }

    /**
     * Prints the task in list format with its index.
     *
     * @param index The position of the task in the task list
     */
    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
    }
}
