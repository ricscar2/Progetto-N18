package Eccezioni;

/**
 * @author Gruppo N
 */
public class DifferentPasswordException extends Exception {

    /**
     *
     * @param mess The Exception Message
     */
    public DifferentPasswordException(String mess){
        super(mess);
    }

}
