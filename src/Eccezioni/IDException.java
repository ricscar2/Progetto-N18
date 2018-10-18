package Eccezioni;

public class IDException extends Exception {

    public IDException(){
        super("Method's ID must be composed by 16 numbers!");
    }

    public IDException(String mess){
        super(mess);
    }



}
