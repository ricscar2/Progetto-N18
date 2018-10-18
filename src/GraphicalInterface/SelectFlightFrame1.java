package GraphicalInterface;

import Core.Airport;
import Core.Company;
import Core.Flight;
import Core.TempTicket;
import Eccezioni.FlightNotAvailableException;
import Eccezioni.SameAirportException;
import Eccezioni.SameCityException;
import Web.Client;
import User.User;
import Web.JsonCommand;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectFlightFrame1 extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight;
    private JLabel lblDeparture = new JLabel("Departure :");
    private JComboBox cmbDeparture;
    private JComboBox cmbArrive;
    private JLabel lblArrive = new JLabel("Arrive :");
    private JCheckBox chkDepArr = new JCheckBox("Roundtrip");
    private JButton btnBack = new JButton("Back To Home Page");
    private JButton btnNext = new JButton("Next");



    public SelectFlightFrame1(Client client, User user, Company airlineCompany){
        super("Airline Company - Select Flight");
        this.airlineCompany = airlineCompany;
        this.client = client;
        this.user = user;

        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents(){
        getAirports();
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        lblSelectFlight.setFont(new Font("SansSerif",Font.PLAIN,20));
        setLayout(new BorderLayout());
        pTitle.add(lblSelectFlight);
        pDepArr.setLayout(new GridLayout(5,2));
        pDepArr.add(lblDeparture);
        pDepArr.add(cmbDeparture);
        pDepArr.add(lblArrive);
        pDepArr.add(cmbArrive);
        pDepArr.add(chkDepArr);
        pButton.add(btnBack);
        pButton.add(btnNext);
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);

        lblDeparture.setFont(new Font("DIALOG",Font.HANGING_BASELINE,15));
        lblArrive.setFont(new Font("DIALOG",Font.HANGING_BASELINE,15));
        cmbDeparture.setFont(new Font("SansSerif",Font.PLAIN,10));
        cmbArrive.setFont(new Font("SansSerif",Font.PLAIN,10));
    }

    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user,airlineCompany);
                    setVisible(false);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean roundtrip = false;
                if(chkDepArr.isSelected())
                    roundtrip = true;
                TempTicket tempTicket = new TempTicket(client,user, airlineCompany.getAirportByName(cmbDeparture.getSelectedItem().toString()),
                        airlineCompany.getAirportByName(cmbArrive.getSelectedItem().toString()), roundtrip);
                ArrayList<Flight> goingFlights = airlineCompany.getSelectedFlights(tempTicket.getDepartureIATA(), tempTicket.getArriveIATA());
                try {
                    if (tempTicket.getDeparture().getCity().equals(tempTicket.getArrive().getCity()) && tempTicket.getDepartureIATA() != tempTicket.getArriveIATA()) {
                        throw new SameCityException("Le città di partenza ed arrivo devono essere diverse");
                    }
                    if (goingFlights.size() == 0 && tempTicket.getDepartureIATA() != tempTicket.getArriveIATA()) {
                        throw new FlightNotAvailableException("Nessun Volo disponibile");
                    } else if (tempTicket.getDepartureIATA().equals(tempTicket.getArriveIATA())) {
                        throw new SameAirportException("Aereoporto Partenza/Arrivo Uguale");

                    }
                    SelectFlightFrame2 selectFlightFrame2 = new SelectFlightFrame2(client, user, airlineCompany, tempTicket);
                    setVisible(false);
                } catch (SameAirportException e1) {
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                } catch (FlightNotAvailableException e2) {
                    String s = e2.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                } catch (SameCityException e3) {
                    String s = e3.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                }


            }
        });



    }








    private void getAirports(){
        String[] lineArray = airlineCompany.getAirportsNames().toArray(new String[]{});
        this.cmbDeparture = new JComboBox<>(lineArray);
        this.cmbArrive = new JComboBox<>(lineArray);
    }

}
