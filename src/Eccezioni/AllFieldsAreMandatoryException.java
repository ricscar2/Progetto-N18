package Eccezioni;

public class AllFieldsAreMandatoryException extends Exception {
    public AllFieldsAreMandatoryException(String mess){
        super(mess);
    }

    /*La classe AllFieldsAreMandatory è un'eccezione che viene lanciata quando,al momento del SignIn,non vengono compilati tutti i campi d'inserimento(nome,cognome,email,...). */
}
