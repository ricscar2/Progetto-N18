package Eccezioni;

/**
 * @author Gruppo N
 */
public class CommandNotFoundException extends Exception {

    /**
     * Default Exception Message
     */
    public CommandNotFoundException(){
        super("The request command not exists");
    }

    /**
     *
     * @param ex The Exception Message
     */
    public CommandNotFoundException(String ex){
        super(ex);
    }

}
