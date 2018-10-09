package User;

import Payment.*;
import Core.Ticket;
import Payment.Payment;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Client client;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String nation;
    private String email;
    private Date birthdate;
    private JSONParser jsonParser = new JSONParser();
    private ArrayList<Payment> paymentMethods;
    private List<Ticket> tickets;

    public User(Client client, String username, String password, String name, String surname, Date birthdate, String nation, String email) throws ParseException {
        this.client = client;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.nation = nation;
        this.email = email;
        this.paymentMethods = setPaymentMethods(client);
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getBirthdateString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(birthdate);
    }

    public String getNation() {
        return nation;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Payment> setPaymentMethods(Client client) throws ParseException {
        ArrayList<Payment> paymentMethods = new ArrayList<Payment>();
        client.sendMessage(new JsonCommand("05", this.username).getJsonString());
        JSONObject objRoot = (JSONObject) jsonParser.parse(client.getResponse());
        JSONArray jsonMethods = (JSONArray) objRoot.get("paymentMethods");
        //System.out.println(jsonAirplanes.toJSONString());
        for (int i = 0; i < jsonMethods.size(); i++){
            JSONObject currentPaymentMethod = (JSONObject) jsonMethods.get(i);
            switch ((String) currentPaymentMethod.get("method")){
                case "CREDITCARD":
                    paymentMethods.add(new CreditCard((String) currentPaymentMethod.get("id"), getUsername()));
            }
        }
        return paymentMethods;
    }

    public ArrayList<String> getPaymentMethodsStrings(){
        ArrayList<String> strings = new ArrayList<String>();
        for (Payment p: this.paymentMethods) {
            strings.add(p.toString());
        }
        return strings;
    }

    public void setPaymentMethod (Payment paymentMethod){
        this.paymentMethods.add(paymentMethod);
    }

}
