package Eccezioni;

public class FlightNotAvailableException extends Exception {
    public FlightNotAvailableException(String mess){
        super(mess);
    }
}
