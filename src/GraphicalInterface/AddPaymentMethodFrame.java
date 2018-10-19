package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import Eccezioni.IDException;
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
    private Company airlineCompany;
    private TempTicket tempTicketDep;
    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle;
    private JLabel lblID;
    private JLabel lblType;
    protected JTextField txtID;
    protected JComboBox cmbMethod;
    protected JButton btnAdd;
    protected JButton btnBack;

    public AddPaymentMethodFrame(Client client, User user,Company airlineCompany,TempTicket tempTicketDep){
        super("Airline Company - Add Payment Method");
        this.user = user;
        this.client = client;
        this.airlineCompany=airlineCompany;
        this.tempTicketDep=tempTicketDep;
        setSize(400,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    protected void initComponents(){
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

    protected void addListeners() {

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentMethodsFrame paymentMethodsFrame = new PaymentMethodsFrame(client, user,airlineCompany);
                setVisible(false);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtID.getText().length() == 16) {
                        boolean check=true;
                        for(int i=0;i<=txtID.getText().length()-1;i++) {
                            if (txtID.getText().charAt(i) >= 'a' && txtID.getText().charAt(i) <= 'z') {
                                check=false;
                                throw new IDException("Sono ammessi solo caratteri numerici");
                            }
                        }
                        if(check==true) {
                            JsonCommand jsonCommand = new JsonCommand("06", txtID.getText(), cmbMethod.getSelectedItem().toString(), user.getUsername());
                            client.sendMessage(jsonCommand.getJsonString());
                            if (client.getResponse().equals("true")) {
                                System.out.println("Metodo aggiunto con successo!");
                                switch (cmbMethod.getSelectedItem().toString()) {
                                    case "CREDITCARD":
                                        user.setPaymentMethod(new CreditCard(txtID.getText(), user.getUsername()));
                                }
                                    PaymentMethodsFrame paymentMethodsFrame = new PaymentMethodsFrame(client, user,airlineCompany);
                                    setVisible(false);
                            }
                        }else
                            System.out.println("Failed");
                    }else {
                        throw new IDException("Method's ID must be composed by 16 numbers!");
                    }
                }catch (IDException e1){
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                }
            }

        });

    }

}