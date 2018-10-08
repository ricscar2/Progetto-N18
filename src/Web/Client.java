package Web;

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
    private String response;

    public Client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        clientSocket = new Socket(ip, port);
        socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.response = "";
    }

    public void startClient() throws IOException {

        System.out.println("Connection estabilished");
        /*Scanner stdin = new Scanner(System.in);

          try {
            while (true){
                String inputLine = stdin.nextLine();
                sendMessage(inputLine);
                if(inputLine.equalsIgnoreCase("quit"))
                    break;
                response = socketIn.readLine();
                Response.setResponse(response);
                System.out.println(response);
            }
        } catch (NoSuchElementException e){
            System.out.println("Connection closed");
        } finally {
            stdin.close();
            socketOut.close();
            socketIn.close();
            clientSocket.close();
        }
*/
    }

    public void sendMessage(String message) {
        try {
            socketOut.println(message);
            System.out.println("Message sent: " + message);
            if (message.equalsIgnoreCase("quit")) {
                socketOut.close();
                socketIn.close();
                clientSocket.close();
                System.out.println("Connection closed");
            }
            response = socketIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResponse() {
        return this.response;
    }
}
