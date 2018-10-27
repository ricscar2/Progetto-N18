package Eccezioni;

/**
 * @author Gruppo N
 */
public class NoPaymentsMethodException extends Exception {

    /**
     *
     * @param mess The Exception Message
     */
    public NoPaymentsMethodException(String mess){
        super(mess);
    }

}
