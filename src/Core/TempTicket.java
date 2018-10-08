package Core;

import User.User;

public class TempTicket {

    private String id;
    private User owner;
    private Flight flight;
    private Baggage baggage;
    private Airport departure;
    private Airport arrive;
    private int seat;
    private boolean roundtrip;

    public TempTicket(User owner, Airport departure, Airport arrive, boolean roundtrip){
        this.owner = owner;
        this.departure = departure;
        this.arrive = arrive;
        this.roundtrip = roundtrip;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrive() {
        return arrive;
    }


}
