package GraphicalInterface;

import GraphicalInterface.SignInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;

public class LogInFrame extends JFrame {

    private JPanel pData = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblUsername = new JLabel("Username:");
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnLogin = new JButton("LogIn");
    private JButton btnSignin = new JButton("SignIn");

    public LogInFrame(){

        super("Airline Company - LogIn");
        setSize(500,100);
        setResizable(false);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());

        setVisible(true);

    }

    public void InitComponents(){
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
        btnSignin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignInFrame signInFrame = new SignInFrame();
                signInFrame.initComponents();
                signInFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(false);

            }
        });


    }

    public static void main(String[] args) {

        LogInFrame logInFrame = new LogInFrame();
        logInFrame.InitComponents();
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
