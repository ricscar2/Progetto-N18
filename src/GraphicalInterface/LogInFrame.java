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
        setSize(500,110);
        setResizable(false);
        setLocationRelativeTo(null);
		initComponents();
		addListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void InitComponents(){
		
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

    }

}
