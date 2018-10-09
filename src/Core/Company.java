package Core;

import User.User;
import Web.Client;
import Web.JsonCommand;
import Web.JsonResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private Client client;
    private JSONParser jsonParser;
    private ArrayList<Airport> airports;
    private ArrayList<Flight> flights;

    public Company(Client client) throws ParseException {
        this.client = client;
        this.jsonParser = new JSONParser();
        this.airports = new ArrayList<Airport>();
        setAirports(client);
    }

    private void setAirports(Client client) throws ParseException {
        client.sendMessage(new JsonCommand("02").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonAirports = (JSONArray) objRoot.get("airports");
        System.out.println(jsonAirports.toJSONString());
        for (int i = 0; i < jsonAirports.size(); i++){
            JSONObject currentAirport = (JSONObject) jsonAirports.get(i);
            this.airports.add(new Airport((String) currentAirport.get("iata"),(String) currentAirport.get("name"),
                    (String) currentAirport.get("city"), (String) currentAirport.get("nation")));
        }
    }

    public ArrayList<String> getAirportsNames(){
        ArrayList<String> airportsNames = new ArrayList<String>();
        for (Airport a: this.airports) {
            airportsNames.add(a.getName());
        }
        return airportsNames;
    }
/*La classe Company ha un oggetto Client,una ArrayList di Airports ed una ArrayList di Flights     */
}
