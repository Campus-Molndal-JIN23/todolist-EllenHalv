package org.campusmolndal;

public class Todo {

    private int id;
    private String text;
    private boolean done;

    public Todo() {
    }

    public Todo (int id, String task, boolean done) {
        this.id = id;
        this.text = task;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Text: " + text + ", Done: " + done;
    }
}
