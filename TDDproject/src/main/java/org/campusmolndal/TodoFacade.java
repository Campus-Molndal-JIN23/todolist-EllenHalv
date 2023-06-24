package org.campusmolndal;

/** Facade class - creates Todo objects
 *
 */
public class TodoFacade {
    private final TodoDatabaseFacade todoDatabaseFacade;
public TodoFacade(TodoDatabaseFacade todoDatabaseFacade) {
        this.todoDatabaseFacade = todoDatabaseFacade;
    }
    public void createTodo(String text, boolean done) { // tar in parametrar och skapar ett objekt av typen Todo
        Todo todo = new Todo();
        todo.setText(text);
        todo.setDone(done);

        todoDatabaseFacade.addNewTodo(todo);
    }

    public void updateTodo(int id, String text, boolean done) { //hämta todo från databas, skriv ut den och uppdatera den, spara den på nytt
        Todo todo = todoDatabaseFacade.getTodoById(id);
        todo.setText(text);
        todo.setDone(done);
        todoDatabaseFacade.updateTodoById(id, todo);
    }
}
