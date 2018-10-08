package Test;

import Web.Server;

import java.io.IOException;
import java.sql.SQLException;

public class ServerTest {

    public static void main(String[] args) throws IOException, SQLException {

        Server server = new Server(8080);
        server.startServer();

    }

}
