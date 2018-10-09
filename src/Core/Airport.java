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
/*La classe Airport prevede una stringa che indica il codice IATA dell'aereoporto,il nome dell'aereoporto,la città in cui si trova e la nazione.
  * Viene utilizzata all'interno della classe Flight,dove sarà presente l'aereoporto di partenza e quello di arrivo.
  * Nella classe Company, è presente una ArrayList di aereoporti*/
}
