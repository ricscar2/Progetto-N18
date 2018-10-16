package Eccezioni;

public class NotYetBookedException extends Exception {

    public NotYetBookedException(){
        super("Flight not yet booked on this day");
    }

    public NotYetBookedException(String ex){
        super(ex);
    }

}
