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
        this.airplanes = setAirplanes(client);
        this.airports = setAirports(client);
        this.flights = setFlights(client);
    }

    public ArrayList<Airport> setAirports(Client client) throws ParseException {
        ArrayList<Airport> airports = new ArrayList<Airport>();
        client.sendMessage(new JsonCommand("02").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonAirports = (JSONArray) objRoot.get("airports");
       // System.out.println(jsonAirports.toJSONString());
        for (int i = 0; i < jsonAirports.size(); i++){
            JSONObject currentAirport = (JSONObject) jsonAirports.get(i);
            airports.add(new Airport((String) currentAirport.get("iata"),(String) currentAirport.get("name"),
                    (String) currentAirport.get("city"), (String) currentAirport.get("nation")));
            //System.out.println(currentAirport);
        }
        return airports;
    }

    public ArrayList<Flight> setFlights(Client client) throws ParseException {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        client.sendMessage(new JsonCommand("03").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonFlights = (JSONArray) objRoot.get("flights");
        //System.out.println(jsonFlights.toJSONString());
        for (int i = 0; i < jsonFlights.size(); i++){
            JSONObject currentFlight = (JSONObject) jsonFlights.get(i);
            Airport a = getAirport((String) currentFlight.get("departure"));
            flights.add(new Flight((String) currentFlight.get("id"),getAirport((String) currentFlight.get("departure")),
                    getAirport((String) currentFlight.get("arrive")), (String) currentFlight.get("departuretime"),
                    (String) currentFlight.get("arrivetime"), getAirplane((String) currentFlight.get("airplane"))));
        }
        return flights;
    }

    public ArrayList<Airplane> setAirplanes(Client client) throws ParseException {
        ArrayList<Airplane> airplanes = new ArrayList<Airplane>();
        client.sendMessage(new JsonCommand("04").getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonAirplanes = (JSONArray) objRoot.get("airplanes");
        //System.out.println(jsonAirplanes.toJSONString());
        for (int i = 0; i < jsonAirplanes.size(); i++){
            JSONObject currentAirplane = (JSONObject) jsonAirplanes.get(i);
            airplanes.add(new Airplane((String) currentAirplane.get("id"), Integer.parseInt((String) currentAirplane.get("economy")),
            (Integer.parseInt((String) currentAirplane.get("business")))));
        }
        return airplanes;
    }

    public ArrayList<String> getAirportsNames(){
        ArrayList<String> airportsNames = new ArrayList<String>();
        for (Airport a: this.airports) {
            airportsNames.add(a.getName());
        }
        return airportsNames;
    }

    public ArrayList<String> getSelectedFlights(String departure, String arrive){
        ArrayList<String> fligthsString = new ArrayList<String>();
        for (Flight f: flights) {
               if (f.getDepartureIATA().equals(departure) && f.getArriveIATA().equals(arrive))
                   fligthsString.add(f.toString());
        }
        return fligthsString;
    }

    public Airport getAirport(String name){
        for (Airport a: this.airports) {
            if (a.getIATA().equals(name))
                return a;
        }
        return null;
    }

    public Airport getAirportByName(String name){
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
