package Commands;

import TaskType.*;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list) {
        list.getTask(index).setIsDone(true);
        System.out.println("_____________________________________________________________");
        System.out.println("Alrighty!! I've marked this task as done:");
        System.out.println("[" + list.getTask(index).taskType() + "]" + "[" + list.getTask(index).getStatusIcon() + "] " + list.getTask(index).getDescription());
        System.out.println("_____________________________________________________________");

    }
}
