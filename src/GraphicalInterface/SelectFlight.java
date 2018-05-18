package GraphicInterface;

import javax.swing.*;
import java.awt.*;

public class SelectFlight extends JFrame {

    private JPanel pTitle = new JPanel();
    private JPanel pDepArr = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblSelectFlight = new JLabel("SELECT YOUR FLIGHT");
    private JLabel lblDeparture = new JLabel("Departure");
    private JTextField txtDeparture = new JTextField();
    private JLabel lblArrive = new JLabel("Arrive");
    private JTextField txtArrive = new JTextField();
    private JLabel lblDateofDeparture = new JLabel("Date of Departure");
    private JTextField txtDateofDeparture = new JTextField();
    private JLabel lblColor = new JLabel();
    private JCheckBox chkDepArr = new JCheckBox();
    private JLabel lblRoundtrip = new JLabel("Roundtrip");
    private JLabel lblDateofArrive = new JLabel("Date of Arrive:");
    private JTextField txtDateofArrive = new JTextField();
    private JButton btnNext = new JButton("Next");



    public SelectFlight(){
        super("Airline Company - Select Flight");
        setSize(300,300);
        setLocation(600,200);
        setResizable(true);
        setVisible(true);
        lblColor.setBackground(Color.GREEN);
        initComponents();
    }

    public void initComponents(){
        pTitle.add(lblSelectFlight);
        add(pTitle,BorderLayout.NORTH);
        pDepArr.setLayout(new GridLayout(6,2));
        pDepArr.add(lblDeparture);
        pDepArr.add(txtDeparture);
        pDepArr.add(lblArrive);
        pDepArr.add(txtArrive);
        pDepArr.add(lblDateofDeparture);
        pDepArr.add(txtDateofDeparture);
        pDepArr.add(chkDepArr);
        pDepArr.add(lblRoundtrip);
        pDepArr.add(lblDateofArrive);
        pDepArr.add(txtDateofArrive);
        pDepArr.add(lblColor);
        add(pDepArr,BorderLayout.CENTER);
        pButton.add(btnNext);
        add(pButton,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SelectFlight selectFlight = new SelectFlight();
        selectFlight.initComponents();
        selectFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
