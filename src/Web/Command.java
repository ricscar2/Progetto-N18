package Web;

/**
 * @author Gruppo N
 */
public interface Command {

    /**
     *
     * @return Identification Code of the Command
     */
    String getCode();

    /**
     *
     * @param id The Identification Code of the required parameter
     * @return The require parameter
     */
    String getParameter(String id);

}






