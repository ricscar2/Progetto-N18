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
        JSONObject user = new JSONObject();
        ResultSet myRs = dbStatement.executeQuery("select * from users where username = '" + username + "'");
        while (myRs.next()) {
            user.put("usr", username);
            user.put("pwd", myRs.getString("pwd"));
            user.put("name", myRs.getString("nome"));
            user.put("surname", myRs.getString("surname"));
            user.put("birthdate", myRs.getString("birthdate"));
            user.put("nation", myRs.getString("nation"));
            user.put("email", myRs.getString("email"));
        }
        return user.toJSONString();
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

    public static String getFlights(Statement dbStatement) throws SQLException {
        JSONObject jsonRoot = new JSONObject();
        JSONArray flights = new JSONArray();
        ResultSet myRs = dbStatement.executeQuery("select * from flights");
        while (myRs.next()){
            JSONObject flight = new JSONObject();
            flight.put("id", myRs.getString("id"));
            flight.put("departure", myRs.getString("departure"));
            flight.put("arrive", myRs.getString("arrive"));
            flight.put("departuretime", myRs.getString("dated"));
            flight.put("arrivetime", myRs.getString("datea"));
            flight.put("airplane", myRs.getString("airplane"));
            flights.add(flight);
        }
        jsonRoot.put("flights", flights);
        return jsonRoot.toJSONString();
    }

    public static String getAirplanes(Statement dbStatement) throws SQLException {
        JSONObject jsonRoot = new JSONObject();
        JSONArray airplanes = new JSONArray();
        ResultSet myRs = dbStatement.executeQuery("select * from airplanes");
        while (myRs.next()){
            JSONObject airplane = new JSONObject();
            airplane.put("id", myRs.getString("id"));
            airplane.put("economy", myRs.getString("economy"));
            airplane.put("business", myRs.getString("business"));
            airplanes.add(airplane);
        }
        jsonRoot.put("airplanes", airplanes);
        return jsonRoot.toJSONString();
    }

    public static String getPaymentMethods(Statement dbStatement, String username) throws SQLException {
        JSONObject jsonRoot = new JSONObject();
        JSONArray paymentMethods = new JSONArray();
        ResultSet myRs = dbStatement.executeQuery("select * from payments where holder = '" + username + "'");
        while (myRs.next()){
            JSONObject paymentMethod = new JSONObject();
            paymentMethod.put("id", myRs.getString("id"));
            paymentMethod.put("method", myRs.getString("method"));
            paymentMethods.add(paymentMethod);
        }
        jsonRoot.put("paymentMethods", paymentMethods);
        return jsonRoot.toJSONString();
    }

    public static boolean addPaymentMethod(Connection dbConnection, String id, String method, String holder) throws SQLException, ParseException {
        String query = "INSERT INTO PAYMENTS (ID, METHOD, HOLDER) VALUES(?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, method);
        preparedStatement.setString(3, holder);
        preparedStatement.executeUpdate();
        return true;
    }

}
