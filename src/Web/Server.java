package Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 * @author Gruppo N
 */
public class Server {

    private int serverPort;
    private int clientID = 0;

    /**
     *
     * @param serverPort The port used by the Server
     */
    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * This method starts the Server
     * @throws IOException
     * @throws SQLException
     */
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
