package GraphicalInterface;

import GraphicalInterface.LogInFrame;
import Service.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignInFrame extends JFrame {

    private Client client;
    private LogInFrame logInFrame;
    private JPanel pSopra = new JPanel();
    private JPanel pSotto = new JPanel();
    private JPanel pData = new JPanel();
    private JPanel pButtons = new JPanel();
    private JLabel lblName = new JLabel("Name: ");
    private JTextField txtName = new JTextField();
    private JLabel lblSurname = new JLabel("Surname: ");
    private JTextField txtSurname = new JTextField();
    private JLabel lblBirthday = new JLabel("Birthdate: ");
    private JTextField txtBirthday = new JTextField();
    private JLabel lblUsername = new JLabel("Username: ");
    private JTextField txtUsername = new JTextField();
    private JLabel lblPassword = new JLabel("Password: ");
    private JPasswordField txtPassword = new JPasswordField();
    private JLabel lblConfermedPassword = new JLabel("Confirm Password: ");
    private JPasswordField txtConfermedPassword = new JPasswordField();
    private JLabel lblNation = new JLabel("Nation: ");
    private JComboBox<String> cmbNation = new JComboBox<>();
    private JLabel lblEmail = new JLabel("Email: ");
    private JTextField txtEmail = new JTextField();
    private JButton btnBack = new JButton("Back");
    private JButton btnRegister = new JButton("Register");


    public SignInFrame(Client client){

        super("Airplane Company - SignIn");
        this.client = client;
        setSize(400,300);
        setResizable(true);
        setLocationRelativeTo(null);
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initComponents(){

        setLayout(new BorderLayout());
        pData.setLayout(new GridLayout(8,2));
        pData.add(lblName);
        pData.add(txtName);
        pData.add(lblSurname);
        pData.add(txtSurname);
        pData.add(lblBirthday);
        pData.add(txtBirthday);
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

    }

}
