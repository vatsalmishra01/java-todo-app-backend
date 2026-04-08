
package com.vatsal.todo_app;
//creating a class named Todo
public class Todo {
    private int id;
    private String title;
    private boolean completed;

    //default constructor
    public Todo() {
    }

    //parameterized constructor
    public Todo(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //getters and setters to access private variables
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}