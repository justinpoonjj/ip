public abstract class Commands {
    public abstract void execute(TaskList list);
    public boolean isExit() {
        return false;
    }
}