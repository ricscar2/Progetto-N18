package Test;

import Web.Client;

import java.io.IOException;

public class Client2Test {

    public static void main(String[] args) throws IOException {

        Client c2 = new Client("127.1.0.0", 8080);
        c2.startClient();

    }

}
