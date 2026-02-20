package Commands;

import TaskType.*;

public class AddCommand extends Command {
    private final Task t;

    public AddCommand(Task t) {
        this.t = t;
    }

    @Override
    public void execute(TaskList list){
        list.add(t);
        t.printMessage(list.getSize() - 1);
    }
}
