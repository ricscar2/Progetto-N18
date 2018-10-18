package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;
import Web.CommandAnalizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YourTicketsFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle ;
    private JList jList;
    private JButton btnBack;
    private JButton btnInfo;
    private JButton btnCheckIn;
    private JScrollPane scrollPane;

    public YourTicketsFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Your Tickets");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setSize(800,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    private void initComponents(){
        scrollPane = new JScrollPane();
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        lblTitle = new JLabel("Your Tickets");
        user.setAirlineCompany(airlineCompany);
        jList = new JList(user.getTicketsString().toArray());
        btnBack = new JButton("Back to Your Profile");
        btnInfo = new JButton("Current Ticket's Info");
        btnCheckIn = new JButton("Check-In");
        pTitle.add(lblTitle);
        scrollPane.setViewportView(jList);
        pInfo.add(scrollPane);
        pButton.add(btnBack);
        pButton.add(btnInfo);
        pButton.add(btnCheckIn);
    }

    private void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame userFrame = new UserFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketInfoFrame ticketInfoFrame = new TicketInfoFrame(client, user, airlineCompany, user.getTicketByIndex(jList.getSelectedIndex()));
                setVisible(false);
            }
        });

    }

}
