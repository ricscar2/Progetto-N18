package Service;

import java.io.*;
import java.net.Socket;

public class ConnectedClient extends Thread {

    private Socket clientSocket;
    private int clientID = -1;
    private boolean running = true;
    private BufferedReader inputStream;
    private PrintWriter outputStream;

    public ConnectedClient(Socket clientSocket, int clientID) throws IOException {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
        inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outputStream = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

    }

    public void run() {
        System.out.println("New Client accepted: ID: " + clientID + " Address: "
                + clientSocket.getInetAddress().getHostName());
        try {

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
