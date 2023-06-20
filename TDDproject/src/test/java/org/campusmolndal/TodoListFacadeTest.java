package org.campusmolndal;

/** Tests the DatabaseFacade class with help from fake responses from MockDatabase
 *
 */
public class TodoListFacadeTest {

    // @BeforeEach borde användas för att återställa databasen mellan varje test? Eller sätt in data inför varje test?

    // Instansera en MockDatabase och en DatabaseFacade

    /** Test addNewTodo() method
     * - task not null
     * -
     */

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
