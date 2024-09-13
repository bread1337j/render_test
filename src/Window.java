
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
        //g2d.drawRect(100, 100, 10, 10);
	//BufferedImage b = new BufferedImage(490, 270, 3);
        for (int y = 0; y <= 270; y++) {
            for (int x = 0; x <= 490; x++) {
                //b.setRGB(0, 0, 40, 40, makeRGB(),0, 490);
                if((bytearrpow2[x+y*500] != SampleArray)){
			g2d.setColor(GetColorOfLoc(x+y*500));
			g2d.fillRect(x*4, y*4, 4, 4);
		}
            }
            //System.out.println(y);
        }
        System.out.println("Render complete");
	//g2d.drawImage(b, 0, 0, this);
    }};
    public int[] makeRGB(){
    	int[] rgb = new int[270*490];
	Arrays.fill(rgb, 255);
	return rgb;
    }
    JFrame fr = new JFrame() //{@Override
    //public void paint(Graphics g) {
    //    Graphics2D g2d = (Graphics2D) g;
    //    //g2d.drawRect(100, 100, 10, 10);
    //    for (int y = 0; y <= 500; y++) {
    //        for (int x = 0; x <= 500; x++) {
    //            g2d.setColor(GetColorOfLoc(x+y*500));
    //            g2d.fillRect(x*4, y*4, 4, 4);
    //
    //      }
    //        //System.out.println(y);
    //    }
        //System.out.println("Render complete");

    //}};
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
