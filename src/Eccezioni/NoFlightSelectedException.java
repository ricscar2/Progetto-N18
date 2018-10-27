package Eccezioni;

/**
 * @author Gruppo N
 */
public class NoFlightSelectedException extends Exception {

    /**
     *
     * @param ex The Exception Message
     */
    public NoFlightSelectedException(String ex){
        super(ex);
    }

    /**
     * Default Exception Message
     */
    public NoFlightSelectedException(){
        super("You must select a flight!");
    }

}
