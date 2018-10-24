package Database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Queries {

    static Queries instance;

    // private Queries(){}

    public static synchronized Queries getInstance(){
        if (instance == null)
            instance = new Queries();
        return instance;
    }

    public boolean logIn(Statement dbStatement, String username, String password) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select username, pwd from users");
        while (myRs.next()){
            if(myRs.getString("username").equals(username) && myRs.getString("pwd").equals(password))
                return true;
        }
        return false;
    }

    public boolean signIn(Connection dbConnection, String username, String password, String name, String surname, String sDate,
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

    public String getUserInfo(Statement dbStatement, String username) throws SQLException {
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

    public String getAirports(Statement dbStatement) throws SQLException {
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

    public String getFlights(Statement dbStatement) throws SQLException {
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

    public String getAirplanes(Statement dbStatement) throws SQLException {
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

    public String getPaymentMethods(Statement dbStatement, String username) throws SQLException {
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

    public boolean addPaymentMethod(Connection dbConnection, String id, String method, String holder) throws SQLException, ParseException {
            String query = "INSERT INTO PAYMENTS (ID, METHOD, HOLDER) VALUES(?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, method);
            preparedStatement.setString(3, holder);
            preparedStatement.executeUpdate();
            return true;
    }

    public String getRemainderEconomy(Statement dbStatement, String flight, String ddate) throws SQLException {
        JSONObject economy = new JSONObject();
        ResultSet myRs = dbStatement.executeQuery("select eseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        while (myRs.next()) {
            economy.put("economy", myRs.getString("eseat"));
        }
        return economy.toJSONString();
    }

    public String getRemainderBusiness(Statement dbStatement, String flight, String ddate) throws SQLException {
        JSONObject business = new JSONObject();
        ResultSet myRs = dbStatement.executeQuery("select bseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        while (myRs.next()) {
            business.put("business", myRs.getString("bseat"));
        }
        return business.toJSONString();
    }

    public boolean decEconomy(Connection dbConnection, Statement dbStatement, String flight, String ddate) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select eseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        int remainder = 0;
        while (myRs.next()) {
            remainder = Integer.parseInt(myRs.getString("eseat")) - 1;
        }
        String query = "UPDATE BOOKEDFLIGHTS SET ESEAT = ? WHERE DDATE = ? AND ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(remainder));
        preparedStatement.setString(2, ddate);
        preparedStatement.setString(3, flight);
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean decBusiness(Connection dbConnection, Statement dbStatement, String flight, String ddate) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select bseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        int remainder = 0;
        while (myRs.next()) {
            remainder = Integer.parseInt(myRs.getString("bseat")) - 1;
        }
        String query = "UPDATE BOOKEDFLIGHTS SET BSEAT = ? WHERE DDATE = ? AND ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(remainder));
        preparedStatement.setString(2, ddate);
        preparedStatement.setString(3, flight);
        preparedStatement.executeUpdate();
        return true;
    }

    public void incrEconomy(Connection dbConnection, Statement dbStatement, String flight, String ddate) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select eseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        int remainder = 0;
        while (myRs.next()) {
            remainder = Integer.parseInt(myRs.getString("eseat")) + 1;
        }
        String query = "UPDATE BOOKEDFLIGHTS SET ESEAT = ? WHERE DDATE = ? AND ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(remainder));
        preparedStatement.setString(2, ddate);
        preparedStatement.setString(3, flight);
        preparedStatement.executeUpdate();
    }

    public void incrBusiness(Connection dbConnection, Statement dbStatement, String flight, String ddate) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select bseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        int remainder = 0;
        while (myRs.next()) {
            remainder = Integer.parseInt(myRs.getString("bseat")) + 1;
        }
        String query = "UPDATE BOOKEDFLIGHTS SET BSEAT = ? WHERE DDATE = ? AND ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(remainder));
        preparedStatement.setString(2, ddate);
        preparedStatement.setString(3, flight);
        preparedStatement.executeUpdate();
    }

    public boolean bookTicket(Connection dbConnection, String id, String user, String holder, String flight,
                                     String date, String baggage, String seat, String nSeat) throws SQLException {
        String query = "INSERT INTO TICKETS (ID, FLIGHTUSER, HOLDER, FLIGHT, DDATE, BAGGAGE, SEAT, NSEAT, CHECKED) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, user);
        preparedStatement.setString(3, holder);
        preparedStatement.setString(4, flight);
        preparedStatement.setString(5, date);
        preparedStatement.setString(6, baggage);
        preparedStatement.setString(7, seat);
        preparedStatement.setString(8, nSeat);
        preparedStatement.setString(9, String.valueOf(0));
        preparedStatement.executeUpdate();
        return true;
    }

    public String getTickets(Statement dbStatement, String username) throws SQLException {
        JSONObject jsonRoot = new JSONObject();
        JSONArray tickets = new JSONArray();
        ResultSet myRs = dbStatement.executeQuery("select * from tickets where flightuser = '" + username + "'");
        while (myRs.next()){
            JSONObject ticket = new JSONObject();
            ticket.put("id", myRs.getString("id"));
            ticket.put("holder", myRs.getString("holder"));
            ticket.put("flight", myRs.getString("flight"));
            ticket.put("date", myRs.getString("ddate"));
            ticket.put("baggage", myRs.getString("baggage"));
            ticket.put("seat", myRs.getString("seat"));
            ticket.put("nseat", myRs.getString("nseat"));
            ticket.put("checked", myRs.getString("checked"));
            tickets.add(ticket);
        }
        jsonRoot.put("tickets", tickets);
        return jsonRoot.toJSONString();
    }

    public boolean addBookedFlight(Connection dbConnection, String id, String date, String eseat, String bseat) throws SQLException{
        String query = "INSERT INTO BOOKEDFLIGHTS(ID, DDATE, ESEAT, BSEAT)" +
                "VALUES (?, ?, ?, ?); ";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, eseat);
        preparedStatement.setString(4, bseat);
        preparedStatement.executeUpdate();
        return true;
    }

    public void checkIn(Connection dbConnection, String id) throws SQLException {
        String query = "UPDATE TICKETS SET CHECKED = 1 WHERE ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

}
