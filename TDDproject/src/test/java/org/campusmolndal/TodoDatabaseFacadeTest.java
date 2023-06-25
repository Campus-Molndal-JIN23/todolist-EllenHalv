package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoDatabaseFacadeTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void addNewTodoTest() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        databaseFacade.addNewTodo(todo);

        verify(mockDatabase).create(todo);
    }

    @Test
    public void addNewTodoWithEmptyTextShouldThrowException() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("");
        todo.setDone(false);

        assertThrows(IllegalArgumentException.class, () -> {
            databaseFacade.addNewTodo(todo);
        });
    }


    @Test
    public void updateTodoByIdZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(databaseFacade.updateTodoById(0, todo));
    }

    @Test
    public void deleteTodoByIdZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(databaseFacade.deleteTodoById(0));
    }

    @Test
    public void getAllTodosTest() {
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1, "Task 1", false));
        todos.add(new Todo(2, "Task 2", true));
        todos.add(new Todo(3, "Task 3", false));

        when(mockDatabase.getAllTodos()).thenReturn(todos);

        ArrayList<Todo> result = databaseFacade.getAllTodos();

        assertEquals(todos.size(), result.size());
        assertEquals(todos.get(0), result.get(0));
        assertEquals(todos.get(1), result.get(1));
        assertEquals(todos.get(2), result.get(2));

        verify(mockDatabase).getAllTodos();
    }

    @Test
    public void getTodoByIdNonexistentIdShouldReturnNull() {
        // Test case for getting a todo that does not exist in the database
        int todoId = 999;

        when(mockDatabase.getTodoById(todoId)).thenReturn(null);

        Todo result = databaseFacade.getTodoById(todoId);

        assertNull(result);

        verify(mockDatabase).getTodoById(todoId);
    }
}