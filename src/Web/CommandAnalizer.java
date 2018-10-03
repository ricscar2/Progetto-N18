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
        }
        throw new CommandNotFoundException();

    }

}
