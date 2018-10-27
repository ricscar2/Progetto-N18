package Web;

import Database.*;
import Eccezioni.CommandNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 * @author Gruppo N
 */
public class CommandAnalizer {

    private Database database;
    private Statement dbStatement;
    private Connection dbConnection;
    private String response;
    private Queries query;

    /**
     *
     * @throws SQLException
     */
    public CommandAnalizer() throws SQLException {
        this.database = new Database("root", "toor");
        this.dbStatement = database.getStatement();
        this.dbConnection = database.getConnection();
        this.response = "";
        this.query = Queries.getInstance();
    }

    /**
     *
     * @param command The Command to be analyzed
     * @return The informations according to the elaboration of the Command
     * @throws SQLException
     * @throws CommandNotFoundException
     * @throws ParseException
     */
    public String analize(Command command) throws SQLException, CommandNotFoundException, ParseException {
        switch (command.getCode()){
            case "00":
                if (query.logIn(dbStatement, command.getParameter("usr"), command.getParameter("pwd"))){
                    response = query.getUserInfo(dbStatement, command.getParameter("usr"));
                }
                else response = "false";
                return response;
            case "01":
                if(query.signIn(dbConnection, command.getParameter("usr"), command.getParameter("pwd"),
                        command.getParameter("name"),command.getParameter("surname"), command.getParameter("birthdate"),
                        command.getParameter("nation"), command.getParameter("email")))
                    response = "true";
                else response = "false";
                return response;
            case "02":
                return query.getAirports(dbStatement);
            case "03":
                return query.getFlights(dbStatement);
            case "04":
                return query.getAirplanes(dbStatement);
            case "05":
                return query.getPaymentMethods(dbStatement, command.getParameter("username"));
            case "06":
                if( query.addPaymentMethod(dbConnection, command.getParameter("id"), command.getParameter("method"),
                        command.getParameter("holder")))
                    response = "true";
                else
                    response = "false";
                return response;
            case "07":
                if(command.getParameter("seatType").equals("ECONOMY"))
                    return query.getRemainderEconomy(dbStatement, command.getParameter("flight"), command.getParameter("date"));
                else if (command.getParameter("seatType").equals("BUSINESS"))
                    return query.getRemainderBusiness(dbStatement, command.getParameter("flight"), command.getParameter("date"));
            case "08":
                if(command.getParameter("seatType").equals("ECONOMY")){
                    query.decEconomy(dbConnection, dbStatement, command.getParameter("flight"), command.getParameter("date"));
                    return "AVAIABLE";
                } else if (command.getParameter("seatType").equals("BUSINESS")){
                    query.decBusiness(dbConnection, dbStatement, command.getParameter("flight"), command.getParameter("date"));
                    return "AVAIABLE";
                }
            case "09":
                query.incrEconomy(dbConnection, dbStatement, command.getParameter("flight"), command.getParameter("date"));
                return "REINCREASED ECONOMY";
            case "10":
                query.incrBusiness(dbConnection, dbStatement, command.getParameter("flight"), command.getParameter("date"));
                return "REINCREASED BUSINESS";
            case "11":
                if (query.bookTicket(dbConnection, command.getParameter("id"), command.getParameter("user"), command.getParameter("holder"),
                        command.getParameter("flight"), command.getParameter("date"), command.getParameter("baggage"), command.getParameter("seat"), command.getParameter("nSeat")))
                    response = "true";
                else response = "false";
                return response;
            case "12":
                return query.getTickets(dbStatement, command.getParameter("username"));
            case "13":
                if(query.addBookedFlight(dbConnection, command.getParameter("id"), command.getParameter("date"),
                        command.getParameter("eseat"), command.getParameter("bseat")));
                return "FLIGHT ADDED TO DATABASE";
            case "14":
                query.checkIn(dbConnection, command.getParameter("id"));
                return "CHECKED";
        }
        throw new CommandNotFoundException();

    }

}
