package Eccezioni;

/**
 * @author Gruppo N
 */
public class NotYetBookedException extends Exception {

    /**
     * Default Exception Message
     */
    public NotYetBookedException(){
        super("Flight not yet booked on this day");
    }

    /**
     *
     * @param ex The Exception Message
     */
    public NotYetBookedException(String ex){
        super(ex);
    }

}
