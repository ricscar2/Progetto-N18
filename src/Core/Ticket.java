package Core;

import User.User;

import java.util.Date;

public class Ticket {

    private String id;
    private Date date;
    private User user;
    private String holder;
    private Flight flight;
    private Baggage baggage;
    private Seat seat;
    private boolean checked;

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

    public String getId() {
        return id;
    }

    public String getUserName() {
        return user.getUsername();
    }

    public String getHolder() {
        return holder;
    }

    public String getFlightId() {
        return flight.getId();
    }

    public String getBaggage() {
        return String.valueOf(baggage.getType());
    }

    public String getSeatType(){
        return String.valueOf(seat.getSeatType());
    }

    public String geNSeat(){
        return seat.getNumber();
    }

    public boolean checkIn(){
        this.checked = true;
        return true;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String previewString(){
        String str = "Holder: " + holder + "Seat: " + seat.getNumber() + "Baggage: " + baggage.getType();
        return str;
    }

    @Override
    public String toString() {
        String s = "Flight: " + flight.getId() + " Date: " + date + " Airplane: " + flight.getAirplaneString() +
                "Seat: " + seat.getNumber() + " Holder: " + holder + " Baggage: " + baggage.getType();
        return s;
    }
}
