package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/** Tests the DatabaseFacade class with help from fake responses from MockDatabase
 *
 */
public class TodoFacadeTest {

    // Instansera en MockDatabase och en DatabaseFacade
    @Mock
    private TodoDatabase mockDatabase;
    private TodoFacade facade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        facade = new TodoFacade();
    }

    /** Test addTodo() method
     * - task not null
     * -
     */
    @Test
    public void addTodoTest() {
        // Arrange
        Todo todo = new Todo(1,"Test task", false);

        // Act
        facade.addTodo(todo);

        // Assert
        verify(mockDatabase).addTodo(todo);
    }

    /** Test getTodo() method
     * Take the task id and compare it to the task id in the database
     - id not null
     - id is a number
     - id is not negative
     - check if the task exists in the database
     */

    /** Test deleteTodo() method
     *
     */

    /** Test updateTodo() method
     *
     */

    /** Test getAllTodos() method
     *
     */

    /*
    public void getAllTodosTest(){

        DatabaseFacade facade = new DatabaseFacade();

        List<Todo> todos = facade.getAllTodos();

        Assertions.assertThat(todos.size()).isGreaterThan(0);
    }
     */
}
