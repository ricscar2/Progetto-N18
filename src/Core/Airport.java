package Core;

/**
 * @author Gruppo N
 */
public class Airport {

    private String IATA;
    private String name;
    private String city;
    private String nation;

    /**
     *
     * @param IATA The IATA code of the Airport
     * @param name The official name of the Airport
     * @param city The city where the Airport is situated in
     * @param nation The nation where the Airport is situated in
     */
    public Airport(String IATA, String name, String city, String nation){
        this.IATA = IATA;
        this.name = name;
        this.city = city;
        this.nation = nation;
    }

    /**
     *
     * @return The IATA code of the Airport
     */
    public String getIATA() {
        return IATA;
    }

    /**
     *
     * @return The official name of the Airport
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The city where the Airport is situated in
     */
    public String getCity() {
        return city;
    }

}
