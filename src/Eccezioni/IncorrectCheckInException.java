package Eccezioni;

public class IncorrectCheckInException extends Exception {

    public IncorrectCheckInException(String ex){
        super(ex);
    }

    public IncorrectCheckInException(){
        super("The data does not belong to the owner");
    }

}
