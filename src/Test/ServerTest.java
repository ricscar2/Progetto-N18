package Test;

import Web.Server;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Gruppo N
 */
public class ServerTest {

    /**
     * Main to start the application (Server)
     * @param args
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {

        Server server = new Server(8080);
        server.startServer();

    }

}
