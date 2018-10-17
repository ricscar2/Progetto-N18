package GraphicalInterface;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExceptionFrame extends JFrame {
    private JPanel panel;
    private JLabel lbl;
    private Image img = null;

    public ExceptionFrame() {
        super("Error!");
        setSize(350,150);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void initComponents(){
        panel = new JPanel();
        setLayout(new GridLayout(1,2));
        try {
            img= ImageIO.read(new FileImageInputStream(new File("C:\\Users\\matti\\Desktop\\homer.jpg")));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Image loading error!");
        }

        ImageIcon imm = new ImageIcon(img);
        JLabel lblimm = new JLabel(imm);
        lbl = new JLabel("");

        panel.add(lbl);
        panel.add(lblimm);
        add(panel);
    }

    public void Print(String s){
        lbl.setText(s);
        Font f = new Font("", Font.HANGING_BASELINE, 15);
        lbl.setFont(f);
    }
}
