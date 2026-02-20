package Commands;

import TaskType.TaskList;

public class DeleteCommand extends Command{
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList list) {
        System.out.println("_____________________________________________________________");
        System.out.println("Alrightttt, this task has been removed from the list:");
        System.out.println("\t[" + list.getTask(index).taskType() + "]"+"[" + list.getTask(index).getStatusIcon()+"] " + list.getTask(index).getDescription());
        System.out.println("Now you have " + (list.getSize() - 1) + " in the list :)");
        System.out.println("_____________________________________________________________");
        list.removeIndex(index);
    }
}
