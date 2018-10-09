package GraphicalInterface;

import User.User;
import Web.Client;

import javax.swing.*;

public class BaggageFrame extends JFrame {

    private Client client;
    private User user;
    private JPanel pTitle = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblTitle = new JLabel("Select your Baggage");
    private JCheckBox chk15 = new JCheckBox("Baggage 15kg");
    private JCheckBox chk23 = new JCheckBox("Baggage 23kg");
    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");

    public BaggageFrame(Client client, User user){
        super("Airline Company - Baggage's Info");
        this.user = user;
        this.client = client;
        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);


    }

    public void initComponents(){

    }
}
