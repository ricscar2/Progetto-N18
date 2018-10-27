package Eccezioni;

/**
 * @author Gruppo N
 */
public class IncorrectCheckInException extends Exception {

    /**
     *
     * @param ex The Exception Message
     */
    public IncorrectCheckInException(String ex){
        super(ex);
    }

    /**
     * Default Exception Message
     */
    public IncorrectCheckInException(){
        super("The data does not belong to the owner");
    }

}
