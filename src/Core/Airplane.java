package Core;

/**
 * @author Gruppo N
 */
public class Airplane {

    private String id;
    private int economy;
    private int business;
    private Seat[] seats;

    /**
     *
     * @param id The Identification Code of the Airplane
     * @param economy The number of Economy seats in the current airplane
     * @param business The number of Business seats in the current airplane
     */
    public Airplane(String id, int economy, int business){
        this.id = id;
        this.economy = economy;
        this.business = business;
        this.seats = new Seat[economy+business];
    }

    /**
     *
     * @return The Identification Code of the Airplane
     */
    public String getID() {
        return id;
    }

    public int getEconomy() {
        return economy;
    }

    public int getBusiness() {
        return business;
    }
}
