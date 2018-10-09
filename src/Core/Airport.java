package Core;

public class Airport {

    private String IATA;
    private String name;
    private String city;
    private String nation;

    public Airport(String IATA, String name, String city, String nation){
        this.IATA = IATA;
        this.name = name;
        this.city = city;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public String getIATA() {
        return IATA;
    }
}
