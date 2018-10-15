package Core;

import User.User;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
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
    private int nEconomy;
    private int nBusiness;
    private String nSeat;
    private ArrayList<Ticket> tickets;

    public TempTicket(Client client, User user, Airport departure, Airport arrive, boolean roundtrip){
        this.client = client;
        this.user = user;
        this.departure = departure;
        this.arrive = arrive;
        this.roundtrip = roundtrip;
        this.number = 0;
        this.nEconomy = 0;
        this.nBusiness = 0;
        this.tickets = new ArrayList<Ticket>();
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
        String id = createID(seatType);
        Baggage baggage = new Baggage(BaggageType.valueOf(baggageType));
        Seat seat = new Seat(SeatType.valueOf(seatType), nSeat);
        Ticket ticket = new Ticket(id, user, holder, flight, date, baggage, seat);
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public String createID(String seatType) throws org.json.simple.parser.ParseException {
        nSeat = new String("");
        JSONParser jsonParser = new JSONParser();
        String s = flight.getId();
        if(seatType.equals("ECONOMY")){
            client.sendMessage(new JsonCommand("07", flight.getId(), getDateString(), "ECONOMY").getJsonString());
            JSONObject rSeat = (JSONObject) jsonParser.parse(client.getResponse());
            nSeat = "E" + rSeat.get("economy");
            nEconomy++;
            s = s + nSeat;
            client.sendMessage(new JsonCommand("08", flight.getId(), getDateString(),"ECONOMY").getJsonString());
        }
        else if (seatType.equals("BUSINESS")){
            client.sendMessage(new JsonCommand("07", flight.getId(), getDateString(), "BUSINESS").getJsonString());
            JSONObject rSeat = (JSONObject) jsonParser.parse(client.getResponse());
            nSeat = "B" + rSeat.get("business");
            nBusiness++;
            s = s + nSeat;
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

    public void bookTickets(){
        for (Ticket t : tickets) {
            client.sendMessage(new JsonCommand("11", t.getId(), t.getUserName(), t.getHolder(), t.getFlightId(), getDateString(),
                    t.getBaggage(), t.getSeatType(), t.geNSeat()).getJsonString());
            user.addTicket(t);
        }
    }

    public void resetTickets(){
        this.tickets = new ArrayList<Ticket>();
        for (int i = 0; i < nEconomy; i++)
            client.sendMessage(new JsonCommand("09", flight.getId(), getDateString()).getJsonString());
        for (int i = 0; i < nBusiness; i++)
            client.sendMessage(new JsonCommand("10", flight.getId(), getDateString()).getJsonString());
        number -= (nEconomy + nBusiness);
    }

}
