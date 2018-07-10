package GraphicalInterface;

import Service.Client;

import javax.swing.*;

public class MainPageFrame extends JFrame {

    Client client;

    public MainPageFrame(Client client){
        super("AirlineCompany - Main Page");
        this.client = client;
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents(){

    }

    public void addListeners() {

    }

}
