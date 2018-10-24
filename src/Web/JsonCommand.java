package Web;

import org.json.simple.JSONObject;

public class JsonCommand implements Command{

    private JSONObject jsonCommand;

    public JsonCommand(JSONObject jsonObject){
        this.jsonCommand = jsonObject;
    }

    public JsonCommand(String code){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
    }

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

    public JsonCommand(String code, String first, String second, String third, String fourth){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("id", first);
        jsonCommand.put("date", second);
        jsonCommand.put("eseat", third);
        jsonCommand.put("bseat", fourth);
    }


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

    public String getJsonString() {
        return jsonCommand.toJSONString();
    }

    @Override
    public String getCode() {
        return this.jsonCommand.get("code").toString();
    }

    @Override
    public String getParameter(String id){
        return jsonCommand.get(id).toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
