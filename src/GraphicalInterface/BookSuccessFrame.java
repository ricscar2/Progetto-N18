package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import Web.Client;
import User.User;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSuccessFrame extends JFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    private JPanel pTitle = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblTitle = new JLabel("Booking completed successfully!");
    private JButton btnMain = new JButton("Go to Main Page");

    public BookSuccessFrame(Client client, User user, Company airlineCompany){
        super("Airline Company - Booking Completed Succesfully!!");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addListeners();
    }

    public void initComponents(){
        setLayout(new BorderLayout());
        add(pTitle, BorderLayout.NORTH);
        add(pButton, BorderLayout.CENTER);
        pTitle.add(lblTitle);
        pButton.add(btnMain);
    }


    public void addListeners(){

        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainPageFrame mainPageFrame = new MainPageFrame(client, user, airlineCompany);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                } setVisible(false);
            }
        });

    }

}
