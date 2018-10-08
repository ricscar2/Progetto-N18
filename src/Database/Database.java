package Database;

import java.sql.*;

public class Database {

    private Connection connection;
    private Statement statement;

    public Database(String admin, String password) throws SQLException {
        // Get a connection to database
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                "progetton?autoReconnect=true&useSSL=false&serverTimezone=UTC", admin, password);
        // Create a statement
        statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
