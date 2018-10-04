package GraphicalInterface;


import javax.swing.*;
import java.awt.*;

public class ExceptionFrame extends JFrame {
    private JPanel panel;
    private JLabel lbl;

    public ExceptionFrame() {
        super("Error!");
        setSize(300,100);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void initComponents(){
        panel = new JPanel();
        setLayout(new BorderLayout());
        lbl = new JLabel("");
        panel.add(lbl);
        add(panel,BorderLayout.CENTER);
    }

    public void Print(String s){
        lbl.setText(s);
        Font f = new Font("", Font.HANGING_BASELINE, 15);
        lbl.setFont(f);
    }
}
