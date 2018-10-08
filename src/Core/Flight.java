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

    public String getDepartureName() {
        return departure.getName();
    }

    public String getArriveName() {
        return arrive.getName();
    }


}
