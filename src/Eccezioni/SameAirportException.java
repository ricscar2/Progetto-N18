package Eccezioni;

/**
 * @author Gruppo N
 */
public class SameAirportException extends Exception {

    /**
     *
     * @param mess The Exception Message
     */
    public SameAirportException(String mess){
        super(mess);
    }

}
