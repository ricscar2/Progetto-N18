package User;

import Core.Ticket;

import java.util.Date;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String nation;
    private String email;
    private Date birthdate;
    private List<Ticket> tickets;

    public User(String username, String password, String name, String surname, Date birthdate, String nation, String email){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.nation = nation;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
