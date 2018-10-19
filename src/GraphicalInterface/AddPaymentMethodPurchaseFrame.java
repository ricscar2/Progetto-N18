package GraphicalInterface;

import Core.Company;
import Core.TempTicket;
import Eccezioni.IDException;
import Payment.CreditCard;
import User.User;
import Web.Client;
import Web.JsonCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPaymentMethodPurchaseFrame extends AddPaymentMethodFrame {

    private Client client;
    private User user;
    private Company airlineCompany;
    private TempTicket tempTicket;

    public AddPaymentMethodPurchaseFrame(Client client, User user, Company airlineCompany, TempTicket tempTicket) {
        super(client, user, airlineCompany, tempTicket);
        super.setTitle("Airline Company - Add Payment Method");
        this.client = client;
        this.user = user;
        this.airlineCompany = airlineCompany;
        this.tempTicket = tempTicket;
        btnBack.setVisible(false);
    }

    @Override
    protected void addListeners() {

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
                                PurchaseFrame purchaseFrame = new PurchaseFrame(client, user, airlineCompany,tempTicket);
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
