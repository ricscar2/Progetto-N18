package GraphicalInterface;

import Core.Company;
import Core.Ticket;
import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppo N
 */
public class TicketInfoFrame extends JFrame {

    private User user;
    private Client client;
    private Company airlineCompany;
    private Ticket ticket;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JPanel pLabels;
    private JLabel lblTitle;
    private JLabel lblID;
    private JLabel lblID1;
    private JLabel lblFlight;
    private JLabel lblFlight1;
    private JLabel lblDeparture;
    private JLabel lblDeparture1;
    private JLabel lblArrive;
    private JLabel lblArrive1;
    private JLabel lblDate;
    private JLabel lblDate1;
    private JLabel lblHolder;
    private JLabel lblHolder1;
    private JLabel lblAirplane;
    private JLabel lblAirplane1;
    private JLabel lblSeat;
    private JLabel lblSeat1;
    private JLabel lblBaggage;
    private JLabel lblBaggage1;
    private JLabel lblChecked;
    private JLabel lblChecked1;
    private JButton btnBack;

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param user The <code>User</code> Class's instance of the current Session
     * @param airlineCompany The <code>Company</code> Class' instance of the current Session
     * @param ticket The <code>Ticket</code> Class' instance of the Ticket to show in the current Session
     */
    public TicketInfoFrame(Client client, User user, Company airlineCompany, Ticket ticket){
        super("Airline Company - Ticket's Info");
        this.user = user;
        this.client = client;
        this.airlineCompany=airlineCompany;
        this.ticket = ticket;
        setSize(400,300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font f = new Font("",Font.HANGING_BASELINE,10);
        initComponents();
        addListeners();
    }

    /**
     * To initialize Graphical Components
     */
    public void initComponents(){
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        pLabels = new JPanel(new GridLayout(10,2));
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        lblTitle = new JLabel("Ticket's Info");
        lblID = new JLabel("ID: ");
        lblID1 = new JLabel(ticket.getId());
        lblID1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblFlight = new JLabel("Flight: ");
        lblFlight1 = new JLabel(ticket.getFlightId());
        lblFlight1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblDeparture = new JLabel("Departure: ");
        lblDeparture1 = new JLabel(ticket.getDepartureName() + "    At: " + ticket.getDepartureTime());
        lblDeparture1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblArrive = new JLabel("Arrive: ");
        lblArrive1 = new JLabel(ticket.getArriveName() + "    At: " + ticket.getArriveTime());
        lblArrive1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblDate = new JLabel("Date: ");
        lblDate1 = new JLabel(ticket.getDateString());
        lblDate1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblHolder = new JLabel("Holder: ");
        lblHolder1 = new JLabel(ticket.getHolder());
        lblHolder1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblAirplane = new JLabel("Ariplane: ");
        lblAirplane1 = new JLabel(ticket.getAirplaneID());
        lblAirplane1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblSeat = new JLabel("Seat: ");
        lblSeat1 = new JLabel(ticket.geNSeat() + "  (" + ticket.getSeatType() + ")");
        lblSeat1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblBaggage = new JLabel("Baggage: ");
        lblBaggage1 = new JLabel(ticket.getBaggage());
        lblBaggage1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblChecked = new JLabel("Checked: ");
        lblChecked1 = new JLabel(String.valueOf(ticket.isChecked()));
        lblChecked1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        btnBack = new JButton("Go Back");
        pTitle.add(lblTitle);
        pInfo.add(pLabels);
        pLabels.add(lblID);
        pLabels.add(lblID1);
        pLabels.add(lblFlight);
        pLabels.add(lblFlight1);
        pLabels.add(lblDeparture);
        pLabels.add(lblDeparture1);
        pLabels.add(lblArrive);
        pLabels.add(lblArrive1);
        pLabels.add(lblDate);
        pLabels.add(lblDate1);
        pLabels.add(lblHolder);
        pLabels.add(lblHolder1);
        pLabels.add(lblAirplane);
        pLabels.add(lblAirplane1);
        pLabels.add(lblSeat);
        pLabels.add(lblSeat1);
        pLabels.add(lblBaggage);
        pLabels.add(lblBaggage1);
        pLabels.add(lblChecked);
        pLabels.add(lblChecked1);
        pButton.add(btnBack);
    }

    /**
     * To add the Listeners
     */
    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourTicketsFrame yourTicketsFrame = new YourTicketsFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

    }

}
