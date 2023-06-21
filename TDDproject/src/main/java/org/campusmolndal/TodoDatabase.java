package org.campusmolndal;

import java.sql.*;
import java.util.ArrayList;

/** class to handle the database connection
 *
 */
public class TodoDatabase {
    private Connection connection;

    public TodoDatabase() throws SQLException {
        String dbName = "todo-list-db";
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
    }

    public void CreateTable() {
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
            if (connection.isClosed() && connection == null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void create(Todo todo) {
        // tar in ett obejkt av typen Todo och lägger till det i databasen
        //INSERT INTO todos (id, text, done) VALUES (todo.getId(), todo.getText(), todo.isDone());
        String sql = "INSERT INTO todos (id, text, done) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, todo.getId());
            pstmt.setString(2, todo.getText());
            pstmt.setBoolean(3, todo.isDone());
            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Todo getTodoById(int id) {
        return todo;
    }

    public ArrayList getAllTodos() {
        return todos;
    }

    public void update(int id, Todo todo) {
    }

    public void delete(int id) {
    }
}
