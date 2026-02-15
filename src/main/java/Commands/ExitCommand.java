package Commands;

import TaskType.*;

public class ExitCommand extends Command {
    @Override
    public void execute (TaskList list) {
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
