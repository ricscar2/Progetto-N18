package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class BaggageFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private JPanel pSopra = new JPanel();
    private JPanel pTitle = new JPanel();
    private JPanel pInfo = new JPanel();
    private  JPanel pinfo2 = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblTitle = new JLabel("Select your Baggage");
    private JLabel lblHand = new JLabel("Hand Baggage");
    private JCheckBox hand = new JCheckBox();
    private JLabel lblCountHand = new JLabel("--");
    private JButton btnPlusHand = new JButton("+");
    private JButton btnLessHand = new JButton("-");
    private JLabel lbl23 = new JLabel("Other Baggage");
    private JLabel lblCount23 = new JLabel("-");
    private JButton btnPlus23 = new JButton("+");
    private JButton btnLess23 = new JButton("-");
    private int cont=0;


    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");

    public BaggageFrame(Client client, User user){
        super("Airline Company - Baggage's Info");
        this.user = user;
        this.client = client;
        setSize(400,200);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();


    }

    public void initComponents(){

        setLayout(new BorderLayout());
        pTitle.add(lblTitle);
        add(pTitle,BorderLayout.NORTH);
        pInfo.add(lblHand,BorderLayout.SOUTH);
        pInfo.add(hand, BorderLayout.SOUTH);

        pinfo2.add(lbl23,BorderLayout.SOUTH);
        pinfo2.add(btnPlusHand, BorderLayout.SOUTH);
        pinfo2.add(lblCountHand,BorderLayout.SOUTH);
        pinfo2.add(btnLessHand,BorderLayout.SOUTH);

        pSopra.setLayout(new GridLayout(2,1));
        pSopra.add(pInfo);
        pSopra.add(pinfo2);
        add(pSopra,BorderLayout.CENTER);
        pButton.add(btnBack);
        pButton.add(btnNext);
        add(pButton,BorderLayout.SOUTH);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client,user,airlineCompany);
                    setVisible(false);
                } catch (org.json.simple.parser.ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });

        btnLess23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont--;
                lblCountHand.setText(String.valueOf((cont)));
            }
        });

        btnPlus23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont++;
                lblCountHand.setText(String.valueOf(cont));
            }
        });

    }





}