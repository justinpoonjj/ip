public class Task {
    protected String description;
    protected boolean isDone;

    public void setIsDone(boolean value) {
        this.isDone = value;
    }

    public String getDescription() {
        return description;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }
}
