package Eccezioni;

public class NoTicketSelectedException extends Exception {

    public NoTicketSelectedException(){
        super("You must select a ticket!");
    }

}
