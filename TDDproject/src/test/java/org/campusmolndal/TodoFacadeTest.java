package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class TodoFacadeTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void createTodoTest() {
        Todo todo = new Todo(1,"Test task", false);

        databaseFacade.addNewTodo(todo);

        verify(mockDatabase).create(todo);
    }

    @Test
    public void updateTodoTest() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        databaseFacade.updateTodoById(todo.getId(), todo);

        verify(mockDatabase).update(todo.getId(), todo);
    }
}
