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

    public Todo getTodoById(int id) { //går dessa att göra snyggare med try/catch?
        Todo todo = todoDatabase.getTodoById(id);
        return todo; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    public ArrayList getAllTodos() { //går dessa att göra snyggare med try/catch?
        ArrayList<Todo> todos = todoDatabase.getAllTodos();
        return todos; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    public ArrayList getTodosByDoneStatus(boolean done) { //går dessa att göra snyggare med try/catch?
        ArrayList<Todo> todos = todoDatabase.getTodosByDoneStatus(done);
        return todos; // returnerade objektet bör skrivas ut för att se att det är uppdaterat
    }

    /*public Todo[] getTodosByAssignee(Person assignee) {
        return todoDatabase.getTodosByAssignee(assignee);
    }*/

    public void addNewTodo(Todo todo) { // tar in ett obejkt av typen Todo från TodoFacade och lägger till det i databasen
        try {
            todoDatabase.create(todo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void updateTodoById(int id, Todo todo) {
        try {
            todoDatabase.update(id, todo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void deleteTodoById(int id) {
        try {
            todoDatabase.delete(id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
