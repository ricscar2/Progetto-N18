package GraphicalInterface;

import Service.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LogInFrame extends JFrame {

    private Database db = new Database("root", "toor");
    private MainPageFrame mainPageFrame;
    private JPanel pData = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblUsername = new JLabel("Username:");
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnLogin = new JButton("LogIn");
    private JButton btnSignin = new JButton("SignIn");

    public LogInFrame() throws SQLException {

        super("Airline Company - LogIn");
        setSize(500,110);
        setResizable(false);
        setLocationRelativeTo(null);
		initComponents();
		addListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

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
                boolean res = false;
                try {
                    res = db.logIn(txtUsername.getText(), txtPassword.getText());
                    if(res == true){
                        mainPageFrame = new MainPageFrame();
                        setVisible(false);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Login: " + res);
            }
        });

        btnSignin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignInFrame signInFrame = new SignInFrame();
                setVisible(false);

            }
        });

    }

    public static void main(String[] args) throws SQLException {

        LogInFrame logInFrame = new LogInFrame();

    }

}
