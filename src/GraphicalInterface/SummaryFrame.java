package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private TempTicket tempTicket;

    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle;
    private JLabel lblDate;
    private JLabel lblDeparture;
    private JLabel lblArrive;
    private JList jList;
    private JButton btnPayment;
    private JButton btnBack;
    private JScrollPane scrollPane = new JScrollPane();


    public SummaryFrame(Client client, User user, Company airlineCompany, TempTicket tempTicket){
        super("Airline Company - Summary");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        this.tempTicket = tempTicket;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        pInfo.setLayout(new FlowLayout());
        lblDate = new JLabel("Date: " + tempTicket.getDateString());
        lblDeparture = new JLabel(tempTicket.getFlight().getDepartureString());
        lblArrive = new JLabel(tempTicket.getFlight().getArriveString());
        lblTitle = new JLabel("Tickets Preview");
        jList = new JList(tempTicket.getTicketsPreview().toArray());
        btnBack = new JButton("Back");
        btnPayment = new JButton("Go to Payment");
        pTitle.add(lblTitle);
        pInfo.add(lblDate);
        pInfo.add(lblDeparture);
        pInfo.add(lblArrive);
        scrollPane.setViewportView(jList);
        pInfo.add(scrollPane);
        pButton.add(btnBack);
        pButton.add(btnPayment);
    }

    public void addListeners(){

        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaseFrame purchaseFrame = new PurchaseFrame(client, user, airlineCompany, tempTicket);
                setVisible(false);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempTicket.resetTickets();
                SelectFlightFrame2 selectFlightFrame2 = new SelectFlightFrame2(client, user, airlineCompany, tempTicket);
                setVisible(false);
            }
        });

    }

}
