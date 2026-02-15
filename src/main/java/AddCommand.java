public class AddCommand extends Commands{
    private final Task t;

    public AddCommand(Task t) {
        this.t = t;
    }

    @Override
    public void execute(TaskList list){
        list.add(t);
        t.printMessage(list.getIndex() - 1);
    }
}
