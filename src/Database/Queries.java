package Database;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Queries {

    public static boolean logIn(Statement dbStatement, String username, String password) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select username, pwd from users");
        while (myRs.next()){
            if(myRs.getString("username").equals(username) && myRs.getString("pwd").equals(password))
                return true;
        }
        return false;
    }

    public static boolean signIn(Connection dbConnection, String username, String password, String name, String surname, String sDate,
                                 String nation, String email) throws SQLException, ParseException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = sdf.parse(sDate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String query = "INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.setDate(5, sqlDate);
            preparedStatement.setString(6, nation);
            preparedStatement.setString(7, email);
            preparedStatement.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }



}
