package Eccezioni;

public class CommandNotFoundException extends Exception {

    public CommandNotFoundException(){

        super("The request command not exists");
    }



}
