package org.campusmolndal;

import java.util.ArrayList;

/** class to help handle database operations
 *
 */
public class TodoDatabaseFacade {

    private final TodoDatabase todoDatabase;

    public TodoDatabaseFacade(TodoDatabase todoDatabase) {
        this.todoDatabase = todoDatabase;
    }

    public Todo getTodoById(int id) {
        if (id <= 0) {
            return null;
        }
        try {
            return todoDatabase.getTodoById(id);
        } catch (Exception e) {
            System.err.println("Error retrieving todo with ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Todo> getAllTodos() {
        try {
            return todoDatabase.getAllTodos();
        } catch (Exception e) {
            System.err.println("Error retrieving all todos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Todo addNewTodo(Todo todo) {
        if (todo.getText().isEmpty()) {
            return null;
        }

        try {
            todoDatabase.create(todo);
        } catch (Exception e) {
            System.err.println("Error adding new todo: " + e.getMessage());
        }
        return todo;
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
