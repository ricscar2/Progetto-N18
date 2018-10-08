package Core;

import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.time.LocalTime;
import java.util.ArrayList;

public class Company {

    private Client client;
    private JSONParser jsonParser;
    private ArrayList<Airport> airports;
    private ArrayList<Flight> flights;
    private ArrayList<Airplane> airplanes;

    public Company(Client client) throws ParseException {
        this.client = client;
        this.jsonParser = new JSONParser();
        this.airports = new ArrayList<Airport>();
        this.airplanes = new ArrayList<Airplane>();
        this.flights = new ArrayList<Flight>();
        setAirplanes(client);
        setAirports(client);
        setFlights(client);
    }

    private void setAirports(Client client) throws ParseException {
        client.sendMessage(new JsonCommand("02").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonAirports = (JSONArray) objRoot.get("airports");
       // System.out.println(jsonAirports.toJSONString());
        for (int i = 0; i < jsonAirports.size(); i++){
            JSONObject currentAirport = (JSONObject) jsonAirports.get(i);
            this.airports.add(new Airport((String) currentAirport.get("iata"),(String) currentAirport.get("name"),
                    (String) currentAirport.get("city"), (String) currentAirport.get("nation")));
            System.out.println(currentAirport);
        }
    }

    public void setFlights(Client client) throws ParseException {
        client.sendMessage(new JsonCommand("03").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonFlights = (JSONArray) objRoot.get("flights");
        //System.out.println(jsonFlights.toJSONString());
        for (int i = 0; i < jsonFlights.size(); i++){
            JSONObject currentFlight = (JSONObject) jsonFlights.get(i);
            this.flights.add(new Flight((String) currentFlight.get("id"), getAirport((String) currentFlight.get("departure")),
                    getAirport((String) currentFlight.get("arrive")), (String) currentFlight.get("departuretime"),
                    (String) currentFlight.get("arrivetime"), getAirplane((String) currentFlight.get("airplane"))));
        }
    }

    private void setAirplanes(Client client) throws ParseException {
        client.sendMessage(new JsonCommand("04").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonAirplanes = (JSONArray) objRoot.get("airplanes");
        //System.out.println(jsonAirplanes.toJSONString());
        for (int i = 0; i < jsonAirplanes.size(); i++){
            JSONObject currentAirplane = (JSONObject) jsonAirplanes.get(i);
            this.airplanes.add(new Airplane((String) currentAirplane.get("id"), Integer.parseInt((String) currentAirplane.get("economy")),
            (Integer.parseInt((String) currentAirplane.get("business")))));
        }
    }

    public ArrayList<String> getAirportsNames(){
        ArrayList<String> airportsNames = new ArrayList<String>();
        for (Airport a: this.airports) {
            airportsNames.add(a.getName());
        }
        return airportsNames;
    }

    public ArrayList<Flight> getSelectedFlights(String departure, String arrive){
        ArrayList<Flight> fligthsString = new ArrayList<Flight>();
        for (Flight f: flights) {
               if (f.getDepartureName().equals(departure) && f.getArriveName().equals(arrive))
                   fligthsString.add(f);
        }
        return fligthsString;
    }

    public Airport getAirport(String name){
        for (Airport a: this.airports) {
            if (a.getName().equals(name))
                return a;
        }
        return null;
    }

    public Airplane getAirplane(String id){
        for (Airplane a: this.airplanes) {
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }

}
