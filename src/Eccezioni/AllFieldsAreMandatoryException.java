package Eccezioni;

/**
 * @author Gruppo N
 */
public class AllFieldsAreMandatoryException extends Exception {

    /**
     *
     * @param mess The Exception Message
     */
    public AllFieldsAreMandatoryException(String mess){
        super(mess);
    }

}
