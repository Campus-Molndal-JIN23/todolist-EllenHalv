package org.campusmolndal;

/** Facade class - creates and updates Todo objects
 *
 */
public class TodoFacade {
    private final TodoDatabaseFacade todoDatabaseFacade;

    public TodoFacade(TodoDatabaseFacade todoDatabaseFacade) {
        this.todoDatabaseFacade = todoDatabaseFacade;
    }

    public Todo createTodo(String text, boolean done) {
        if (text.isEmpty()) {
            return null;
        }

        Todo todo = new Todo();
        todo.setText(text);
        todo.setDone(done);

        try {
            todoDatabaseFacade.addNewTodo(todo);
            return todo;
        } catch (Exception e) {
            System.err.println("Error creating todo: " + e.getMessage());
            return null;
        }
    }

    public Todo updateTodo(int id, String text, boolean done) {
        if (text.isEmpty()) {
            return null;
        }

        Todo todo = todoDatabaseFacade.getTodoById(id);
        if (todo == null) {
            return null;
        }

        todo.setText(text);
        todo.setDone(done);
        try {
            todoDatabaseFacade.updateTodoById(id, todo);
            return todo;
        } catch (Exception e) {
            System.err.println("Error updating todo: " + e.getMessage());
            return null;
        }
    }
}
