package Commands;

import TaskType.*;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index){
        this.index = index;
    }

    @Override
    public void execute(TaskList list) {
        list.getTask(index).setIsDone(false);
        System.out.println("_____________________________________________________________");
        System.out.println("OK!! This task shall be marked as not done yet");
        System.out.println("[" + list.getTask(index).taskType() + "]"+"[" + list.getTask(index).getStatusIcon()+"] " + list.getTask(index).getDescription());
        System.out.println("_____________________________________________________________");
    }
}
