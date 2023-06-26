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
        MockitoAnnotations.openMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void addNewTodoShouldCallCreateMethodInDatabase() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        databaseFacade.addNewTodo(todo);

        verify(mockDatabase).create(todo);
    }

    @Test
    public void addNewTodoWithEmptyTextShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("");
        todo.setDone(false);

        when(mockDatabase.create(todo)).thenReturn(null);

        assertNull(databaseFacade.addNewTodo(todo));
    }

    @Test
    void updateTodoByIdZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(databaseFacade.updateTodoById(0, todo));
    }

    @Test
    void deleteTodoByIdZeroOrNegativeShouldReturnNull() {
        Todo todo = new Todo();
        todo.setId(0);
        todo.setText("Test task");
        todo.setDone(false);

        assertNull(databaseFacade.deleteTodoById(0));
    }

    @Test
    void getAllTodosShouldReturnListOfTodosFromDatabase() {
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
    void getTodoByIdShouldReturnTodoFromDatabase() {
        int todoId = 1;
        Todo todo = new Todo();
        todo.setId(todoId);
        todo.setText("Task 1");
        todo.setDone(false);

        when(mockDatabase.getTodoById(todoId)).thenReturn(todo);

        Todo result = databaseFacade.getTodoById(todoId);

        assertEquals(todo, result);

        verify(mockDatabase).getTodoById(todoId);
    }

    @Test
    void getTodoByIdWithNonexistentIdShouldReturnNull() {
        int nonexistentId = 999;

        when(mockDatabase.getTodoById(nonexistentId)).thenReturn(null);

        Todo result = databaseFacade.getTodoById(nonexistentId);

        assertNull(result);

        verify(mockDatabase).getTodoById(nonexistentId);
    }
}