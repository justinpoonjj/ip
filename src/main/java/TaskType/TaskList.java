package TaskType;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a list of {@link Task} objects.
 * <p>
 * The {@code TaskList} managers the collection of tasks in the application.
 * It provides operations to add, retrieve, remove, and display tasks.
 * The class implements {@link Iterable} to allow iteration over tasks.
 */
public class TaskList implements Iterable<Task> {
    private final ArrayList<Task> tasks;
    private int size;

    /**
     * Creates an empty task list
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param t The task to be added
     */
    public void add(Task t) {
        tasks.add(t);
        size++;
    }

    /**
     * Returns the number of tasks in the list
     *
     * @return The size of the task list
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index The position of the task in the list.
     * @return The task at the specified index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Returns an iterator over the tasks in the list
     *
     * @return An iterator for traversing the tasks.
     */
    public Iterator<Task> iterator(){
        return tasks.iterator();
    }

    /**
     * Prints all tasks currently stored in the task list.
     */
    public void printTaskList() {
        System.out.println("_____________________________________________________________");
        System.out.println("Here are your list of tasks");
        for (int i = 0; i < size; i++) {
            getTask(i).printList(i);
        }
        System.out.println("_____________________________________________________________");
    }

    /**
     * Removes the task at the specified index from the list
     *
     * @param index The index of the task to be removed.
     */
    public void removeIndex(int index) {
        tasks.remove(index);
        this.size--;
    }
}
