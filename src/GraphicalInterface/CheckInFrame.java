package GraphicalInterface;

import Core.Company;
import Core.Ticket;
import Eccezioni.IncorrectCheckInException;
import User.User;
import Web.Client;
import Web.JsonCommand;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppo N
 */
public class CheckInFrame extends JFrame {

    private Client client;
    private Company airlineCompany;
    private User user;
    private Ticket ticket;

    private JPanel pTitle = new JPanel();
    private JPanel pData = new JPanel();
    private JPanel pButtons = new JPanel();
    private JLabel lblTitle = new JLabel("Insert the holder's data to check your ticket!");
    private JLabel lblTicket = new JLabel("Ticket: ");
    private JLabel lblID;
    private JLabel lblOwnerName = new JLabel("Name: ");
    private JLabel lblOwnerSurname = new JLabel("Surname: ");
    private JTextField txtOwnerName = new JTextField();
    private JTextField txtOwnerSurname = new JTextField();
    private JButton btnNext = new JButton("Check-In");

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param user The <code>User</code> Class's instance of the current Session
     * @param airlineCompany The <code>Company</code> Class' instance of the current Session
     * @param ticket The <code>Ticket</code> Class' instance to check-in in the current Session
     */
    public CheckInFrame(Client client, User user, Company airlineCompany, Ticket ticket){
        super("Airline Company - Check-In");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        this.ticket = ticket;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    /**
     * To initialize Graphical Components
     */
    private void initComponents(){
        lblID = new JLabel(ticket.getId());
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pData, BorderLayout.CENTER);
        add(pButtons, BorderLayout.SOUTH);
        pTitle.add(lblTitle);
        pData.setLayout(new GridLayout(3,2));
        pData.add(lblTicket);
        pData.add(lblID);
        pData.add(lblOwnerName);
        pData.add(txtOwnerName);
        pData.add(lblOwnerSurname);
        pData.add(txtOwnerSurname);
        pButtons.setLayout(new GridLayout(1,2));
        pButtons.add(btnNext);
    }


    /**
     * To add the Listeners
     */
    public void addListeners(){

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String owner = txtOwnerName.getText() + " " + txtOwnerSurname.getText();
                try {
                    if (owner.equals(ticket.getHolder())){
                        client.sendMessage(new JsonCommand("14", ticket.getId()).getJsonString());
                        user.checkIn(ticket);
                        CheckInSuccessFrame checkInSuccessFrame = new CheckInSuccessFrame(client, user, airlineCompany);
                        setVisible(false);
                    } else throw new IncorrectCheckInException();
                } catch (IncorrectCheckInException e1) {
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                    } catch (ParseException e1) {
                    e1.printStackTrace();
                } catch (java.text.ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
