package Commands;

import TaskType.*;

/**
 * Represents a command that searches for tasks containing a specified keyword
 * <p>
 * When executed, this command scans through the {@link TaskList} and collects
 * all tasks whose descriptions contain the given keyword. The matching tasks
 * are then displayed to the user.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Creates a FindCommand with the specified search keyword.
     *
     * @param keyword The keyword used to search for matching tasks
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by filtering tasks in the given task list
     * whose descriptions contain the specified keyword, and printing the
     * matching tasks.
     *
     *
     * @param list The task list that the command will operate on.
     */
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
