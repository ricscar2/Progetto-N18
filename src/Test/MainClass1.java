package Test;

import GraphicalInterface.LogInFrame;
import Web.Client;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Gruppo N
 */
public class MainClass1 {

    /**
     * Main to start the Application (Client)
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws SQLException, IOException {

        Client c = new Client("127.0.0.1", 8080);
        LogInFrame program = new LogInFrame(c);
        c.startClient();

    }

}
