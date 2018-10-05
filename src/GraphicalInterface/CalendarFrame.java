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
        private JLabel lblYear = new JLabel("Year:");
        private JTextField txtDay = new JTextField();
        private JComboBox cmbMonth = null;
        private JTextField txtYear = new JTextField("1996");
        private JButton btnSelect = new JButton("Add Birthdate");
        private String[] months;
        private String date = "";
        private JComboBox giorno30 = null;
        private JComboBox mese = null;
        int n = 31;

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



            String[] mesi = new String[]{"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
            mese = new JComboBox<>(mesi);
            String[] giorni30 = new String[n];
            giorno30= new JComboBox<>(CalcoloGiorni(giorni30.length));
            giorno30.setFont(new Font("SansSerif", Font.PLAIN, 10));

            cmbMonth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbMonth.getSelectedItem();
                    if(cmbMonth.getSelectedItem().toString().equals("Giugno")||cmbMonth.getSelectedItem().toString().equals("Novembre")||cmbMonth.getSelectedItem().toString().equals("Aprile")||cmbMonth.getSelectedItem().toString().equals("Settembre")){
                        if(n==31){
                            giorno30.removeItemAt(30);
                            n=30;
                        }
                        if(n==29){
                            giorno30.addItem(30);
                            n=30;
                        }
                    } if(cmbMonth.getSelectedItem().toString().equals("Gennaio")||cmbMonth.getSelectedItem().toString().equals("Marzo")||cmbMonth.getSelectedItem().toString().equals("Maggio")||cmbMonth.getSelectedItem().toString().equals("Luglio")||cmbMonth.getSelectedItem().toString().equals("Agosto")||cmbMonth.getSelectedItem().toString().equals("Ottobre")||cmbMonth.getSelectedItem().toString().equals("Dicembre")){
                        if(n==30) {
                            n = 31;
                            giorno30.insertItemAt(31, 30);
                        } if(n==29){
                            n=31;
                            giorno30.addItem(30);
                            giorno30.addItem(31);
                        }
                    }

                    if(cmbMonth.getSelectedItem().toString().equals("Febbraio")){
                        if(n==31){
                            giorno30.removeItemAt(30);
                            giorno30.removeItemAt(29);}
                        if(n==30){
                            giorno30.removeItemAt(29);
                        }
                        n=29;
                    }
                }
            });

            pData.add(lblDay);
            pData.add(giorno30);
            pData.add(lblMonth);
            pData.add(cmbMonth);
            pData.add(lblYear);
            pData.add(txtYear);
            add(pData, BorderLayout.NORTH);
            pButton.setLayout(new FlowLayout());
            pButton.add(btnSelect);
            add(pButton,BorderLayout.SOUTH);



        }

    public String[] CalcoloGiorni(int n){
        String[] string= new String[n];
        string[0]="1";
        for(int i =1 ; i<n ; i++){
            String k= new String(Integer.toString(i+1));
            string[i] = k;
        }
        return string;
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
