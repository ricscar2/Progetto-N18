package Core;

public class Baggage {

    private BaggageType type;

    public Baggage(BaggageType type){
        this.type = type;
    }

    public BaggageType getType() {
        return type;
    }
//Nella classe Baggage,viene indica un oggetto BaggageType che va ad indicare il tipo di bagaglio dell'utente.Il bagaglio verrà inoltre indicato tra i dati del biglietto(Ticket)
}
