package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MainPageFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    private JPanel pTitle = new JPanel();
    private JPanel pUsername = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblDisconnect = new JLabel("Disconnect");
    private JLabel lblUsername;
    private JButton btnSelectFlight = new JButton("Select Flight");
    private JButton btnGoToProfile = new JButton("Go To Your Profile");

    public MainPageFrame(Client client, User user) throws ParseException {
        super("Airline Company");
        setSize(300,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font f = new Font("",Font.HANGING_BASELINE,10);
        this.client = client;
        this.user = user;
        this.airlineCompany = new Company(client);
        lblDisconnect.setFont(f);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        lblUsername = new JLabel("Welcome " + user.getName() + " " + user.getSurname() + "!");
        pTitle.add(lblDisconnect);
        add(pTitle, BorderLayout.EAST);
        pUsername.add(lblUsername,BorderLayout.CENTER);
        add(pUsername,BorderLayout.CENTER);
        pButton.add(btnGoToProfile);
        pButton.add(btnSelectFlight);
        add(pButton,BorderLayout.SOUTH);
    }

    public void addListeners(){

        btnGoToProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame userFrame = new UserFrame(client, user);
                setVisible(false);
            }
        });

        btnSelectFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFlightFrame selectFlightFrame = new SelectFlightFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

    }

}
