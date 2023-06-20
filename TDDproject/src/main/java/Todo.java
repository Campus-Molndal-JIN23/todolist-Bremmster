public class Todo {

    private int id;
    private String text;
    private int done;
    private int assignedTo;

    public Todo(int id, String text, int done, int assignedTo) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDone() {
        return this.done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }
}
