package GraphicalInterface;

import Web.Client;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Gruppo N
 */
public class FlyCalendarFrame extends CalendarFrame {

    private GregorianCalendar gregorianCalendar;

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param who The Frame that have called CalendarFrame
     * @throws IOException
     */
    public FlyCalendarFrame(Client client, String who) throws IOException {
        super(client, who);
    }

    /**
     *
     * @param n The number of Days in the current Month
     * @return The array of Days in the current Month
     */
    @Override
    public String[] CalcoloGiorni(int n) {
        return super.CalcoloGiorni(n);
    }

    /**
     * To initialize Graphical Components
     */
    @Override
    public void initComponents() {
        super.initComponents();
    }

    /**
     * To add the Listeners
     */
    @Override
    public void addListeners() {
        super.addListeners();
    }

    /**
     *
     * @return The computed Years
     */
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