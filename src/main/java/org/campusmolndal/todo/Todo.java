package org.campusmolndal.todo;

import java.util.List;

public class Todo {

    private int id;
    private String text;
    private int done; // SQLite can't handle booleans 1 = done, 0 = not done
    private int assignedTo;

    public Todo(String text) {
        this.text = text;
        this.done = 0;
    }

    public Todo(String text, int done, int assignedTo) {
        this.text = text;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    public Todo(int id, String text, int done, int assignedTo) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return this.id;
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

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", done=" + (done == 1) + // ternary if to show done with true/false
                ", assignedTo=" + assignedTo +
                '}';
    }
}
