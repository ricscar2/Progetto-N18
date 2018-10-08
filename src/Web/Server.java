package Web;

import Web.ConnectedClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {

    private int serverPort;
    private int clientID = 0;

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    public void startServer() throws IOException, SQLException {

        // Open TCP port
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server socket ready on port: " + serverPort);

        // Waiting for clients
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ConnectedClient connectedClient = new ConnectedClient(clientSocket, clientID++);
            connectedClient.start();
        }

    }

}
