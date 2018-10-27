package Web;

import org.json.simple.JSONObject;

/**
 * @author Gruppo N
 */
public class JsonCommand implements Command{

    private JSONObject jsonCommand;

    /**
     *
     * @param jsonObject The JSONObject which corresponds directly to the Command
     */
    public JsonCommand(JSONObject jsonObject){
        this.jsonCommand = jsonObject;
    }

    /**
     *
     * @param code The Code of the Command
     */
    public JsonCommand(String code){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
    }

    /**
     *
     * @param code The code of the Command (05, 12 or 14, depending on the case)
     * @param first The first parameter (username or id, depending on the case)
     */
    public JsonCommand(String code, String first){
        jsonCommand = new JSONObject();
        switch (code){
            case "05":
            case "12":
                jsonCommand.put("code", code);
                jsonCommand.put("username", first);
                break;
            case "14":
                jsonCommand.put("code", code);
                jsonCommand.put("id", first);
                break;
        }

    }

    /**
     *
     * @param code The code of the Command (00, 09 or 10, depending on the case)
     * @param first The first parameter (username or flight, depending on the case)
     * @param second The second parameter (password or date, depending on the case)
     */
    public JsonCommand(String code, String first, String second) {
        jsonCommand = new JSONObject();
        switch (code){
            case "00":
                jsonCommand.put("code", code);
                jsonCommand.put("usr", first);
                jsonCommand.put("pwd", second);
                break;
            case "09":
            case "10":
                jsonCommand.put("code", code);
                jsonCommand.put("flight", first);
                jsonCommand.put("date", second);
                break;
        }
    }

    /**
     *
     * @param code The code of the Command (06, 07 or 08, depending on the case)
     * @param first The first parameter (id or flight, depending on the case)
     * @param second The second parameter (payment method or date, depending on the case)
     * @param third The third parameter (holder or seat type, depending on the case)
     */
    public JsonCommand(String code, String first, String second, String third){
        jsonCommand = new JSONObject();
        switch (code) {
            case "06":
                jsonCommand.put("code", code);
                jsonCommand.put("id", first);
                jsonCommand.put("method", second);
                jsonCommand.put("holder", third);
                break;
            case "07":
            case "08":
                jsonCommand.put("code", code);
                jsonCommand.put("flight", first);
                jsonCommand.put("date", second);
                jsonCommand.put("seatType", third);
                break;
        }
    }

    /**
     *
     * @param code The code of the Command
     * @param first The id of the Flight
     * @param second The date of the Flight
     * @param third The number of Economy Seats in the current Flight
     * @param fourth Tne number of Business Seats in the current Flight
     */
    public JsonCommand(String code, String first, String second, String third, String fourth){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("id", first);
        jsonCommand.put("date", second);
        jsonCommand.put("eseat", third);
        jsonCommand.put("bseat", fourth);
    }


    /**
     *
     * @param code The code of the Command
     * @param first The username of the User
     * @param second The password associated to the current username
     * @param third The name of the User
     * @param fourth The surname of the User
     * @param fifth The birthdate of the User
     * @param sixth The nation of the User
     * @param seventh The email of the User
     */
    public JsonCommand(String code, String first, String second, String third, String fourth,
                       String fifth, String sixth, String seventh) {
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("usr", first);
        jsonCommand.put("pwd", second);
        jsonCommand.put("name", third);
        jsonCommand.put("surname", fourth);
        jsonCommand.put("birthdate", fifth);
        jsonCommand.put("nation", sixth);
        jsonCommand.put("email", seventh);
    }

    /**
     *
     * @param code The Code of the Command
     * @param first The id of the Ticket
     * @param second The username of the User
     * @param third The name of the Holder
     * @param fourth The id of the Flight
     * @param fifth The date of the current Flight
     * @param sixth The type of the current Baggage
     * @param seventh The type of the current Seat
     * @param eighth The number of the Seat
     */
    public JsonCommand(String code, String first, String second, String third, String fourth,
                       String fifth, String sixth, String seventh, String eighth){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("id", first);
        jsonCommand.put("user", second);
        jsonCommand.put("holder", third);
        jsonCommand.put("flight", fourth);
        jsonCommand.put("date", fifth);
        jsonCommand.put("baggage", sixth);
        jsonCommand.put("seat", seventh);
        jsonCommand.put("nSeat", eighth);
    }

    /**
     *
     * @return A String corresponding to the JSONString of the current JsonCommand
     */
    public String getJsonString() {
        return jsonCommand.toJSONString();
    }

    /**
     *
     * @return The Code of the current JsonCommand
     */
    @Override
    public String getCode() {
        return this.jsonCommand.get("code").toString();
    }

    /**
     *
     * @param id The Identification Code of the required parameter
     * @return The required parameter of the current JsonCommand
     */
    @Override
    public String getParameter(String id){
        return jsonCommand.get(id).toString();
    }

    /**
     *
     * @return The corresponding to the current JsonCommand
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
