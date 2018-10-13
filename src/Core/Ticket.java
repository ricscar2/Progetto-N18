package Core;

import User.User;

import java.util.Date;

public class Ticket {

    private String id;
    private Date date;
    private User user;
    private String owner;
    private Flight flight;
    private Baggage baggage;
    private Seat seat;
    private boolean checked;

    public Ticket(String id, User user, String owner, Flight flight, Date date, Baggage baggage, Seat seat ){
        this.id = id;
        this.user = user;
        this.owner = owner;
        this.flight = flight;
        this.date = date;
        this.baggage = baggage;
        this.seat = seat;
        this.checked = false;
    }

    public boolean checkIn(){
        this.checked = true;
        return true;
    }

    public String previewString(){
        String str = "Holder: " + owner + "Seat: " + seat.getSeatType() + "Baggage: " + baggage.getType();
        return str;
    }


}
