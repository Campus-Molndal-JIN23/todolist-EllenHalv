package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TodoFacadeTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;
    private TodoFacade todoFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
        todoFacade = new TodoFacade(databaseFacade);
    }

    @Test
    public void createTodoWithEmptyTextShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("");
        todo.setDone(false);

        assertNull(todoFacade.createTodo(todo.getText(), todo.isDone()));
    }

    @Test
    public void updateTodoWithEmptyTextShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("");
        todo.setDone(false);

        assertNull(todoFacade.updateTodo(todo.getId(), todo.getText(), todo.isDone()));
    }
}
