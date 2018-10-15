package Core;

public class Seat {

    private SeatType seatType;
    private String number;

    public Seat(SeatType seatType, String number){
        this.seatType = seatType;
        this.number = number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getNumber() {
        return number;
    }

}
