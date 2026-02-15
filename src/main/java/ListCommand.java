public class ListCommand extends Commands {
    @Override
    public void execute(TaskList list) {
        list.printTaskList();
    }
}
