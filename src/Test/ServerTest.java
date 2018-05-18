package Test;

import Service.Client;
import Service.ConnectedClient;
import Service.Server;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) throws IOException {

        Server server = new Server(8080);
        server.startServer();

    }

}
