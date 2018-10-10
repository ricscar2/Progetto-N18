package Payment;

public abstract class Payment {

    private PaymentType type;
    private double balance;

    public Payment(PaymentType type, double balance){
        this.type = type;
        this.balance = balance;
    }

    /*La classe Payment è costituita da un tipo di pagamento ed un saldo del proprio conto.*/



}
