package GraphicalInterface;

import Core.Company;
import Eccezioni.AllFieldsAreMandatoryException;
import Eccezioni.InvalidLogInException;
import User.User;
import Web.Client;
import Web.JsonCommand;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
    private SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            public void actionPerformed(ActionEvent e) {
                JsonCommand jsonCommand = new JsonCommand("00", txtUsername.getText(), txtPassword.getText());
                // Send to server
                client.sendMessage(jsonCommand.getJsonString());
                try {
                    if(!txtUsername.getText().equals("") && !txtPassword.getText().equals("")){
                        if (client.getResponse().equals("false")) {
                            throw new InvalidLogInException("Invalid Username or Password!");
                        } else {
                        try {
                            JSONParser jsonParser = new JSONParser();
                            JSONObject userInfo = new JSONObject((JSONObject) jsonParser.parse(client.getResponse()));
                            Company airlineCompany = new Company(client);
                            User user = new User(client, (String) userInfo.get("usr"), (String) userInfo.get("pwd"),
                                    (String) userInfo.get("name"), (String) userInfo.get("surname"),
                                    birthdayFormat.parse((String) userInfo.get("birthdate")), (String) userInfo.get("nation"),
                                    (String) userInfo.get("email"), airlineCompany);
                            mainPageFrame = new MainPageFrame(client, user, airlineCompany);
                            System.out.println("Connected. Response: " + client.getResponse());
                            setVisible(false);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        } catch (java.text.ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                }else{
                        throw new AllFieldsAreMandatoryException("Tutti i campi devono essere riempiti");
                    }
                }catch (AllFieldsAreMandatoryException e1){
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                } catch (InvalidLogInException e1) {
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame(s);
                }
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

        txtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtUsername.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
