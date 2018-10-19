package Web;

import Database.*;
import Eccezioni.CommandNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class CommandAnalizer {

    private Database database;
    private Statement dbStatement;
    private Connection dbConnection;
    private String response;

    public CommandAnalizer() throws SQLException {
        this.database = new Database("root", "toor");
        this.dbStatement = database.getStatement();
        this.dbConnection = database.getConnection();
        this.response = "";
    }


    public String analize(JsonCommand jsonCommand) throws SQLException, CommandNotFoundException, ParseException {
        switch (jsonCommand.getCode()){
            case "00":
                if (Queries.logIn(dbStatement, jsonCommand.getParameter("usr"), jsonCommand.getParameter("pwd"))){
                    response = Queries.getUserInfo(dbStatement, jsonCommand.getParameter("usr"));
                }
                else response = "false";
                return response;
            case "01":
                if(Queries.signIn(dbConnection, jsonCommand.getParameter("usr"), jsonCommand.getParameter("pwd"),
                        jsonCommand.getParameter("name"),jsonCommand.getParameter("surname"), jsonCommand.getParameter("birthdate"),
                        jsonCommand.getParameter("nation"), jsonCommand.getParameter("email")))
                    response = "true";
                else response = "false";
                return response;
            case "02":
                return Queries.getAirports(dbStatement);
            case "03":
                return Queries.getFlights(dbStatement);
            case "04":
                return Queries.getAirplanes(dbStatement);
            case "05":
                return Queries.getPaymentMethods(dbStatement, jsonCommand.getParameter("username"));
            case "06":
                if( Queries.addPaymentMethod(dbConnection, jsonCommand.getParameter("id"), jsonCommand.getParameter("method"),
                        jsonCommand.getParameter("holder")))
                    response = "true";
                else
                    response = "false";
                return response;
            case "07":
                if(jsonCommand.getParameter("seatType").equals("ECONOMY"))
                    return Queries.getRemainderEconomy(dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
                else if (jsonCommand.getParameter("seatType").equals("BUSINESS"))
                    return Queries.getRemainderBusiness(dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
            case "08":
                if(jsonCommand.getParameter("seatType").equals("ECONOMY")){
                    Queries.decEconomy(dbConnection, dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
                    return "AVAIABLE";
                } else if (jsonCommand.getParameter("seatType").equals("BUSINESS")){
                    Queries.decBusiness(dbConnection, dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
                    return "AVAIABLE";
                }
            case "09":
                Queries.incrEconomy(dbConnection, dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
                return "REINCREASED ECONOMY";
            case "10":
                Queries.incrBusiness(dbConnection, dbStatement, jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"));
                return "REINCREASED BUSINESS";
            case "11":
                if (Queries.bookTicket(dbConnection, jsonCommand.getParameter("id"), jsonCommand.getParameter("user"), jsonCommand.getParameter("holder"),
                        jsonCommand.getParameter("flight"), jsonCommand.getParameter("date"), jsonCommand.getParameter("baggage"), jsonCommand.getParameter("seat"), jsonCommand.getParameter("nSeat")))
                    response = "true";
                else response = "false";
                return response;
            case "12":
                return Queries.getTickets(dbStatement, jsonCommand.getParameter("username"));
            case "13":
                if(Queries.addBookedFlight(dbConnection, jsonCommand.getParameter("id"), jsonCommand.getParameter("date"),
                        jsonCommand.getParameter("eseat"), jsonCommand.getParameter("bseat")));
                return "FLIGHT ADDED TO DATABASE";
            case "14":
                Queries.checkIn(dbConnection, jsonCommand.getParameter("id"));
                return "CHECKED";
        }
        throw new CommandNotFoundException();

    }

}
