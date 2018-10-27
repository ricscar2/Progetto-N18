package User;

import Core.*;
import Payment.*;
import Payment.Payment;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gruppo N
 */
public class User {

    private Client client;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String nation;
    private String email;
    private Date birthdate;
    private JSONParser jsonParser = new JSONParser();
    private ArrayList<Payment> paymentMethods;
    private List<Ticket> tickets;
    private ArrayList<Ticket> unTickets;
    private Company airlineCompany;

    /**
     *
     * @param client The <code>Client</code> of the current session
     * @param username The Username of the User
     * @param password The Password of the User
     * @param name The Name of the User
     * @param surname The Surname of the User
     * @param birthdate The birthdate of the User
     * @param nation The Nation of the User
     * @param email The Email of the User
     * @param airlineCompany An instance of the AirlineCompany
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public User(Client client, String username, String password, String name, String surname, Date birthdate, String nation, String email, Company airlineCompany) throws ParseException, java.text.ParseException {
        this.client = client;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.nation = nation;
        this.email = email;
        this.paymentMethods = setPaymentMethods(client);
        this.airlineCompany = airlineCompany;
        this.tickets = setTickets(client);
        this.unTickets = setUncheckedTickets();
    }

    /**
     *
     * @return A List of User's Payment Methods
     */
    public ArrayList<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     *
     * @return The Username of the User
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return The Name of the User
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The Surname of the User
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @return A String of the birthdate of the User
     */
    public String getBirthdateString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(birthdate);
    }

    /**
     *
     * @return The nation of the User
     */
    public String getNation() {
        return nation;
    }

    /**
     *
     * @return The email of the User
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param client The <code>Client</code> of the current session
     * @return The List of the Payment Methods owned by the User
     * @throws ParseException
     */
    public ArrayList<Payment> setPaymentMethods(Client client) throws ParseException {
        ArrayList<Payment> paymentMethods = new ArrayList<Payment>();
        client.sendMessage(new JsonCommand("05", this.username).getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonMethods = (JSONArray) objRoot.get("paymentMethods");
        //System.out.println(jsonAirplanes.toJSONString());
        for (int i = 0; i < jsonMethods.size(); i++){
            JSONObject currentPaymentMethod = (JSONObject) jsonMethods.get(i);
            switch ((String) currentPaymentMethod.get("method")){
                case "CREDITCARD":
                    paymentMethods.add(new CreditCard((String) currentPaymentMethod.get("id"), getUsername()));
            }
        }
        return paymentMethods;
    }

    /**
     *
     * @param client The <code>Client</code> of the current session
     * @return The List of the Tickets owned by the User
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public ArrayList<Ticket> setTickets(Client client) throws ParseException, java.text.ParseException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        client.sendMessage(new JsonCommand("12", this.username).getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonTickets = (JSONArray) objRoot.get("tickets");
        for (int i = 0; i < jsonTickets.size(); i++){
            JSONObject currentTicket = (JSONObject) jsonTickets.get(i);
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse((String) currentTicket.get("date"));
            boolean check = false;
            if (currentTicket.get("checked").equals("1"))
                check = true;
            Ticket ticket = new Ticket((String) currentTicket.get("id"), User.this, (String) currentTicket.get("holder"),
                    airlineCompany.getFlightById((String) currentTicket.get("flight")), date, new Baggage(BaggageType.valueOf((String) currentTicket.get("baggage"))),
                    new Seat(SeatType.valueOf((String) currentTicket.get("seat")),(String) currentTicket.get("nseat")));
            ticket.setChecked(check);
            tickets.add(ticket);
            }
        return tickets;
        }


    /**
     *
     * @return List of Strings with Payment Methods of the User
     */
    public ArrayList<String> getPaymentMethodsStrings(){
        ArrayList<String> strings = new ArrayList<String>();
        for (Payment p: this.paymentMethods) {
            strings.add(p.toString());
        }
        return strings;
    }

    /**
     *
     * @return List of Strings with Tickets of the User
     */
    public ArrayList<String> getTicketsString(){
        ArrayList<String> strings = new ArrayList<String>();
        for (Ticket t: this.tickets) {
            strings.add(t.toString());
        }
        return strings;
    }

    /**
     *
     * @return List of Strings with Unchecked Tickets of the User
     */
    public ArrayList<String> getTicketsToCheckString(){
        ArrayList<String> strings = new ArrayList<String>();
        for (Ticket t: this.unTickets) {
            strings.add(t.toString());
        }
        return strings;
    }

    /**
     *
     * @return The List of Unchecked Tickets of the User
     */
    private ArrayList<Ticket> setUncheckedTickets(){
        ArrayList<Ticket> uTickets = new ArrayList<Ticket>();
        for (Ticket t: this.tickets) {
            if (t.isChecked() == false){
                uTickets.add(t);
            }
        }
        return uTickets;
    }

    /**
     *
     * @param ticket The new Ticket that User has booked
     */
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
        if (ticket.isChecked() == false)
            this.unTickets.add(ticket);
    }

    /**
     *
     * @param ticket The Ticket to check-in
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public void checkIn(Ticket ticket) throws ParseException, java.text.ParseException {
        for (Ticket t: this.tickets) {
            if (t.equals(ticket)) t.checkIn();
            break;
        }
        this.tickets = setTickets(client);
        this.unTickets = setUncheckedTickets();
    }

    /**
     *
     * @param i The index of the Ticket of interest
     * @return The Ticket of interest
     */
    public Ticket getTicketByIndex(int i){
        return this.tickets.get(i);
    }

    /**
     *
     * @param i The index of the Checked Ticket of interest
     * @return The Checked Ticket of interest
     */
    public Ticket getCheckTicketByIndex(int i){
        return this.unTickets.get(i);
    }

    /**
     *
     * @param paymentMethod The Payment Method to set at the User
     */
    public void setPaymentMethod (Payment paymentMethod){
        this.paymentMethods.add(paymentMethod);
    }

}
