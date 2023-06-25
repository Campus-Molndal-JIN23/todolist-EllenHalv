package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TodoDatabaseTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockDatabase = new TodoDatabase("mock-database");
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void createWithEmptyTextShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("");
        todo.setDone(false);

        assertNull(mockDatabase.create(todo));
    }

    @Test
    public void getTodoByIdWithZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(mockDatabase.getTodoById(0));
    }

    @Test
    public void updateWithNegativeIdShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(-1);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(mockDatabase.update(todo.getId(), todo));
    }

    @Test
    public void deleteIdZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(mockDatabase.delete(todo.getId()));
    }

    @Test
    public void getAllTodosArrayListShouldBeReturned(){
        List<Todo> todos = databaseFacade.getAllTodos();

        assertNotNull(todos);
        assertTrue(todos.size() > 0);
    }
}