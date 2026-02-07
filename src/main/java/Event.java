public class Event extends Task{
    private final int separationIndex = description.indexOf('/');
    private final String TaskDescription = this.description.substring(0,separationIndex);

    public Event(String description) {
        super(description);
    }

    @Override
    public String taskType() {
        return "E";
    }

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

    @Override
    public void printMessage(int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        System.out.println("_____________________________________________________________");
    }

    @Override
    public void printList(int index) {
        System.out.println((index+1) + "." + "[" + taskType() + "]"+"["+ getStatusIcon()+"] " + getDescription());
    }

    @Override
    public String getDescription() {
        return TaskDescription + "(" + getTimeRange() + ")";
    }
}
