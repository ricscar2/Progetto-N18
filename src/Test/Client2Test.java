package Test;

import Web.Client;

import java.io.IOException;

/**
 * @author Gruppo N
 */
public class Client2Test {

    /**
     * Main to test Multithread Clients
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Client c2 = new Client("127.1.0.0", 8080);
        c2.startClient();

    }

}
