package Payment;

/**
 * @author Gruppo N
 */
public abstract class Payment {

    private String id;
    private PaymentType type;
    private String owner;

    /**
     *
     * @param id The ID of the Payment Method
     * @param type The Type of the Payment Method
     * @param owner The Owner of the Payment Method
     */
    public Payment(String id, PaymentType type, String owner){
        this.id = id;
        this.type = type;
        this.owner = owner;
    }

    /**
     *
     * @return The ID of the Payment Method
     */
    public String getId() {
        return id;
    }
}
