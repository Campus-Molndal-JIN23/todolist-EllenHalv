package org.campusmolndal;

import java.util.Scanner;

/** Facade class - handles todo operations
 *
 */
public class TodoFacade {
    Scanner sc = new Scanner(System.in);
    TodoDatabase todoDatabase;

    public void addTodo(Todo todo) {
        todo.setId(generateUniqueId());
        todo.setText("Do the dishes");
        todo.setDone(false);

        todoDatabase.addTodo(todo);
    }

    /** Generates a unique id for the todo
     * @return
     */
    public int generateUniqueId() {
        return 0;
    }
}
