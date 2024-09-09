
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JPanel {
    JPanel pn = new JPanel() {@Override
    public void paintComponents(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawRect(100, 100, 10, 10);
        for (int y = 0; y <= 500; y++) {
            for (int x = 0; x <= 500; x++) {
                g2d.setColor(GetColorOfLoc(x+y*500));
                g2d.fillRect(x*4, y*4, 4, 4);

            }
            System.out.println(y);
        }
        //System.out.println("Render complete");

    }};
    JFrame fr = new JFrame() {@Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawRect(100, 100, 10, 10);
        for (int y = 0; y <= 500; y++) {
            for (int x = 0; x <= 500; x++) {
                g2d.setColor(GetColorOfLoc(x+y*500));
                g2d.fillRect(x*4, y*4, 4, 4);

            }
            //System.out.println(y);
        }
        //System.out.println("Render complete");

    }};
    ;

    static byte[][] bytearrpow2 = new byte[250001][3];
    public void MakeWindow() {
        fr.setSize(600,600);
        fr.setDefaultCloseOperation(3);
        fr.add(pn);
        //fr.setVisible(true);
    }
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
