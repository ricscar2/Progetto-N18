package Web;

import Eccezioni.CommandNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class ConnectedClient extends Thread {

    private Socket clientSocket;
    private int clientID = -1;
    private boolean running = true;
    private BufferedReader inputStream;
    private PrintWriter outputStream;
    private JSONParser jsonParser;
    private JsonCommand jsonCommand;
    private CommandAnalizer commandAnalizer;
    private String response;

    public ConnectedClient(Socket clientSocket, int clientID) throws IOException, SQLException {
        this.commandAnalizer = new CommandAnalizer();
        this.jsonParser = new JSONParser();
        this.response = "null";
        this.clientSocket = clientSocket;
        this.clientID = clientID;
        this.inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.outputStream = new PrintWriter(clientSocket.getOutputStream(), true);

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
                   jsonCommand = new JsonCommand((JSONObject) jsonParser.parse(clientCommand));
                   response = commandAnalizer.analize(jsonCommand);
                   outputStream.println(response);
                   System.out.println("Message sent: " + response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

    }

}
