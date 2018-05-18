package Payment;

public class CreditCard extends Payment {

    public CreditCard(double balance) {
        super(PaymentType.CREDITCARD, balance);
    }

}
