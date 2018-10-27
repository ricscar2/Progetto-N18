package Payment;

/**
 * @author Gruppo N
 */
public class CreditCard extends Payment {

    /**
     *
     * @param id The ID of the Credit Card
     * @param holder The Holder of the Credit Card
     */
    public CreditCard(String id, String holder) {
        super(id, PaymentType.CREDITCARD, holder);
    }

    /**
     *
     * @return A string that indicates the ID of the Credit Card
     */
    @Override
    public String toString() {
        return "Credit Card     ID: " + super.getId();
    }

}
