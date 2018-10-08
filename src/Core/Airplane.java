package Core;

import java.util.List;

public class Airplane {

    private String id;
    private int economy;
    private int business;
    private Seat[] seats;

    public Airplane(String id, int economy, int business){
        this.id = id;
        this.economy = economy;
        this.business = business;
        this.seats = new Seat[economy+business];
    }


    public String getId() {
        return id;
    }

}
