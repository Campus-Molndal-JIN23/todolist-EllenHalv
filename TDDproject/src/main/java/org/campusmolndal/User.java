package org.campusmolndal;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private int id;
    private ArrayList<Todo> todos;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.todos = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Todo> getTodos() {
        return this.todos;
    }
}
