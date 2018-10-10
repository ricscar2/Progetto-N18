package Payment;

public class CreditCard extends Payment {

    public CreditCard(String id, String holder) {
        super(id, PaymentType.CREDITCARD, holder);
    }
    @Override
    public String toString() {
        return "Credit Card     ID: " + super.getId();
    }
    /*La classe CreditCard,estende la classe Payment,prende gli attributi della sua superclasse,ovvero il PaymentType ed il Balance  */

}
