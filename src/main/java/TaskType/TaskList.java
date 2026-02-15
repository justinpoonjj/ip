package TaskType;

public class TaskList {
    private final Task[] tasks;
    private int index;

    public TaskList() {
        this.tasks = new Task[100];
    }

    public void add(Task t) {
        tasks[index] = t;
        index++;
    }

    public int getIndex() {
        return index;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public void printTaskList() {
        System.out.println("_____________________________________________________________");
        System.out.println("Here are your list of tasks");
        for (int i = 0; i < index; i++) {
            tasks[i].printList(i);
        }
        System.out.println("_____________________________________________________________");
    }
}
