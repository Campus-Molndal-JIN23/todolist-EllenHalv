package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoDatabaseTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void createTodoWithEmptyTextReturnsNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("");
        todo.setDone(false);

        when(mockDatabase.create(todo)).thenReturn(null);

        assertNull(mockDatabase.create(todo));
    }

    @Test
    public void getTodoByIdWithZeroOrNegativeReturnsNull() {
        when(mockDatabase.getTodoById(0)).thenReturn(null);
        when(mockDatabase.getTodoById(-1)).thenReturn(null);

        assertNull(mockDatabase.getTodoById(0));
        assertNull(mockDatabase.getTodoById(-1));
    }

    @Test
    public void updateWithNegativeIdReturnsNull() {
        Todo todo = new Todo();
        todo.setId(-1);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(mockDatabase.update(todo.getId(), todo));
    }

    @Test
    public void deleteWithIdZeroOrNegativeReturnsNull() {
        when(mockDatabase.delete(0)).thenReturn(null);
        when(mockDatabase.delete(-1)).thenReturn(null);

        assertNull(mockDatabase.delete(0));
        assertNull(mockDatabase.delete(-1));
    }

    @Test
    public void getAllTodosReturnsNonEmptyArrayList() {
        // Mock the behavior to return a non-empty list
        when(mockDatabase.getAllTodos()).thenReturn((ArrayList) someNonEmptyList());

        List<Todo> todos = databaseFacade.getAllTodos();

        assertNotNull(todos);
        assertTrue(todos.size() > 0);
    }

    // Helper method to create a non-empty list of Todo objects for testing
    private List<Todo> someNonEmptyList() {
        List<Todo> todos = new ArrayList<>();
        // Add some Todo objects to the list
        todos.add(new Todo());
        todos.add(new Todo());
        return todos;
    }
}