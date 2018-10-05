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

    public JsonCommand(String code, String username, String password) {
        jsonCommand = new JSONObject();
        jsonCommand.put("code", code);
        jsonCommand.put("usr", username);
        jsonCommand.put("pwd", password);
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
