package Web;

import org.json.simple.JSONObject;

public class JsonCommand{

    private JSONObject jsonCommand;

    public JsonCommand(JSONObject jsonObject){
        this.jsonCommand = jsonObject;
    }

    public JsonCommand(String code){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
    }

    public JsonCommand(String code, String username){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("username", username);
    }

    public JsonCommand(String code, String first, String second) {
        jsonCommand = new JSONObject();
        switch (code) {
            case "00":
                jsonCommand.put("code", code);
                jsonCommand.put("usr", first);
                jsonCommand.put("pwd", second);
                break;
            case "07":
                jsonCommand.put("code", code);
                jsonCommand.put("departure", first);
                jsonCommand.put("arrive", second);
                break;
        }
    }

    public JsonCommand(String code, String id, String method, String holder){
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("id", id);
        jsonCommand.put("method", method);
        jsonCommand.put("holder", holder);
    }

    public JsonCommand(String code, String username, String password, String name, String surname,
                       String birthdate, String nation, String email) {
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("usr", username);
        jsonCommand.put("pwd", password);
        jsonCommand.put("name", name);
        jsonCommand.put("surname", surname);
        jsonCommand.put("birthdate", birthdate);
        jsonCommand.put("nation", nation);
        jsonCommand.put("email", email);
    }

    public String getJsonString() {
        return jsonCommand.toJSONString();
    }

    public String getCode() {
        return this.jsonCommand.get("code").toString();
    }

    public String getParameter(String id){
        return jsonCommand.get(id).toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
