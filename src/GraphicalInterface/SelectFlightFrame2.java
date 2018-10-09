package GraphicalInterface;

import Core.Company;
import Core.Flight;
import Core.TempTicket;
import User.User;
import Web.Client;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectFlightFrame2 extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private TempTicket tempTicket;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight;
    private JLabel lblTime = new JLabel("Select your Flight:");
    private JComboBox cmbTime;
    private JButton btnBack = new JButton("Back");
    private JButton btnNext = new JButton("Next");



    public SelectFlightFrame2(Client client, User user, Company airlineCompany, TempTicket tempTicket){
        super("Airline Company - Select Flight");
        this.airlineCompany = airlineCompany;
        this.tempTicket = tempTicket;
        this.client = client;
        this.user = user;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents(){
        getFlights();
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pTitle.add(lblSelectFlight);
        pDepArr.setLayout(new GridLayout(1,2));
        pDepArr.add(lblTime);
        pDepArr.add(cmbTime);
        pButton.add(btnBack);
        pButton.add(btnNext);
    }

    private void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFlightFrame1 selectFlightFrame1 = new SelectFlightFrame1(client, user, airlineCompany);
            }
        });

    }

    private void getFlights(){
       // System.out.println(tempTicket.getDeparture().getName());
       // System.out.println(tempTicket.getArrive().getName());
        ArrayList<Flight> flights = airlineCompany.getSelectedFlights(tempTicket.getDeparture().getName(), tempTicket.getArrive().getName());
        ArrayList<String> strings = new ArrayList<String>();
        for (Flight f: flights) {
            strings.add(f.getDepartureName() + " " + f.getArriveName());
        }
        String[] lineArray = strings.toArray(new String[]{});
        this.cmbTime = new JComboBox<>(lineArray);
    }

}
