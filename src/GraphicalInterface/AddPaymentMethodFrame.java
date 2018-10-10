package GraphicalInterface;

import Payment.CreditCard;
import User.User;
import Web.Client;
import Web.JsonCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPaymentMethodFrame extends JFrame {
    private User user;
    private Client client;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle;
    private JLabel lblID;
    private JLabel lblType;
    private JTextField txtID;
    private JComboBox cmbMethod;
    private JButton btnAdd;
    private JButton btnBack;

    public AddPaymentMethodFrame(Client client, User user){
        super("Airline Company - Add Payment Method");
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
        String[] methods = {"CREDITCARD"};
        txtID = new JTextField();
        cmbMethod = new JComboBox(methods);
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        pInfo.setLayout(new GridLayout(2,2));
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        lblID = new JLabel("ID: ");
        lblType = new JLabel("Type: ");
        lblTitle = new JLabel("Add New Payment's Method");
        btnBack = new JButton("Back");
        btnAdd = new JButton("Add Method");
        pTitle.add(lblTitle);
        pInfo.add(lblID);
        pInfo.add(txtID);
        pInfo.add(lblType);
        pInfo.add(cmbMethod);
        pButton.add(btnBack);
        pButton.add(btnAdd);
    }

    public void addListeners() {

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentMethodsFrame paymentMethodsFrame = new PaymentMethodsFrame(client, user);
                setVisible(false);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JsonCommand jsonCommand = new JsonCommand("06", txtID.getText(), cmbMethod.getSelectedItem().toString(), user.getUsername());
                client.sendMessage(jsonCommand.getJsonString());
                if (client.getResponse().equals("true")){
                    System.out.println("Metodo aggiunto con successo!");
                    switch (cmbMethod.getSelectedItem().toString()){
                        case "CREDITCARD":
                            user.setPaymentMethod(new CreditCard(txtID.getText(), user.getUsername()));
                    }
                    PaymentMethodsFrame paymentMethodsFrame = new PaymentMethodsFrame(client, user);
                    setVisible(false);
                }
                else
                    System.out.println("Failed");
            }
        });

    }

}
