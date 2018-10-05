package Web;

import org.json.simple.JSONObject;

public class JsonResponse {

    private JSONObject jsonResponse;

    public JsonResponse(JSONObject jsonObject){
        this.jsonResponse = jsonObject;
    }

    public JsonResponse(String username, String password, String name, String surname,
                       String birthdate, String nation, String email) {
        jsonResponse = new JSONObject();
        jsonResponse.put("usr", username);
        jsonResponse.put("pwd", password);
        jsonResponse.put("name", name);
        jsonResponse.put("surname", surname);
        jsonResponse.put("birthdate", birthdate);
        jsonResponse.put("nation", nation);
        jsonResponse.put("email", email);
    }

    public String getJsonString() {
        return jsonResponse.toJSONString();
    }

    public String getParameter(String id){
        return jsonResponse.get(id).toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
