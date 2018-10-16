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
    private JScrollPane scrollPane;

    public YourTicketsFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Your Tickets");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setSize(700,250);
        setVisible(true);
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
        jList = new JList(user.getTicketsStrng().toArray());
        btnBack = new JButton("Back to Your Profile");
        pTitle.add(lblTitle);
        scrollPane.setViewportView(jList);
        pInfo.add(scrollPane);
        pButton.add(btnBack);
    }

    private void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame userFrame = new UserFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

    }

}