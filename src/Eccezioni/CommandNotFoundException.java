package Eccezioni;

public class CommandNotFoundException extends Exception {

    public CommandNotFoundException(){
        super("The request command not exists");
    }

    public CommandNotFoundException(String ex){
        super(ex);
    }

}
