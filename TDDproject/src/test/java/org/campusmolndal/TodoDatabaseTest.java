package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class TodoDatabaseTest {

    @Mock
    private TodoDatabase mockDatabase;
    private TodoDatabaseFacade databaseFacade;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
        databaseFacade = new TodoDatabaseFacade(mockDatabase);
    }

    @Test
    public void createTest() {
        Todo todo = new Todo(1, "Test task", false);

        databaseFacade.addNewTodo(todo);

        verify(mockDatabase).create(todo);
    }

    @Test
    public void updateTest() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        mockDatabase.update(todo.getId(), todo);

        verify(mockDatabase).update(todo.getId(), todo);
    }

    @Test
    public void deleteTest() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        mockDatabase.delete(todo.getId());

        verify(mockDatabase).delete(todo.getId());
    }

    @Test
    public void getTodoByIdTest() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        databaseFacade.getTodoById(todo.getId());

        verify(mockDatabase).getTodoById(todo.getId());
    }

    @Test

    public void getAllTodosTest(){
        Todo todo = new Todo();
        todo.setId(1);
        todo.setText("Test task");
        todo.setDone(false);

        List<Todo> todos = new ArrayList<>();
        todos.add(todo);

        databaseFacade.getAllTodos();

        verify(mockDatabase).getAllTodos();
    }
}