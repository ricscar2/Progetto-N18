package Core;

public class Seat {

    private SeatType seatType;

    public Seat(SeatType seatType){
        this.seatType = seatType;
    }

    public SeatType getSeatType() {
        return seatType;
    }

}

/*La classe Seat ha un intero che indica il numero del posto,ed un booleano che indice se quel posto è occupato o meno.    */

