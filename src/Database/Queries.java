package Database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Gruppo N
 */
public class Queries {

    static Queries instance;

    // private Queries(){}

    /**
     *
     * @return The instance of <code>Queries</code> class (Singleton)
     */
    public static synchronized Queries getInstance(){
        if (instance == null)
            instance = new Queries();
        return instance;
    }

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param username The username of the User
     * @param password The password of the User
     * @return True or False, depending on whether it went to a good end or not
     * @throws SQLException
     */
    public boolean logIn(Statement dbStatement, String username, String password) throws SQLException {
        ResultSet myRs = dbStatement.executeQuery("select username, pwd from users");
        while (myRs.next()){
            if(myRs.getString("username").equals(username) && myRs.getString("pwd").equals(password))
                return true;
        }
        return false;
    }

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param username The username of the User
     * @param password The password of the User
     * @param name The name of the User
     * @param surname The surname of the User
     * @param sDate The birthdate of the User
     * @param nation Tha nation of the User
     * @param email The email of the User
     * @return True if the User has been registered
     * @throws SQLException
     * @throws ParseException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param username The username of the User
     * @return A JSONString with the info of the User
     * @throws SQLException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @return A JSONString with all the Airports present in the database
     * @throws SQLException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @return A JSONString with all the Flights present in the database
     * @throws SQLException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @return A JSONString with all the Airplanes present in the database
     * @throws SQLException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param username The username of the User
     * @return A JSONString with Payment Methods associated to the User
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param id The ID of the Payment Method that User wants to register
     * @param method The Payment Method's Type that User wants to register
     * @param holder The holder of the Payment Method that User wants to register
     * @return True if registration is happened successfully
     * @throws SQLException
     * @throws ParseException
     */
    public boolean addPaymentMethod(Connection dbConnection, String id, String method, String holder) throws SQLException, ParseException {
            String query = "INSERT INTO PAYMENTS (ID, METHOD, HOLDER) VALUES(?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, method);
            preparedStatement.setString(3, holder);
            preparedStatement.executeUpdate();
            return true;
    }

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return A JSONString with the Reminders Economy Seats
     * @throws SQLException
     */
    public String getRemainderEconomy(Statement dbStatement, String flight, String ddate) throws SQLException {
        JSONObject economy = new JSONObject();
        ResultSet myRs = dbStatement.executeQuery("select eseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        while (myRs.next()) {
            economy.put("economy", myRs.getString("eseat"));
        }
        return economy.toJSONString();
    }

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return A JSONString with the Reminders Business Seats
     * @throws SQLException
     */
    public String getRemainderBusiness(Statement dbStatement, String flight, String ddate) throws SQLException {
        JSONObject business = new JSONObject();
        ResultSet myRs = dbStatement.executeQuery("select bseat from bookedflights where ddate = '" + ddate + "' and id = '" + flight + "'");
        while (myRs.next()) {
            business.put("business", myRs.getString("bseat"));
        }
        return business.toJSONString();
    }

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return True if decrease of a unit (of Economy Seats) was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return True if decrease of a unit (of Business Seats) was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return True if increase of a unit (of Economy Seats) was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param dbStatement A Statement of the Database
     * @param flight The Flight of interest
     * @param ddate The Departure Date of the Flight of interest
     * @return True if increase of a unit (of Business Seats) was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param id The ID of the Ticket that User wants to book
     * @param user The username of the User that wants to book the Ticket
     * @param holder The holder of the Ticket to book
     * @param flight The Flight associated to the Ticket to book
     * @param date The Departure Date associated to the Ticket to book
     * @param baggage The Baggage Type associated to the Ticket to book
     * @param seat The Seat Type associated to the Ticket to book
     * @param nSeat The Number of the Seat associated to the Ticket to book
     * @return True if the booking was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbStatement A Statement of the Database
     * @param username The username of the User
     * @return A JSONString of the Tickets associated to the User
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param id The id of the Booked Flight
     * @param date The date of the Booked Flight
     * @param eseat The remainders Economy Seats of the Booked Flight
     * @param bseat The remainders Business Seats of the Booked Flight
     * @return True if the procedure was successful
     * @throws SQLException
     */
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

    /**
     *
     * @param dbConnection A Connection to the Database
     * @param id The id of the Ticket that have done the checkin
     * @throws SQLException
     */
    public void checkIn(Connection dbConnection, String id) throws SQLException {
        String query = "UPDATE TICKETS SET CHECKED = 1 WHERE ID = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

}
