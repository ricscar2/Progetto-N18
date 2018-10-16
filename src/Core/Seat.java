package Core;

/**
 * @author Gruppo N
 */
public class Seat {

    private SeatType seatType;
    private String number;

    /**
     *
     * @param seatType The Type of the Seat
     * @param number The Number of the Seat
     */
    public Seat(SeatType seatType, String number){
        this.seatType = seatType;
        this.number = number;
    }

    /**
     *
     * @return The Type of the Seat
     */
    public SeatType getSeatType() {
        return seatType;
    }

    /**
     *
     * @return The Number of the Seat
     */
    public String getNumber() {
        return number;
    }

}
