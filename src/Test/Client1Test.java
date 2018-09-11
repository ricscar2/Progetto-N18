package Test;

import Web.Client;

import java.io.IOException;

public class Client1Test {

    public static void main(String[] args) throws IOException {

        Client c1 = new Client("127.1.0.0", 8080);
        c1.startClient();

    }

}
