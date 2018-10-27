package GraphicalInterface;

import Core.Company;
import User.User;
import Web.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppo N
 */
public class CheckInSuccessFrame extends BookSuccessFrame {

    private Client client;
    private User user;
    private Company airlineCompany;

    /**
     *
     * @param client The <code>Client</code> Class' instance of the current Session
     * @param user The <code>User</code> Class's instance of the current Session
     * @param airlineCompany The <code>Company</code> Class' instance of the current Session
     */
    public CheckInSuccessFrame(Client client, User user, Company airlineCompany) {
        super(client, user, airlineCompany);
        super.setTitle("Airline Company - Check-In Completed Succesfully!!");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        setlblText("Check-In completed successfully!");
    }

    /**
     * To add the Listeners
     */
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
