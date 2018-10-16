package Eccezioni;

public class NoPaymentsMethodException extends Exception {
    public NoPaymentsMethodException(String mess){
        super(mess);
    }
}
