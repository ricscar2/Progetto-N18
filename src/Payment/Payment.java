package Payment;

import User.User;

public abstract class Payment {

    private String id;
    private PaymentType type;
    private String owner;

    public Payment(String id, PaymentType type, String owner){
        this.id = id;
        this.type = type;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    /*La classe Payment è costituita da un tipo di pagamento ed un saldo del proprio conto.*/



}
