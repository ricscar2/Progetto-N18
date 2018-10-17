package GraphicalInterface;

import Core.Company;
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
    private Company airlineCompany;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JPanel pLabels;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel lblUsername1;
    private JLabel lblEmail;
    private JLabel lblEmail1;
    private JLabel lblName;
    private JLabel lblName1;
    private JLabel lblSurname;
    private JLabel lblSurname1;
    private JLabel lblBirthday;
    private JLabel lblBirthday1;
    private JLabel lblNation;
    private JLabel lblNation1;
    private JButton btnPayments;
    private JButton btnTickets;
    private JButton btnBack;

    public UserFrame(Client client, User user,Company airlineCompany){
        super("Airline Company - User's Info");
        this.user = user;
        this.client = client;
        this.airlineCompany=airlineCompany;
        setSize(400,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font f = new Font("",Font.HANGING_BASELINE,10);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        pLabels = new JPanel(new GridLayout(6,2));
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);



        lblTitle = new JLabel("Account's Info");
        lblUsername = new JLabel("Username: ");
        lblUsername1 = new JLabel(user.getUsername());
        lblUsername1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblEmail = new JLabel("Email: ");
        lblEmail1 = new JLabel(user.getEmail());
        lblEmail1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblName = new JLabel("Name: ");
        lblName1 = new JLabel(user.getName());
        lblName1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblSurname = new JLabel("Surname: ");
        lblSurname1 = new JLabel(user.getSurname());
        lblSurname1.setFont(new Font("SansSerif",Font.PLAIN,10));
        lblBirthday = new JLabel("Birthday: ");
        lblBirthday1 = new JLabel(user.getBirthdateString());
        lblBirthday1.setFont(new Font( "SansSerif",Font.PLAIN,10));
        lblNation = new JLabel("Nation: " );
        lblNation1 = new JLabel(user.getNation());
        lblNation1.setFont(new Font("SansSerif",Font.PLAIN,10));
        btnPayments = new JButton("Payment Methods");
        btnTickets = new JButton("Your Tickets");
        btnBack = new JButton("Go Back");
        pTitle.add(lblTitle);
        pInfo.add(pLabels);
        pLabels.add(lblUsername);
        pLabels.add(lblUsername1);
        pLabels.add(lblEmail);
        pLabels.add(lblEmail1);
        pLabels.add(lblName);
        pLabels.add(lblName1);
        pLabels.add(lblSurname);
        pLabels.add(lblSurname1);
        pLabels.add(lblBirthday);
        pLabels.add(lblBirthday1);
        pLabels.add(lblNation);
        pLabels.add(lblNation1);
        pButton.add(btnPayments);
        pButton.add(btnTickets);
        pButton.add(btnBack);
    }

    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user,airlineCompany);
                    setVisible(false);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnPayments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentMethodsFrame paymentMethodsFrame = new PaymentMethodsFrame(client, user,airlineCompany);
                setVisible(false);
            }
        });

        btnTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourTicketsFrame yourTicketsFrame = new YourTicketsFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

    }

}
