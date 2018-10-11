package Core;

public class Flight {

    private String id;
    private Airport departure;
    private Airport arrive;
    private String departureTime;
    private String arriveTime;
    private Airplane airplane;

    public Flight(String id, Airport departure, Airport arrive, String departureTime, String arriveTime, Airplane airplane){
        this.id = id;
        this.departure = departure;
        this.arrive = arrive;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.airplane = airplane;
    }

    public String getDepartureIATA() {
        return departure.getIATA();
    }

    public String getArriveIATA() {
        return arrive.getIATA();
    }

    public String getDepartureName() {
        return departure.getName();
    }

    public String getArriveName() {
        return arrive.getName();
    }

    @Override
    public String toString() {
        String s = "Departure: " + departure.getName() + " " + departureTime + " - Arrive: " + arrive.getName() + " "
                + arriveTime;
        return s;
    }
}
