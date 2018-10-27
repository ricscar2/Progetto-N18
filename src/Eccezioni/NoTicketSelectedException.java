package Eccezioni;

/**
 * @author Gruppo N
 */
public class NoTicketSelectedException extends Exception {

    /**
     * Default Exception Message
     */
    public NoTicketSelectedException(){
        super("You must select a ticket!");
    }

}
