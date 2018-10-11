package GraphicalInterface;

import Core.*;
import User.User;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    private JLabel lblGoing = new JLabel("Select your Going's Flight:");
    private JComboBox cmbGoing;
    private JLabel lblReturn = new JLabel("Select your Return's Flight:");
    private JComboBox cmbReturn;
    private JButton btnBack = new JButton("Back");
    private JButton btnNext = new JButton("Next");



    public SelectFlightFrame2(Client client, User user, Company airlineCompany, TempTicket tempTicket) {
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

    private void initComponents() {
        getFlights();
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pTitle.add(lblSelectFlight);
        pDepArr.setLayout(new GridLayout(2,2));
        pDepArr.add(lblGoing);
        pDepArr.add(cmbGoing);
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

    }

    private void getFlights(){
        ArrayList <String> goingFlights = airlineCompany.getSelectedFlights(tempTicket.getDepartureIATA(), tempTicket.getArriveIATA());
        String[] goingArray = goingFlights.toArray(new String[]{});
        this.cmbGoing = new JComboBox<>(goingArray);
        if (tempTicket.isRoundtrip() == true){
            ArrayList <String> returnFlights = airlineCompany.getSelectedFlights(tempTicket.getArriveIATA(), tempTicket.getDepartureIATA());
            String[] returnArray = returnFlights.toArray(new String[]{});
            this.cmbReturn = new JComboBox<>(returnArray);
            pDepArr.add(lblReturn);
            pDepArr.add(cmbReturn);
        }
    }

}
