package org.campusmolndal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** class to handle the database connection
 *
 */
public class TodoDatabase {
    public void addTodo(Todo todo) {
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

    private Connection connect() {
        return null;
    }
}
