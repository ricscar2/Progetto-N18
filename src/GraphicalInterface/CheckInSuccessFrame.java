package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInSuccessFrame extends BookSuccessFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    public CheckInSuccessFrame(Client client, User user, Company airlineCompany) {
        super(client, user, airlineCompany);
        super.setTitle("Airline Company - Check-In Completed Succesfully!!");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setlblText("Check-In completed successfully!");
    }

    @Override
    protected void addListeners() {

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketToCheckFrame ticketToCheckFrame = new TicketToCheckFrame(client, user, airlineCompany);
                setVisible(false);
            }
        });

    }
}
