package GraphicalInterface;

import javax.swing.*;
import java.awt.*;

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

        setVisible(true);

    }

    public static void main(String[] args) {

        LogInFrame logInFrame = new LogInFrame();
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
