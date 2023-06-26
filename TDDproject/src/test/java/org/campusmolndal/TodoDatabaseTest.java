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
        MockitoAnnotations.openMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    void addNewTodoWithEmptyTextReturnsNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("");
        todo.setDone(false);

        when(mockDatabase.create(todo)).thenReturn(null);

        assertNull(databaseFacade.addNewTodo(todo));
    }

    @Test
    void getTodoByIdWithZeroOrNegativeReturnsNull() {
        when(mockDatabase.getTodoById(0)).thenReturn(null);
        when(mockDatabase.getTodoById(-1)).thenReturn(null);

        assertNull(databaseFacade.getTodoById(0));
        assertNull(databaseFacade.getTodoById(-1));
    }

    @Test
    void updateTodoByIdWithNegativeIdReturnsNull() {
        Todo todo = new Todo();
        todo.setId(-1);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(databaseFacade.updateTodoById(todo.getId(), todo));
    }

    @Test
    void deleteTodoByIdWithIdZeroOrNegativeReturnsNull() {
        when(mockDatabase.delete(0)).thenReturn(null);
        when(mockDatabase.delete(-1)).thenReturn(null);

        assertNull(databaseFacade.deleteTodoById(0));
        assertNull(databaseFacade.deleteTodoById(-1));
    }

    @Test
    void getAllTodosReturnsNonEmptyArrayList() {
        // Mock the behavior to return a non-empty list
        when(mockDatabase.getAllTodos()).thenReturn((ArrayList<Todo>) someNonEmptyList());

        List<Todo> todos = databaseFacade.getAllTodos();

        assertNotNull(todos);
        assertTrue(todos.size() > 0);
    }

    // Helper method to create a non-empty list of Todo objects for testing
    private List<Todo> someNonEmptyList() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo());
        todos.add(new Todo());
        return todos;
    }
}