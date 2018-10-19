package Core;

/**
 * @author Gruppo N
 */
public class Flight {

    private String id;
    private Airport departure;
    private Airport arrive;
    private String departureTime;
    private String arriveTime;
    private Airplane airplane;

    /**
     *
     * @param id The Id of the Flight
     * @param departure The departure's Airport
     * @param arrive The arrive's Airport
     * @param departureTime The departure's Time
     * @param arriveTime The arrive's Time
     * @param airplane The Airplane of the current Flight
     */
    public Flight(String id, Airport departure, Airport arrive, String departureTime, String arriveTime, Airplane airplane){
        this.id = id;
        this.departure = departure;
        this.arrive = arrive;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.airplane = airplane;
    }

    /**
     *
     * @return The name of Departure's Airport
     */
    public String getDepartureName(){
        return departure.getName();
    }

    /**
     *
     * @return The name of Arrive's Airport
     */
    public String getArriveName(){
        return arrive.getName();
    }

    /**
     *
     * @return The ID of the current Flight's Airplane
     */
    public String getAirplaneID() {
        return airplane.getID();
    }

    /**
     *
     * @return IATA code of Departure's Airport
     */
    public String getDepartureIATA() {
        return departure.getIATA();
    }

    /**
     *
     * @return IATA code of Arrive's Airport
     */
    public String getArriveIATA() {
        return arrive.getIATA();
    }

    /**
     *
     * @return The Flight's ID
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return A string with Departure's Info
     */
    public String getDepartureString(){
        String str = "Departure: " + departure.getName() + " - " + departureTime;
        return str;
    }

    /**
     *
     * @return A string with Arrive's Info
     */
    public String getArriveString(){
        String str = "Arrive: " + arrive.getName() + " - " + arriveTime;
        return str;
    }

    /**
     *
     * @return A string with Airplane's ID
     */
    public String getAirplaneString(){
        String str = "Airplane: " + airplane.getID();
        return str;
    }

    /**
     *
     * @return The number of Economy's Seats in the current Flight
     */
    public String getESeat(){
        return String.valueOf(airplane.getEconomy());
    }

    /**
     *
     * @return The number of Business' Seats in the current Flight
     */
    public String getBSeat(){
        return String.valueOf(airplane.getBusiness());
    }

    /**
     *
     * @return The Departure's Time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     *
     * @return The Arrive's Time
     */
    public String getArriveTime() {
        return arriveTime;
    }

    /**ù
     *
     * @return A resume of the Flight's features
     */
    @Override
    public String toString() {
        String s = "Departure: " + departure.getName() + " " + departureTime + " - Arrive: " + arrive.getName() + " "
                + arriveTime;
        return s;
    }
}
