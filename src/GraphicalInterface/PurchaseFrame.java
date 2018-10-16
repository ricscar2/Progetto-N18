package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import Eccezioni.NoPaymentsMethodException;
import Web.Client;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private TempTicket tempTicketDep;

    private JPanel pTitle = new JPanel();
    private JPanel pData = new JPanel();
    private JPanel pButtons = new JPanel();
    private JLabel lblTitle = new JLabel("Book Your Tickets!");
    private JLabel lblPrice = new JLabel("Total: ");
    private JLabel lblTotal = new JLabel("XXX $");
    private JLabel lblPayment = new JLabel("Select Payment Method: ");
    private JComboBox cmbPayment;
    private JButton btnAddPayment = new JButton("Add Payment Method");
    private JButton btnNext = new JButton("Book");
    private JButton btnBack = new JButton("Back");

    public PurchaseFrame(Client client, User user, Company airlineCompany, TempTicket tempTicketDep){
        super("Airline Company - Payment");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        this.tempTicketDep = tempTicketDep;
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        cmbPayment = new JComboBox(user.getPaymentMethodsStrings().toArray());
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pData, BorderLayout.CENTER);
        add(pButtons, BorderLayout.SOUTH);
        pData.setLayout(new BorderLayout());
        pTitle.add(lblTitle);
        pData.setLayout(new GridLayout(2,2));
        pData.add(lblPrice);
        pData.add(lblTotal);
        pData.add(lblPayment);
        pData.add(cmbPayment);
        pButtons.add(btnBack);
        pButtons.add(btnAddPayment);
        pButtons.add(btnNext);
    }


    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SummaryFrame summaryFrame = new SummaryFrame(client, user, airlineCompany, tempTicketDep);
                setVisible(false);
            }
        });

        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPaymentMethodFrame addPaymentMethodFrame = new AddPaymentMethodFrame(client, user, airlineCompany, tempTicketDep);
                setVisible(false);
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!(user.getPaymentMethods().size()==0)) {
                        tempTicketDep.bookTickets();
                        BookSuccessFrame bookSuccessFrame = new BookSuccessFrame(client, user, airlineCompany);
                        setVisible(false);
                    }else {
                        throw new NoPaymentsMethodException("Aggiungi metodo di pagamento");

                    }
                }catch (NoPaymentsMethodException e1){
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame();
                    eFrame.initComponents();
                    eFrame.Print(s);
                    

                }
            }
        });

    }


}

