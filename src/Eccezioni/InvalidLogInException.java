package Eccezioni;

public class InvalidLogInException extends Exception {

    public InvalidLogInException(String ex){
        super(ex);
    }

    public InvalidLogInException(){
        super("Invalid Username or Password!");
    }

}
