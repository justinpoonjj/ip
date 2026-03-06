package TaskType;

/**
 * Represents a task that occurs within a specific time range
 * <p>
 * An {@code Event} task contains a description along with a start
 * and end time. The time information is extracted from the task
 * description and formatted for display
 */
public class Event extends Task {
    private final int separationIndex = description.indexOf('/');
    private final String TaskDescription = this.description.substring(0,separationIndex);

    /**
     * Creates an Event task with the given description
     *
     * @param description The full description of the event
     */
    public Event(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for an event task.
     *
     * @return {@code "E"} indicating an event task.
     */
    @Override
    public String taskType() {
        return "E";
    }

    /**
     * Extracts and formats the time range information from the task description.
     *
     * @return A formatted string representing the event time range.
     */
    public String getTimeRange() {
        String Separation = this.description.substring(separationIndex + 1);
        int secondSeparationIndex = Separation.indexOf('/');
        String firstHalf = Separation.substring(0,secondSeparationIndex);
        String secondHalf = Separation.substring(secondSeparationIndex + 1);
        String[] splitFirstHalf = firstHalf.split(" ");
        String[] splitSecondHalf = secondHalf.split(" ");
        String startTime = firstHalf.substring(splitFirstHalf[0].length());
        String endTime = secondHalf.substring(splitSecondHalf[0].length());
        return splitFirstHalf[0] + ":" + startTime + splitSecondHalf[0] + ":" + endTime;
    }

    /**
     * Prints a confirmation message when the event task is added
     *
     * @param index The index of the task in the task list
     */
    @Override
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"
                + "[" + getStatusIcon() + "] " + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    /**
     * Prints the event task in list format with its index.
     *
     * @param index The position of the task in the task list.
     */
    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + taskType() + "]"
                + "[" + getStatusIcon()+ "] " + getDescription());
    }

    /**
     * Returns the formatted description of the event task including
     * its time range
     *
     * @return A string containing the task description and time range
     */
    @Override
    public String getDescription() {
        return TaskDescription + "(" + getTimeRange() + ")";
    }
}
