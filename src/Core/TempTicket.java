package Core;

import User.User;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TempTicket {

    private Client client;
    private User user;
    private Date date;
    private Flight flight;
    private Airport departure;
    private Airport arrive;
    private boolean roundtrip;
    private int number;
    private ArrayList<Ticket> tickets;

    public TempTicket(Client client,User user, Airport departure, Airport arrive, boolean roundtrip){
        this.client = client;
        this.user = user;
        this.departure = departure;
        this.arrive = arrive;
        this.roundtrip = roundtrip;
        this.number = 0;
        this.tickets = new ArrayList<Ticket>();
    }



    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrive() {
        return arrive;
    }

    public boolean isRoundtrip() {
        return roundtrip;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDepartureIATA(){
        return departure.getIATA();
    }

    public String getArriveIATA(){
        return arrive.getIATA();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setDate(String sDate) throws ParseException {
        Date date =new SimpleDateFormat("dd-MM-yyyy").parse(sDate);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString(){
        String sDate = new SimpleDateFormat("yyyy-MM-dd").format(this.date);
        return sDate;
    }

    public void addTicket(String holder, String seatType, String baggageType) throws org.json.simple.parser.ParseException {
        Baggage baggage = new Baggage(BaggageType.valueOf(baggageType));
        Seat seat = new Seat(SeatType.valueOf(seatType));
        String id = createID(seatType);
        Ticket ticket = new Ticket(id, user, holder, flight, date, baggage, seat);
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public String createID(String seatType) throws org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        String s = flight.getId();
        if(seatType.equals("ECONOMY")){
            client.sendMessage(new JsonCommand("07", flight.getId(), getDateString(), "ECONOMY").getJsonString());
            JSONObject rSeat = (JSONObject) jsonParser.parse(client.getResponse());
            s = s + "E" + rSeat.get("economy");
            client.sendMessage(new JsonCommand("08", flight.getId(), getDateString(),"ECONOMY").getJsonString());
        }
        else if (seatType.equals("BUSINESS")){
            client.sendMessage(new JsonCommand("07", flight.getId(), getDateString(), "BUSINESS").getJsonString());
            JSONObject rSeat = (JSONObject) jsonParser.parse(client.getResponse());
            s = s + "B" + rSeat.get("business");
            client.sendMessage(new JsonCommand("08", flight.getId(), getDateString(),"BUSINESS").getJsonString());
        }
        s = s + getDateString().substring(0,4) + getDateString().substring(5,7) + getDateString().substring(8,10);
        System.out.println(s);
        return s;
    }

    public ArrayList<String> getTicketsPreview(){
        ArrayList<String> strings = new ArrayList<String>();
        for (Ticket t: this.tickets) {
            strings.add(t.previewString());
        }
        return strings;
    }

    public void resetTickets(){
        this.tickets = new ArrayList<Ticket>();
    }

}

