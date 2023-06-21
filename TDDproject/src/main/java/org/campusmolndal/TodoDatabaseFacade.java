package org.campusmolndal;

import java.util.ArrayList;

/** class to handle database operations
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
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return todo; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    public Todo[] getAllTodos() {
        try {
            ArrayList todos = todoDatabase.getAllTodos();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return todos; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    /*public Todo[] getTodosByDoneStatus(boolean done) {
        return todoDatabase.getTodosByDoneStatus(done);
    }*/

    /*public Todo[] getTodosByAssignee(Person assignee) {
        return todoDatabase.getTodosByAssignee(assignee);
    }*/

    public void addNewTodo(Todo todo) {
        try {
            todoDatabase.create(todo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Todo updateTodoById(int id, Todo todo) {
        try {
            todoDatabase.update(id, todo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return todo; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    public void deleteTodoById(int id) {
        try {
            todoDatabase.delete(id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
