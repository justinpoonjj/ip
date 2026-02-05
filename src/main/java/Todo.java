public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String taskType() {
        return "T";
    }

    @Override
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + this.taskType() + "]"+"["+ this.getStatusIcon()+"] " + this.getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + this.taskType() + "]"+"["+ this.getStatusIcon()+"] " + this.getDescription());
    }
}
