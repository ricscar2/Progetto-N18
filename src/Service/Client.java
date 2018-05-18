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

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {

        Socket clientSocket = new Socket(ip, port);
        System.out.println("Connection estabilished");

        PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Scanner stdin = new Scanner(System.in);

        try {
            while (true){
                String inputLine = stdin.nextLine();
                socketOut.println(inputLine);
                System.out.println("Message sent: " + inputLine);
                if(inputLine.equalsIgnoreCase("quit"))
                    break;
                // String socketLine = socketIn.readLine();
                // System.out.println(socketLine);
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

}
