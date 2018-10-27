package Core;

import User.User;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @autor Gruppo N
 */
public class Ticket {

    private String id;
    private Date date;
    private User user;
    private String holder;
    private Flight flight;
    private Baggage baggage;
    private Seat seat;
    private boolean checked;

    /**
     *
     * @param id The ID of the Ticket
     * @param user The User that owns the Ticket
     * @param holder The holder of the Ticket
     * @param flight The Flight associated to the Ticket
     * @param date The date of the Flight associated to the Ticket
     * @param baggage the Baggage associated to the Ticket
     * @param seat The Seat associated to the Ticket
     */
    public Ticket(String id, User user, String holder, Flight flight, Date date, Baggage baggage, Seat seat ){
        this.id = id;
        this.user = user;
        this.holder = holder;
        this.flight = flight;
        this.date = date;
        this.baggage = baggage;
        this.seat = seat;
        this.checked = false;
    }

    /**
     *
     * @return The ID of the Ticket
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return The username of the User that owns the Ticket
     */
    public String getUserName() {
        return user.getUsername();
    }

    /**
     *
     * @return The holder of the Ticket
     */
    public String getHolder() {
        return holder;
    }

    /**
     *
     * @ The ID of the Flight associated to the Ticket
     */
    public String getFlightId() {
        return flight.getId();
    }

    /**
     *
     * @return The name of the Departure Airport associated to the Ticket
     */
    public String getDepartureName(){
        return flight.getDepartureName();
    }

    /**
     *
     * @return The name of the Arrive Airport associated to the Ticket
     */
    public String getArriveName(){
        return flight.getArriveName();
    }

    /**
     *
     * @return The ID of the Airplane associated to the Ticket
     */
    public String getAirplaneID() {
        return flight.getAirplaneID();
    }

    /**
     *
     * @return The Baggage associated to the Ticket
     */
    public String getBaggage() {
        return String.valueOf(baggage.getType());
    }

    /**
     *
     * @return The Type of the Seat associated to the Ticket
     */
    public String getSeatType(){
        return String.valueOf(seat.getSeatType());
    }

    /**
     *
     * @return The Number of the Seat associated to the Ticket
     */
    public String geNSeat(){
        return seat.getNumber();
    }

    /**
     *
     * @return A String that represents the date associated to the Ticket
     */
    public String getDateString(){
        String sDate = new SimpleDateFormat("yyyy-MM-dd").format(this.date);
        return sDate;
    }

    /**
     *
     * @return  The Departure Time associated to the Ticket
     */
    public String getDepartureTime(){
        return flight.getDepartureTime();
    }

    /**
     *
     * @return The Arrive Time associated to the Ticket
     */
    public String getArriveTime(){
        return flight.getArriveTime();
    }

    /**
     * To run the check-in
     */
    public void checkIn(){
        this.checked = true;
    }

    /**
     *
     * @param checked The value to be attribute at the variable <code>checked</code>
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     *
     * @return If Ticket is checked or not
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     *
     * @return The preview string of the Ticket
     */
    public String previewString(){
        String str = "Holder: " + holder + "    || Seat: " + seat.getNumber() + "   || Baggage: " + baggage.getType();
        return str;
    }

    /**
     *
     * @return A string to resume the Ticket
     */
    @Override
    public String toString() {
        String s = "Flight: " + flight.getId() + "  || Date: " + getDateString() + "   || Airplane: " + flight.getAirplaneString() +
                "   || Seat: " + seat.getNumber() + "   || Holder: " + holder + "   || Baggage: " + baggage.getType();
        return s;
    }
}
