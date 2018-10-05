package GraphicalInterface;

import User.User;
import Web.Client;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {

    private User user;
    private Client client;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JPanel pLabels;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel lblEmail;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblBirthday;
    private JLabel lblNation;
    private JButton btnPayments;
    private JButton btnTickets;
    private JButton btnBack;

    public UserFrame(Client client, User user){
        super("Airline Company - User's Info");
        this.user = user;
        this.client = client;
        setSize(400,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        pLabels = new JPanel(new GridLayout(6,1));
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        lblTitle = new JLabel("Account's Info");
        lblUsername = new JLabel("Username: " + user.getUsername());
        lblEmail = new JLabel("Email: " + user.getEmail());
        lblName = new JLabel("Name: " + user.getName());
        lblSurname = new JLabel("Surname: " + user.getSurname());
        lblBirthday = new JLabel("Birthday: " + user.getBirthdateString());
        lblNation = new JLabel("Nation: " + user.getNation());
        btnPayments = new JButton("Payment Methods");
        btnTickets = new JButton("Your Tickets");
        btnBack = new JButton("Go Back");
        pTitle.add(lblTitle);
        pInfo.add(pLabels);
        pLabels.add(lblUsername);
        pLabels.add(lblEmail);
        pLabels.add(lblName);
        pLabels.add(lblSurname);
        pLabels.add(lblBirthday);
        pLabels.add(lblNation);
        pButton.add(btnPayments);
        pButton.add(btnTickets);
        pButton.add(btnBack);
    }

    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user);
                    setVisible(false);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
