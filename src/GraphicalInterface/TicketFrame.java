package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import Core.Ticket;
import Eccezioni.AllFieldsAreMandatoryException;
import User.User;
import Web.Client;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class TicketFrame extends JFrame {

    private Client client;
    private Company airlineCompany;
    private User user;
    private TempTicket tempTicket;
    private String[] seatType = {"ECONOMY", "BUSINESS"};
    private String[] baggageType = {"HAND", "SMALL", "MEDIUM", "BIG"};

    private JPanel pTitle = new JPanel();
    private JPanel pData = new JPanel();
    private JPanel pButtons = new JPanel();
    private JLabel lblTitle = new JLabel("Enter Your Data!");
    private JLabel lblOwnerName = new JLabel("Name: ");
    private JLabel lblOwnerSurname = new JLabel("Surname: ");
    private JLabel lblSeat = new JLabel("Type of Seat");
    private JLabel lblBaggage = new JLabel("Type of Baggage");
    private JTextField txtOwnerName = new JTextField();
    private JTextField txtOwnerSurname = new JTextField();
    private JComboBox cmbSeat = new JComboBox(seatType);
    private JComboBox cmbBaggage = new JComboBox(baggageType);
    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");

    public TicketFrame(Client client, User user, Company airlineCompany, TempTicket tempTicket){
        super("Airline Company - Your Tickets");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        this.tempTicket = tempTicket;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents(){
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pData, BorderLayout.CENTER);
        add(pButtons, BorderLayout.SOUTH);
        pTitle.add(lblTitle);
        pData.setLayout(new GridLayout(4,2));
        pData.add(lblOwnerName);
        pData.add(txtOwnerName);
        pData.add(lblOwnerSurname);
        pData.add(txtOwnerSurname);
        pData.add(lblSeat);
        pData.add(cmbSeat);
        pData.add(lblBaggage);
        pData.add(cmbBaggage);
        pButtons.setLayout(new GridLayout(1,2));
        pButtons.add(btnBack);
        pButtons.add(btnNext);

    }

    private void addListeners(){

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!txtOwnerName.getText().equals("") && !txtOwnerSurname.getText().equals("")){
                        String holder = txtOwnerName.getText() + " " + txtOwnerSurname.getText();
                        int n = tempTicket.getNumber() - 1;
                        tempTicket.setNumber(n);
                        if (tempTicket.getNumber() > 0) {
                            try {
                                tempTicket.addTicket(holder, cmbSeat.getSelectedItem().toString(), cmbBaggage.getSelectedItem().toString());
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            TicketFrame ticketFrame = new TicketFrame(client, user, airlineCompany, tempTicket);
                            setVisible(false);
                        } else {
                            try {
                                tempTicket.addTicket(holder, cmbSeat.getSelectedItem().toString(), cmbBaggage.getSelectedItem().toString());
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            SummaryFrame summaryFrame = new SummaryFrame(client, user, airlineCompany, tempTicket);
                            setVisible(false);
                        }
                }else {
                        throw new AllFieldsAreMandatoryException("Tutti i campi devono essere riempiti");
                    }
                }catch (AllFieldsAreMandatoryException e1){
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame();
                    eFrame.initComponents();
                    eFrame.Print(s);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFlightFrame2 selectFlightFrame2 = new SelectFlightFrame2(client,user,airlineCompany,tempTicket);
                setVisible(false);
            }
        });

    }

}
