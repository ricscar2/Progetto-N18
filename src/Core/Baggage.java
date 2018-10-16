package Core;

/**
 * @author Gruppo N
 */
public class Baggage {

    private BaggageType type;

    /**
     *
     * @param type The type of the Baggage
     */
    public Baggage(BaggageType type){
        this.type = type;
    }

    /**
     *
     * @return The type of the Baggage
     */
    public BaggageType getType() {
        return type;
    }

}
