package GraphicalInterface;

import Core.Airport;
import Core.Company;
import Web.Client;
import User.User;
import Web.JsonCommand;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SelectFlightFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight;
    private JLabel lblDeparture = new JLabel("Departure");
    private JComboBox cmbDeparture;
    private JComboBox cmbArrive;
    private JLabel lblArrive = new JLabel("Arrive");
    private JCheckBox chkDepArr = new JCheckBox("Roundtrip");
    private JButton btnBack = new JButton("Back To Home Page");
    private JButton btnNext = new JButton("Next");



    public SelectFlightFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Select Flight");
        this.airlineCompany = airlineCompany;
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
        getAirports();
        this.lblSelectFlight = new JLabel("Hi " + user.getName() + "! Select Your Flight!");
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pDepArr, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pTitle.add(lblSelectFlight);
        pDepArr.setLayout(new GridLayout(3,2));
        pDepArr.add(lblDeparture);
        pDepArr.add(cmbDeparture);
        pDepArr.add(lblArrive);
        pDepArr.add(cmbArrive);
        pDepArr.add(chkDepArr);
        pButton.add(btnBack);
        pButton.add(btnNext);
    }

    private void addListeners(){

    }

    private void getAirports(){
        String[] lineArray = airlineCompany.getAirportsNames().toArray(new String[]{});
        this.cmbDeparture = new JComboBox<>(lineArray);
        this.cmbArrive = new JComboBox<>(lineArray);
    }

}
