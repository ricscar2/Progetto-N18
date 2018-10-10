package Eccezioni;

public class DifferentPasswordException extends Exception {
    public DifferentPasswordException(String mess){
        super(mess);
    }

    /*La classe DifferentPasswordException è un eccezione,che viene lanciata quando,al momento della registrazione,la password e la confirmpassword non coincidono. */
}
