package org.campusmolndal;

import java.sql.*;
import java.util.ArrayList;

/** class to handle database connection and database querys
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
        // tar in ett obejkt av typen Todo från TodoDatabaseFacade och lägger till det i databasen
        //INSERT INTO todos (id, text, done) VALUES (todo.getId(), todo.getText(), todo.isDone());
        String sql = "INSERT INTO todos (id, text, done) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, todo.getId());
            pstmt.setString(2, todo.getText());
            pstmt.setBoolean(3, todo.isDone());
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Todo getTodoById(int id) {
        Todo todo = new Todo();
        String sql = "SELECT * FROM todos WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            todo.setId(rs.getInt("id"));
            todo.setText(rs.getString("text"));
            todo.setDone(rs.getBoolean("done"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todo;
    }

    public ArrayList getAllTodos() {
        ArrayList<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setText(rs.getString("text"));
                todo.setDone(rs.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }

    public void update(int id, Todo todo) {
        String sql = "UPDATE todos (text, done) VALUES (?, ?) WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, todo.getText());
            pstmt.setBoolean(2, todo.isDone());
            pstmt.setInt(3, id);
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM todos WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Todo> getTodosByDoneStatus(boolean done) {
        ArrayList<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos WHERE done = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, done);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setText(rs.getString("text"));
                todo.setDone(rs.getBoolean("done"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }
}
