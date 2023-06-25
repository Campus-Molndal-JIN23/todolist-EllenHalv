package org.campusmolndal;

import java.util.ArrayList;

/** class to help handle database operations
 *
 */
public class TodoDatabaseFacade {

    private TodoDatabase todoDatabase;

    public TodoDatabaseFacade(TodoDatabase todoDatabase) {
        this.todoDatabase = todoDatabase;
    }

    public Todo getTodoById(int id) {
        if (id <= 0) {
            return null;
        }
        try {
            Todo todo = todoDatabase.getTodoById(id);
            return todo;
        } catch (Exception e) {
            System.err.println("Error retrieving todo with ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Todo> getAllTodos() {
        try {
            ArrayList<Todo> todos = todoDatabase.getAllTodos();
            return todos;
        } catch (Exception e) {
            System.err.println("Error retrieving all todos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void addNewTodo(Todo todo) {
        if (todo.getText().isEmpty()) {
            throw new IllegalArgumentException("Todo text cannot be empty");
        }

        try {
            todoDatabase.create(todo);
        } catch (Exception e) {
            System.err.println("Error adding new todo: " + e.getMessage());
        }
    }

    public Todo updateTodoById(int id, Todo todo) {
        if (id <= 0) {
            return null;
        }

        try {
            todoDatabase.update(id, todo);
        } catch (Exception e) {
            System.err.println("Error updating todo with ID " + id + ": " + e.getMessage());
        }
        return todo;
    }

    public Todo deleteTodoById(int id) {
        if (id <= 0) {
            return null;
        }
        Todo todo = new Todo();
        try {
            todoDatabase.delete(id);
        } catch (Exception e) {
            System.err.println("Error deleting todo with ID " + id + ": " + e.getMessage());
        }
        return todo;
    }
}
