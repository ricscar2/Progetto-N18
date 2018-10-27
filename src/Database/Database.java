package Database;


import java.sql.*;

public class Database {

    private Connection connection;
    private Statement statement;

    /**
     *
     * @param admin The username of the Database Administrator
     * @param password The Password of the Database Administrator
     * @throws SQLException
     */
    public Database(String admin, String password) throws SQLException {
        // Get a connection to database
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                "progetton?autoReconnect=true&useSSL=false&serverTimezone=UTC", admin, password);
        // Create a statement
        this.statement = connection.createStatement();
    }

    /**
     *
     * @return The Statement of the Database
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     *
     * @return The Connection to the Database
     */
    public Connection getConnection() {
        return connection;
    }
}
