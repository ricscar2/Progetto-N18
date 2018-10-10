package Payment;

public class CreditCard extends Payment {

    public CreditCard(double balance) {
        super(PaymentType.CREDITCARD, balance);
    }

    /*La classe CreditCard,estende la classe Payment,prende gli attributi della sua superclasse,ovvero il PaymentType ed il Balance  */

}
