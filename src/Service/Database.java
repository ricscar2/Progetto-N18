package Service;

import java.sql.*;

public class Database {

    private Connection myConn;
    private Statement myStat;

    public Database(String admin, String password) throws SQLException {
        // Get a connection to database
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                "progetton?autoReconnect=true&useSSL=false&serverTimezone=UTC", admin, password);
        // Create a statement
        myStat = myConn.createStatement();
    }

    public boolean logIn(String username, String password) throws SQLException {
        ResultSet myRs = myStat.executeQuery("select username, password from users");
        while (myRs.next()){
            if(myRs.getString("username").equals(username) && myRs.getString("password").equals(password))
                return true;
        }
        return false;
    }

}
