public class Deadline extends Task{
    int separationIndex = this.description.indexOf('/');

    public Deadline(String description) {
        super(description);
    }

    @Override
    public String taskType() {
        return "D";
    }

    public String getDeadline() {
        String deadlineMessage = description.substring(separationIndex + 1);
        String[] splitDeadline = deadlineMessage.split(" ");
        String returnDate = deadlineMessage.substring(splitDeadline[0].length());
        return splitDeadline[0] + ":" + returnDate;
    }

    public String getTaskDescription() {
        return description.substring(0, separationIndex);
    }

    @Override
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    @Override
    public String getDescription() {
        return getTaskDescription() + "(" + getDeadline() + ")";
    }

    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
    }
}
