package Eccezioni;

public class DifferentPasswordException extends Exception {
    public DifferentPasswordException(String mess){
        super(mess);
    }
}
