package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    private String ip;
    private int port;
    private Socket clientSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public Client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        clientSocket = new Socket(ip, port);
        socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void startClient() throws IOException {

        System.out.println("Connection estabilished");
        Scanner stdin = new Scanner(System.in);

        try {
            while (true){
                String inputLine = stdin.nextLine();
                sendMessage(inputLine);
                if(inputLine.equalsIgnoreCase("quit"))
                    break;
                String socketLine = socketIn.readLine();
                System.out.println(socketLine);
            }
        } catch (NoSuchElementException e){
            System.out.println("Connection closed");
        } finally {
            stdin.close();
            socketOut.close();
            socketIn.close();
            clientSocket.close();
        }

    }

    public void sendMessage(String message) {

        socketOut.println(message);
        System.out.println("Message sent: " + message);

    }

    /*La classe Client è costituita da una stringa che indica il proprio ip,un intero che indica la porta con cui comunicherà con il server,un oggetto Socket che tramite l'indirzzo ip ed il numero di porta,permette la connessione al server.
        * Un oggetto PrintWriter che ,ed un oggetto BufferReader che interagisce  */


}
