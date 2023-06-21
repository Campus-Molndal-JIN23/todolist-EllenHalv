package org.campusmolndal;

import java.util.Scanner;

/** Facade class - handles todo operations
 *
 */
public class TodoFacade {
    private final TodoDatabaseFacade todoDatabaseFacade;
    Scanner sc = new Scanner(System.in);
public TodoFacade(TodoDatabaseFacade todoDatabaseFacade) {
        this.todoDatabaseFacade = todoDatabaseFacade;
    }
    public void addTodo(Todo todo) {
        todo.setId(generateUniqueId());
        todo.setText("Do the dishes");
        todo.setDone(false);

        todoDatabaseFacade.addNewTodo(todo);
    }

    /** Generates a unique id for the todo
     * @return
     */
    public int generateUniqueId() {
        return 1;
    }
}
