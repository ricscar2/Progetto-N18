package GraphicalInterface;

import Web.Client;

import java.io.IOException;

public class FlyCalendarFrame extends CalendarFrame {
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
        String[] anni=new String[d];
        anni[0]="2018";

        for(i=0 ; i<10 ; i++){
            String k = new String(Integer.toString(i+2018));
            anni[i]=k;
        }
        return anni;
    }

}