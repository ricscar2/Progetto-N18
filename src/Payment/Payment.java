package Payment;

public abstract class Payment {

    private PaymentType type;
    private double balance;

    public Payment(PaymentType type, double balance){
        this.type = type;
        this.balance = balance;
    }



}
