package GraphicalInterface;

import Database.Database;
import Web.Client;
import Web.JsonCommand;
import Web.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LogInFrame extends JFrame {

    private Client client;
    private MainPageFrame mainPageFrame;
    private JPanel pData = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblUsername = new JLabel("Username:");
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnLogin = new JButton("LogIn");
    private JButton btnSignin = new JButton("SignIn");


    public LogInFrame(Client client) {

        super("Airline Company - LogIn");
        this.client = client;
        setSize(500,110);
        setResizable(false);
        setLocationRelativeTo(null);
		initComponents();
		addListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void initComponents(){
		
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 15));
        txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));

		setLayout(new BorderLayout());
        pData.setLayout(new GridLayout(2,2));
        pData.add(lblUsername);
        pData.add(txtUsername);
        pData.add(lblPassword);
        pData.add(txtPassword);
        add(pData, BorderLayout.NORTH);
        pButton.setLayout(new GridLayout(1,2));
        pButton.add(btnSignin);
        pButton.add(btnLogin);
        add(pButton,BorderLayout.SOUTH);

    }

    public void addListeners(){

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JsonCommand jsonCommand = new JsonCommand("00", txtUsername.getText(), txtPassword.getText());
                // Send to server
                client.sendMessage(jsonCommand.getJsonString());
                if(client.getResponse().equals("true")) {
                    mainPageFrame = new MainPageFrame(client);
                    System.out.println("Connected. Response: " + client.getResponse());
                    setVisible(false);
                } else
                    System.out.println("Connection Attempt failed! Response: " + client.getResponse());
            }
        });

        btnSignin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SignInFrame signInFrame = new SignInFrame(client);
                    setVisible(false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
