package Test;

import GraphicalInterface.LogInFrame;
import Web.Client;

import java.io.IOException;
import java.sql.SQLException;

public class MainClass1 {

    public static void main(String[] args) throws SQLException, IOException {

        Client c = new Client("127.0.0.1", 8080);
        LogInFrame program = new LogInFrame(c);
        c.startClient();

    }

}
