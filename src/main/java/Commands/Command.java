package Commands;

import TaskType.*;

public abstract class Command {
    public abstract void execute(TaskList list);
    public boolean isExit() {
        return false;
    }
}