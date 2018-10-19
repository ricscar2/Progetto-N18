package Eccezioni;

public class NoFlightSelectedException extends Exception {

    public NoFlightSelectedException(String ex){
        super(ex);
    }

    public NoFlightSelectedException(){
        super("You must select a flight!");
    }

}
