package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMethodsFrame extends JFrame {

    private User user;
    private Client client;
    private Company airlineCompany;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle;
    private JList jList;
    private JButton btnAddPayment;
    private JButton btnBack;
    private JScrollPane scrollPane;

    public PaymentMethodsFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Your Payment Methods");
        this.user = user;
        this.client = client;
        this.airlineCompany = airlineCompany;
        setSize(400,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        lblTitle = new JLabel("Your Payment Methods");
        jList = new JList(user.getPaymentMethodsStrings().toArray());
        btnBack = new JButton("Back");
        btnAddPayment = new JButton("Add Method");
        scrollPane = new JScrollPane();
        pTitle.add(lblTitle);
        scrollPane.setViewportView(jList);
        pInfo.add(scrollPane);
        pInfo.add(scrollPane);
        pButton.add(btnBack);
        pButton.add(btnAddPayment);
    }

    public void addListeners(){

      btnBack.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              UserFrame userFrame = new UserFrame(client, user, airlineCompany);
              setVisible(false);
          }
      });

      btnAddPayment.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
                AddPaymentMethodFrame addPaymentMethodFrame = new AddPaymentMethodFrame(client, user, airlineCompany, null);
                setVisible(false);
          }
      });

    }

}
