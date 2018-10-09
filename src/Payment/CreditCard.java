package Payment;

import User.User;

public class CreditCard extends Payment {

    public CreditCard(String id, String holder) {
        super(id, PaymentType.CREDITCARD, holder);
    }

    @Override
    public String toString() {
        return "Credit Card     ID: " + super.getId();
    }

}
