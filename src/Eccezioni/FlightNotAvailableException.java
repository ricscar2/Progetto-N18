package Eccezioni;

/**
 * @author Gruppo N
 */
public class FlightNotAvailableException extends Exception {

    /**
     *
     * @param mess The Exception Message
     */
    public FlightNotAvailableException(String mess){
        super(mess);
    }

}
