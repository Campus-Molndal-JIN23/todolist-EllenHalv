package org.campusmolndal;

import java.sql.*;
import java.util.ArrayList;

/** class to handle database connection and database querys
 *
 */
public class TodoDatabase {
    private Connection connection;

    private final String databaseName;

    public TodoDatabase(String databaseName) { // establish connection to database
        this.databaseName = databaseName;
        try {
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
        createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        try {
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS todos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "text TEXT," +
                "done BOOLEAN" +
                ")";
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Todo create(Todo todo) {
        if (todo.getText().isEmpty()) {
            return null;
        }
        String sql = "INSERT INTO todos (text, done) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, todo.getText());
            pstmt.setBoolean(2, todo.isDone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todo;
    }

    public Todo getTodoById(int id) {
        if (id <= 0) {
            return null;
        }

        Todo todo = new Todo();
        String sql = "SELECT * FROM todos WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                todo = createTodoFromResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todo;
    }

    public ArrayList<Todo> getAllTodos() {
        ArrayList<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Todo todo = createTodoFromResultSet(rs);
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }

    public Todo update(int id, Todo todo) {
        if (id <= 0) {
            return null;
        }

        String sql = "UPDATE todos SET text = ?, done = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, todo.getText());
            pstmt.setBoolean(2, todo.isDone());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todo;
    }

    public Todo delete(int id) {
        if (id <= 0) {
            return null;
        }

        if (getTodoById(id) == null) {
            return null;
        }

        Todo todo = new Todo();
        String sql = "DELETE FROM todos WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todo;
    }

    private Todo createTodoFromResultSet(ResultSet rs) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setText(rs.getString("text"));
        todo.setDone(rs.getBoolean("done"));
        return todo;
    }

    public boolean isTodoIdValid(int id) {
        return getTodoById(id) != null;
    }
}
