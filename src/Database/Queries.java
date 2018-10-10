package Database;

import User.User;
import Web.JsonCommand;
import Web.JsonResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public static String getUserInfo(Statement dbStatement, String username) throws SQLException {
        JsonResponse user = null;
        ResultSet myRs = dbStatement.executeQuery("select * from users where username = '" + username + "'");
        while (myRs.next()) {
            user = new JsonResponse(username, myRs.getString("pwd"), myRs.getString("nome"), myRs.getString("surname"),
                    myRs.getString("birthdate"), myRs.getString("nation"), myRs.getString("email"));
        }
        return user.getJsonString();
    }


    public static String getAirports(Statement dbStatement) throws SQLException {
        JSONObject jsonRoot = new JSONObject();
        JSONArray airports = new JSONArray();
        ResultSet myRs = dbStatement.executeQuery("select * from airports");
        while (myRs.next()){
            JSONObject airport = new JSONObject();
            airport.put("iata", myRs.getString("IATA"));
            airport.put("name", myRs.getString("nome"));
            airport.put("city", myRs.getString("city"));
            airport.put("nation", myRs.getString("nation"));
            airports.add(airport);
        }
        jsonRoot.put("airports", airports);
        return jsonRoot.toJSONString();
    }

    /*La classe queries permette la lettura delle queries su mysql direttamente da java,contiene i database di Airports e UserInfo.
    Va inoltre ad inserire i dati, che vengono messi da tastiera al momento del signIn,all'interno delle tabelle su myql.  */

}
