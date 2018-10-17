package GraphicalInterface;

import Web.Client;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FlyCalendarFrame extends CalendarFrame {

    private GregorianCalendar gregorianCalendar;
    


    public FlyCalendarFrame(Client client, String who) throws IOException {
        super(client, who);
    }

    @Override
    public String[] CalcoloGiorni(int n) {
        return super.CalcoloGiorni(n);
    }

    @Override
    public void addListeners() {
        super.addListeners();
    }

    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public void setInitFrame(SignInFrame frame) {
        super.setInitFrame(frame);
    }

    @Override
    public void setSelectFlightFrame2(SelectFlightFrame2 selectFlightFrame2) {
        super.setSelectFlightFrame2(selectFlightFrame2);
    }



    public String[] CalcoloAnni(){
        int d=10;
        int i;
        gregorianCalendar=new GregorianCalendar(2018,10,30);
        String[] anni=new String[d];
        anni[0]= Integer.toString(gregorianCalendar.get(Calendar.YEAR));

        for(i=0 ; i<10 ; i++){
            String k = new String(Integer.toString(i+(gregorianCalendar.get(Calendar.YEAR))));
            anni[i]=k;
        }
        return anni;
    }

}