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
    private JPanel pTitle = new JPanel();
    private JPanel pInfo15 = new JPanel();
    private JPanel pInfo23 = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblTitle = new JLabel("Select your Baggage");

    private JLabel lbl15 = new JLabel("Baggage 15kg");
    private JLabel lblCount15 = new JLabel("-");
    private JButton btnPlus15 = new JButton("+");
    private JButton btnLess15 = new JButton("-");


    private JLabel lbl23 = new JLabel("Baggage 23kg");
    private JLabel lblCount23 = new JLabel("-");
    private JButton btnPlus23 = new JButton("+");
    private JButton btnLess23 = new JButton("-");


    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");

    public BaggageFrame(Client client, User user){
        super("Airline Company - Baggage's Info");
        this.user = user;
        this.client = client;
        setSize(400,400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();


    }

    public void initComponents(){


        //pTitle.add(lblTitle);
        pInfo15.setLayout(new FlowLayout(2,2,2));
        pInfo15.add(lbl15);
        pInfo15.add(btnPlus15);
        pInfo15.add(lblCount15);
        pInfo15.add(btnLess15);

        pInfo23.setLayout(new FlowLayout(2,2,2));
        pInfo23.add(lbl23);
        pInfo23.add(btnPlus23);
        pInfo23.add(lblCount23);
        pInfo23.add(btnLess23);


        pButton.setLayout(new GridLayout(1,2));
        pButton.add(btnBack);
        pButton.add(btnNext);
        //add(pTitle,BorderLayout.NORTH);
        add(pInfo15,BorderLayout.NORTH);
        add(pInfo23,BorderLayout.CENTER);
        add(pButton,BorderLayout.SOUTH);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client,user);
                    setVisible(false);
                } catch (org.json.simple.parser.ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });

    }





}
