package GraphicalInterface;

import Core.Company;
import Eccezioni.NoTicketSelectedException;
import User.User;
import Web.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppo N
 */
public class TicketToCheckFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    private JPanel pTitle;
    private JPanel pInfo;
    private JPanel pButton;
    private JLabel lblTitle ;
    private JList jList;
    private JButton btnBack;
    private JButton btnCheckIn;
    private JScrollPane scrollPane;

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param user The <code>User</code> Class's instance of the current Session
     * @param airlineCompany The <code>Company</code> Class' instance of the current Session
     */
    public TicketToCheckFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Check-In");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setSize(800,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    /**
     * To initialise Graphical Components
     */
    private void initComponents(){
        scrollPane = new JScrollPane();
        pTitle = new JPanel();
        pInfo = new JPanel();
        pButton = new JPanel();
        add(pTitle, BorderLayout.NORTH);
        add(pInfo, BorderLayout.CENTER);
        add(pButton, BorderLayout.SOUTH);
        lblTitle = new JLabel("Your Tickets to Check-In");
        jList = new JList(user.getTicketsToCheckString().toArray());
        btnBack = new JButton("Back");
        btnCheckIn = new JButton("Check-In");
        pTitle.add(lblTitle);
        scrollPane.setViewportView(jList);
        pInfo.add(scrollPane);
        pButton.add(btnBack);
        pButton.add(btnCheckIn);
    }

    /**
     * To add the Listeners
     */
    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourTicketsFrame yourTicketsFrame = new YourTicketsFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!(jList.getSelectedIndex()==-1)) {
                        CheckInFrame checkInFrame = new CheckInFrame(client, user, airlineCompany, user.getCheckTicketByIndex(jList.getSelectedIndex()));
                        setVisible(false);
                    } else throw new NoTicketSelectedException();
                } catch (NoTicketSelectedException ex){
                    ExceptionFrame eFrame = new ExceptionFrame(ex.getMessage());
                }
            }
        });

    }

}
