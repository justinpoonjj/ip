public class Task {
    protected String description;
    protected boolean isDone;

    public void setIsDone(boolean value) {
        this.isDone = value;
    }

    public String getDescription() {
        return description;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    public void printList(int index) {
        System.out.println((index+1) + "." + description);
    }

    public String taskType() {
        return "Task";
    }
}
