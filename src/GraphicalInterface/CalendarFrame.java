package GraphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalendarFrame extends JFrame {

    private JPanel pData = new JPanel();
    private JPanel pButton = new JPanel();
    private JLabel lblDay = new JLabel("Day:");
    private JLabel lblMonth = new JLabel("Month:");
    private JLabel lblYear = new JLabel("Year:");
    private JLabel lblOut = new JLabel();
    private JTextField txtDay = new JTextField();
    private JComboBox cmbMonth = null;
    private JComboBox cmbYear = new JComboBox();
    private JButton btnSelect = new JButton("Add Birthdate");
    private String[] months;
    private String date = "";
    private JComboBox giorno30 = null;
    private JComboBox mese = null;
    int n = 31;

    private  SignInFrame initFrame = new SignInFrame(null);

        public CalendarFrame() throws IOException {
            super("Airline Company - Select Your Birthday");
            months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September",
                    "October", "November", "December"};
            cmbMonth = new JComboBox<>(months);
            cmbYear = new JComboBox<>(CalcoloAnni());
            setSize(600,150);
            setResizable(false);
            setLocationRelativeTo(null);
            initComponents();
            //addListeners();

            this.setVisible(true);
        }

    public void setInitFrame(SignInFrame frame){
        initFrame=frame;
    }

        public void initComponents(){


            txtDay.setFont(new Font("SansSerif", Font.PLAIN, 10));

            cmbYear.setFont(new Font("SansSerif", Font.PLAIN, 10));
            setLayout(new BorderLayout());
            pData.setLayout(new GridLayout(3,3));

            String[] mesi = new String[]{"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
            cmbMonth = new JComboBox<>(mesi);
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
            //pData.add(txtDay);
            pData.add(giorno30);
            pData.add(lblMonth);
            pData.add(cmbMonth);
            pData.add(lblYear);
            pData.add(cmbYear);
            add(pData, BorderLayout.NORTH);
            pButton.setLayout(new FlowLayout());
            pButton.add(btnSelect);
            add(pButton,BorderLayout.SOUTH);
            cmbMonth.setFont(new Font("SansSerif", Font.PLAIN, 10));

            initFrame.setVisible(false);
            addListeners();
        }



    public String[] CalcoloGiorni(int n){
        String[] string= new String[n];
        string[0]="01";
        for(int i =1 ; i<n ; i++){
            String k= new String(Integer.toString(i+1));
            if(i>0 && i<9)
                string[i]="0" + k;
            else
                string[i] = k;
        }
        return string;
    }



    public String[] CalcoloAnni(){
        int d=119;
        int i;
        String[] anni=new String[d];
        anni[0]="1900";

        for(i=0 ; i<119 ; i++){
            String k = new String(Integer.toString(i+1900));
            anni[i]=k;
        }
        return anni;
    }

        public void addListeners(){

            btnSelect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(cmbMonth.getSelectedItem().toString()) {

                        case "Gennaio":
                            date = giorno30.getSelectedItem().toString() + "-" + "01" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Febbraio":
                            date = giorno30.getSelectedItem().toString() + "-" + "02" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Marzo":
                            date = giorno30.getSelectedItem().toString() + "-" + "03" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Aprile":
                            date = giorno30.getSelectedItem().toString() + "-" + "04" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Maggio":
                            date = giorno30.getSelectedItem().toString() + "-" + "05" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Giugno":
                            date = giorno30.getSelectedItem().toString() + "-" + "06" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Luglio":
                            date = giorno30.getSelectedItem().toString() + "-" + "07" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Agosto":
                            date = giorno30.getSelectedItem().toString() + "-" + "08" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Settembre":
                            date = giorno30.getSelectedItem().toString() + "-" + "09" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Ottobre":
                            date = giorno30.getSelectedItem().toString() + "-" + "10" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Novembre":
                            date = giorno30.getSelectedItem().toString() + "-" + "11" + "-" + cmbYear.getSelectedItem().toString();
                            break;

                        case "Dicembre":
                            date = giorno30.getSelectedItem().toString() + "-" + "12" + "-" + cmbYear.getSelectedItem().toString();
                            break;
                    }
                    initFrame.addData(date);
                    setVisible(false);
                }

            });

        }

}
