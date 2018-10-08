package GraphicalInterface;

import Database.Queries;
import Eccezioni.AllFieldsAreMandatoryException;
import Eccezioni.DifferentPasswordException;
import User.User;
import Web.Client;
import Web.JsonCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SignInFrame extends JFrame {

    private Client client;
    private LogInFrame logInFrame;
    private JPanel pSopra = new JPanel();
    private JPanel pSotto = new JPanel();
    private JPanel pData = new JPanel();
    private JPanel pButtons = new JPanel();
    private JPanel pCalendar = new JPanel();
    private JLabel lblName = new JLabel("Name: ");
    private JTextField txtName = new JTextField();
    private JLabel lblSurname = new JLabel("Surname: ");
    private JTextField txtSurname = new JTextField();
    private JLabel lblBirthday = new JLabel("Birthdate: ");
    private JLabel lblDate = new JLabel("'Select a Date'");
    private JLabel lblUsername = new JLabel("Username: ");
    private JTextField txtUsername = new JTextField();
    private JLabel lblPassword = new JLabel("Password: ");
    private JPasswordField txtPassword = new JPasswordField();
    private JLabel lblConfermedPassword = new JLabel("Confirm Password: ");
    private JPasswordField txtConfermedPassword = new JPasswordField();
    private JLabel lblNation = new JLabel("Nation: ");
    private JComboBox<String> cmbNation;
    private JLabel lblEmail = new JLabel("Email: ");
    private JTextField txtEmail = new JTextField();
    private JButton btnBack = new JButton("Back");
    private JButton btnRegister = new JButton("Register");
    private JButton btnCalendar = new JButton("Select");

    public SignInFrame(Client client) throws IOException {

        super("Airplane Company - SignIn");
        this.client = client;
        BufferedReader input = new BufferedReader(new FileReader("res/Countries.txt"));
        ArrayList<String> nations = new ArrayList<String>();
        try {
            String line = null;
            while (( line = input.readLine()) != null){
                nations.add(line);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Error, file didn't exist.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        String[] lineArray = nations.toArray(new String[]{});
        cmbNation = new JComboBox<>(lineArray);
        setSize(600,400);
        setResizable(true);
        setLocationRelativeTo(null);
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void addData(String s){
        lblDate.setText(s);
        lblDate.setFont(new Font("SansSerif", Font.PLAIN, 10));
    }



    public void initComponents(){
        lblDate.setFont(new Font("SansSerif",Font.PLAIN,10));
        setLayout(new BorderLayout());
        pData.setLayout(new GridLayout(8,2));
        pCalendar.setLayout(new GridLayout(1,2));
        pCalendar.add(lblDate);
        pCalendar.add(btnCalendar);
        pData.add(lblName);
        pData.add(txtName);
        pData.add(lblSurname);
        pData.add(txtSurname);
        pData.add(lblBirthday);
        pData.add(pCalendar);
        pData.add(lblNation);
        pData.add(cmbNation);
        pData.add(lblEmail);
        pData.add(txtEmail);
        pData.add(lblUsername);
        pData.add(txtUsername);
        pData.add(lblPassword);
        pData.add(txtPassword);
        pData.add(lblConfermedPassword);
        pData.add(txtConfermedPassword);
        pSopra.add(pData);
        pButtons.setLayout(new GridLayout(1,2));
        pButtons.add(btnBack);
        pButtons.add(btnRegister);
        pSotto.add(pButtons);
        add(pSopra, BorderLayout.NORTH);
        add(pSotto,BorderLayout.CENTER);

    }

    public void addListeners(){

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInFrame = new LogInFrame(client);
                setVisible(false);
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!txtUsername.getText().equals("") && !txtSurname.getText().equals("") && !lblDate.getText().equals("") && !txtEmail.getText().equals("") && !txtName.getText().equals("") && !txtPassword.equals("") && !txtConfermedPassword.getText().equals("") ){
                    if(txtPassword.getText().equals(txtConfermedPassword.getText())) {
                        JsonCommand jsonCommand = new JsonCommand("01", txtUsername.getText(), txtPassword.getText(),
                                txtName.getText(), txtSurname.getText(), lblDate.getText(), cmbNation.getSelectedItem().toString(),
                                txtEmail.getText());
                        client.sendMessage(jsonCommand.getJsonString());
                        if (client.getResponse().equals("true")) {
                            System.out.println("Registrazione avvenuta con successo!");
                            User user = null;
                            try {
                                user = new User(txtUsername.getText(), txtPassword.getText(), txtName.getText(), txtSurname.getText(),
                                        new SimpleDateFormat("dd-MM-yyyy").parse(lblDate.getText()),
                                        cmbNation.getSelectedItem().toString(), txtEmail.getText());
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            MainPageFrame mainPageFrame = new MainPageFrame(client, user);
                        } else
                            System.out.println("Failed");
                    } else {
                        throw new DifferentPasswordException("Le password devono concidere");
                    }}else {
                        throw new AllFieldsAreMandatoryException("Tutti i campi devono essere obbligatori");
                    }

                } catch (DifferentPasswordException e1) {
                    String s = e1.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame();
                    eFrame.initComponents();
                    eFrame.Print(s);
                } catch (AllFieldsAreMandatoryException e2){
                    String s = e2.getMessage();
                    ExceptionFrame eFrame = new ExceptionFrame();
                    eFrame.initComponents();
                    eFrame.Print(s);
                } catch (org.json.simple.parser.ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarFrame calendarFrame=null;
                try {
                    calendarFrame = new CalendarFrame();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                calendarFrame.setInitFrame(SignInFrame.this);
            }

        });

    }

}
