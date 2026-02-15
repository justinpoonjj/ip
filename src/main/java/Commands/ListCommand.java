package Commands;

import TaskType.*;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList list) {
        list.printTaskList();
    }
}
