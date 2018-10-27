package Eccezioni;

/**
 * @author Gruppo N
 */
public class IDException extends Exception {

    /**
     * Default Exception Message
     */
    public IDException(){
        super("Method's ID must be composed by 16 numbers!");
    }

    /**
     *
     * @param mess The Exception Message
     */
    public IDException(String mess){
        super(mess);
    }



}
