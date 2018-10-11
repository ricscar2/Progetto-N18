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

    /*
    00: LogIn
    01: Informazioni utente dato l'username
    02: Elenco aeroporti nel database
     */
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
            /*case "07":
                return Queries.getSelectedFlights(dbStatement, jsonCommand.getParameter("departure"), jsonCommand.getParameter("arrive"));*/
        }
        throw new CommandNotFoundException();

    }

}
