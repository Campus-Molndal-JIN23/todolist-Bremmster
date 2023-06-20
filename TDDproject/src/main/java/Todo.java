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
}
