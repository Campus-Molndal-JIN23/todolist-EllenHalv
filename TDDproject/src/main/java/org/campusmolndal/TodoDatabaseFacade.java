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

    /*public Todo[] getTodosByAssignee(Person assignee) {
        return todoDatabase.getTodosByAssignee(assignee);
    }*/

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

    public void updateTodoById(int id, Todo todo) {
        if (id == 0 || id < 0) {
            throw new IllegalArgumentException("Todo ID cannot be zero or negative");
        }

        try {
            todoDatabase.update(id, todo);
        } catch (Exception e) {
            System.err.println("Error updating todo with ID " + id + ": " + e.getMessage());
        }
    }

    public void deleteTodoById(int id) {
        try {
            todoDatabase.delete(id);
        } catch (Exception e) {
            System.err.println("Error deleting todo with ID " + id + ": " + e.getMessage());
        }
    }
}
