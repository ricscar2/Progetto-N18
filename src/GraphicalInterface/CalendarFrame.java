package GraphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarFrame extends JFrame {

        private JPanel pData = new JPanel();
        private JPanel pButton = new JPanel();
        private JLabel lblDay = new JLabel("Day:");
        private JLabel lblMonth = new JLabel("Month:");
        private JLabel lblYear = new JLabel("Month:");
        private JTextField txtDay = new JTextField();
        private JComboBox cmbMonth = null;
        private JTextField txtYear = new JTextField("1996");
        private JButton btnSelect = new JButton("Add Birthdate");
        private String[] months;
        private String date = "";

        public CalendarFrame() {
            super("Airline Company - Select Your Birthday");
            months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September",
                    "October", "November", "December"};
            cmbMonth = new JComboBox<>(months);
            setSize(600,150);
            setResizable(false);
            setLocationRelativeTo(null);
            initComponents();
            //addListeners();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }

        public void initComponents(){
            txtDay.setFont(new Font("SansSerif", Font.PLAIN, 10));
            cmbMonth.setFont(new Font("SansSerif", Font.PLAIN, 10));
            txtYear.setFont(new Font("SansSerif", Font.PLAIN, 10));
            setLayout(new BorderLayout());
            pData.setLayout(new GridLayout(3,3));
            pData.add(lblDay);
            pData.add(txtDay);
            pData.add(lblMonth);
            pData.add(cmbMonth);
            pData.add(lblYear);
            pData.add(txtYear);
            add(pData, BorderLayout.NORTH);
            pButton.setLayout(new FlowLayout());
            pButton.add(btnSelect);
            add(pButton,BorderLayout.SOUTH);
        }

        public void addListeners(){

            btnSelect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        switch (cmbMonth.getSelectedItem().toString()) {
                            case "January":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-01-" + txtYear.getText();
                            case "February":
                                if (Integer.parseInt(txtDay.getText()) <= 29 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-02-" + txtYear.getText();
                            case "March":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-03-" + txtYear.getText();
                            case "April":
                                if (Integer.parseInt(txtDay.getText()) <= 30 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-04-" + txtYear.getText();
                            case "May":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-05-" + txtYear.getText();
                            case "June":
                                if (Integer.parseInt(txtDay.getText()) <= 30 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-06-" + txtYear.getText();
                            case "July":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-07-" + txtYear.getText();
                            case "August":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-08-" + txtYear.getText();
                            case "September":
                                if (Integer.parseInt(txtDay.getText()) <= 30 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-09-" + txtYear.getText();
                            case "October":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-10-" + txtYear.getText();
                            case "November":
                                if (Integer.parseInt(txtDay.getText()) <= 30 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-11-" + txtYear.getText();
                            case "December":
                                if (Integer.parseInt(txtDay.getText()) <= 31 && Integer.parseInt(txtDay.getText()) >= 1)
                                    date = txtDay.getText() + "-12-" + txtYear.getText();
                        }
                    setVisible(false);
                }
            });

        }

}
