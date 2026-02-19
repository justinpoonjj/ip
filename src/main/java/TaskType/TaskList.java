package TaskType;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;
    private int size;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(Task t) {
        tasks.add(t);
        size++;
    }

    public int getSize() {
        return size;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void printTaskList() {
        System.out.println("_____________________________________________________________");
        System.out.println("Here are your list of tasks");
        for (int i = 0; i < size; i++) {
            tasks.get(i).printList(i);
        }
        System.out.println("_____________________________________________________________");
    }

    public void removeIndex(int index) {
        tasks.remove(index);
        this.size--;
    }
}
