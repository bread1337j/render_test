
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JPanel {
    byte[] SampleArray = new byte[3];
    JPanel pn = new JPanel(){@Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int y = 0; y <= 270; y++) {

            for (int x = 0; x <= 490; x++) {
                int loc = x + y * 500;
                if ((bytearrpow2[loc] != SampleArray)) {
                    g2d.setColor(GetColorOfLoc(loc));
                    g2d.fillRect(x * 4, y * 4, 4, 4);
                }
            }
        }
    }
};
    JFrame fr = new JFrame();
    
    static byte[][] bytearrpow2 = new byte[250001][3];
    public void MakeWindow() {
        fr.setSize(600,600);
        fr.setDefaultCloseOperation(3);
        fr.add(pn);}
    public void MakeVisible(){
        fr.setVisible(true);
    }
    public void MakeInvisible(){
        fr.setVisible(false);
    }
    public Color GetColorOfLoc(int loc){
        return(new Color(bytearrpow2[loc][0]+128, bytearrpow2[loc][1]+128, bytearrpow2[loc][2]+128));
    }


}
