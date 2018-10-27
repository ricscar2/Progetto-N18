package Eccezioni;

/**
 * @autor Gruppo N
 */
public class InvalidLogInException extends Exception {

    /**
     *
     * @param ex The Exception Message
     */
    public InvalidLogInException(String ex){
        super(ex);
    }

    /**
     * Default Exception Message
     */
    public InvalidLogInException(){
        super("Invalid Username or Password!");
    }

}
