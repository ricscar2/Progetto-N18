package Service;

import java.io.*;
import java.net.Socket;

public class ConnectedClient extends Thread {

    Socket clientSocket;
    int clientID = -1;
    boolean running = true;

    public ConnectedClient(Socket clientSocket, int clientID) {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
    }

    public void run() {
        System.out.println("New Client accepted: ID: " + clientID + " Address: "
                + clientSocket.getInetAddress().getHostName());
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputStream = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (running) {
                String clientCommand = inputStream.readLine();
                System.out.println("Client " + clientID + " says: " + clientCommand);
                if(clientCommand.equalsIgnoreCase("quit")) {
                    running = false;
                    inputStream.close();
                    outputStream.close();
                    clientSocket.close();

                    System.out.println("Client " + clientID + " has stopped thread");
                } else {
                    outputStream.println(clientCommand);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
