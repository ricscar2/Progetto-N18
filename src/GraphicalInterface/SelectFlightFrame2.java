package GraphicalInterface;

import Core.*;
import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class SelectFlightFrame2 extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private TempTicket tempTicket;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JPanel pCalendar = new JPanel();
    private JPanel pInfo = new JPanel();
    private JPanel pFields = new JPanel();
    private JLabel lblSelectFlight;
    private JLabel lblGoing = new JLabel("Select Going's Flight:");
    private JComboBox cmbGoing;
    private JLabel lblReturn = new JLabel("Select Return's Flight:");
    private JComboBox cmbReturn;
    private JLabel lblInfoDate = new JLabel("Select the date:");
    private JLabel lblDate = new JLabel("30-10-2018");
    private JButton btnBack = new JButton("Back");
    private JButton btnNext = new JButton("Next");
    private JButton btnCalendar =  new JButton("Select");
    private JLabel lblNumber = new JLabel("Number of People");
    private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private JComboBox cmbNumber = new JComboBox(numbers);


    public SelectFlightFrame2(Client client, User user, Company airlineCompany, TempTicket tempTicket) {
        super("Airline Company - Select Flight");
        this.airlineCompany = airlineCompany;
        this.tempTicket = tempTicket;
        this.client = client;
        this.user = user;
        setSize(650,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents() {
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pDepArr.setLayout(new BorderLayout());
        pTitle.add(lblSelectFlight);
        pDepArr.add(pInfo, BorderLayout.WEST);
        pDepArr.add(pFields, BorderLayout.CENTER);
        pInfo.setLayout(new GridLayout(4,1));
        pFields.setLayout(new GridLayout(4,1));
        getFlights();
        pInfo.add(lblInfoDate);
        pFields.add(pCalendar);
        pCalendar.add(lblDate);
        pCalendar.add(btnCalendar);
        pInfo.add(lblNumber);
        pFields.add(cmbNumber);
        pButton.add(btnBack);
        pButton.add(btnNext);
    }

    private void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFlightFrame1 selectFlightFrame1 = new SelectFlightFrame1(client, user, airlineCompany);
                setVisible(false);
            }
        });


        btnCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    FlyCalendarFrame flyCalendarFrame=null;
                    try {

                        flyCalendarFrame = new FlyCalendarFrame(client,"Select2");
                        setVisible(false);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    flyCalendarFrame.setSelectFlightFrame2(SelectFlightFrame2.this);

            }
        });


        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Flight> flights = airlineCompany.getSelectedFlights(tempTicket.getDepartureIATA(), tempTicket.getArriveIATA());
                tempTicket.setNumber(Integer.parseInt(cmbNumber.getSelectedItem().toString()));
                tempTicket.setFlight(flights.get(cmbGoing.getSelectedIndex()));
                try {
                    tempTicket.setDate(lblDate.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                TicketFrame ticketFrame = new TicketFrame(client, user, airlineCompany, tempTicket);
                setVisible(false);
            }
        });

    }

    private void getFlights(){
        ArrayList <String> goingFlights = airlineCompany.getSelectedFlightsString(tempTicket.getDepartureIATA(), tempTicket.getArriveIATA());
        String[] goingArray = goingFlights.toArray(new String[]{});
        this.cmbGoing = new JComboBox<>(goingArray);
        pInfo.add(lblGoing);
        pFields.add(cmbGoing);
        if (tempTicket.isRoundtrip() == true){
            ArrayList <String> returnFlights = airlineCompany.getSelectedFlightsString(tempTicket.getArriveIATA(), tempTicket.getDepartureIATA());
            String[] returnArray = returnFlights.toArray(new String[]{});
            this.cmbReturn = new JComboBox<>(returnArray);
            pInfo.add(lblReturn);
            pFields.add(cmbReturn);
        }
    }

    public void addData(String s){
        lblDate.setText(s);
    }

}
