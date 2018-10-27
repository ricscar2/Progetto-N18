import GraphicalInterface.LogInFrame;
import Web.Client;
import Web.JsonCommand;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @autor Gruppo N
 */
public class MainClassTest {

    Client c = new Client("127.1.0.0", 8080);
    LogInFrame login = new LogInFrame(c);


    public MainClassTest() throws IOException {

    }

    /**
     * Test if LogIn Works (True)
     * @throws IOException
     */
    @Test
    public void testTrue() throws IOException {
        c.sendMessage(new JsonCommand("00", "aaa", "aaa").getJsonString());
        Assert.assertEquals("{\"birthdate\":\"1996-02-03\",\"usr\":\"aaa\",\"nation\":\"Italy\",\"surname\":\"CognomeProva\",\"name\":\"NomeProva\",\"pwd\":\"aaa\",\"email\":\"prova@prova.it\"}", c.getResponse());

    }

    /**
     * Test if LogIn Works (False)
     * @throws IOException
     */
    @Test
    public void testFalse() throws IOException {
        c.sendMessage(new JsonCommand("00", "Nicola", "Cassinera").getJsonString());
        Assert.assertEquals("false", c.getResponse());
    }

    /**
     * Test to create the User with the corresponding info
     * @throws IOException
     */
    @Test
    public void testAfterLogin() throws IOException {
        c.sendMessage(new JsonCommand("01", "alessandrabianchi", "passworda", "Alessandra", "Bianchi","1996-06-06", "Italy", "alessandrabianchi@prova.it" ).getJsonString());
        Assert.assertEquals("true", c.getResponse());

    }

    /**
     * Test to get all the Airports
     */
    @Test
    public void testAirports(){
        c.sendMessage(new JsonCommand("02").getJsonString());
        Assert.assertEquals("{\"airports\":[{\"iata\":\"AOI\",\"city\":\"Ancona\",\"nation\":\"Italy\",\"name\":\"Ancona - Falconara\"},{\"iata\":\"BGY\",\"city\":\"Bergamo\",\"nation\":\"Italy\",\"name\":\"Bergamo Orio al Serio\"},{\"iata\":\"BRI\",\"city\":\"Bari\",\"nation\":\"Italy\",\"name\":\"Bari - Palese\"},{\"iata\":\"CAG\",\"city\":\"Cagliari\",\"nation\":\"Italy\",\"name\":\"Cagliari - Elmas\"},{\"iata\":\"FCO\",\"city\":\"Roma\",\"nation\":\"Italy\",\"name\":\"Roma Fiumicino\"},{\"iata\":\"GOA\",\"city\":\"Genova\",\"nation\":\"Italy\",\"name\":\"Genova Cristoforo Colombo\"},{\"iata\":\"LIN\",\"city\":\"Milano\",\"nation\":\"Italy\",\"name\":\"Milano Linate\"},{\"iata\":\"MXP\",\"city\":\"Milano\",\"nation\":\"Italy\",\"name\":\"Milano Malpensa\"},{\"iata\":\"TRN\",\"city\":\"Torino\",\"nation\":\"Italy\",\"name\":\"Torino - Caselle\"},{\"iata\":\"VCE\",\"city\":\"Venezia\",\"nation\":\"Italy\",\"name\":\"Venezia - Tessera\"}]}", c.getResponse());
    }

    /**
     * Test if CheckIn works
     */
   @Test
    public void testCheckIn(){
        c.sendMessage(new JsonCommand("14", "MXPFCO001E5330102018").getJsonString());
        Assert.assertEquals("CHECKED",c.getResponse());
   }


}
