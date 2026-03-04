package Commands;

import TaskType.*;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList list) {
        TaskList tasks = new TaskList();
        for (Task task : list) {
            String description = task.getDescription();
            if (description.contains(keyword)){
                tasks.add(task);
            }
        }
        tasks.printTaskList();
    }
}
