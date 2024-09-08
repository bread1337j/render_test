import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    static SplittableRandom rand = new SplittableRandom();
    static byte[][] bytearrpow2 = new byte[250001][3];
    public static void addbytearr(byte[] b, int loc){
        bytearrpow2[loc] = b;
    }
    public static void addbytearralt(byte b1, byte b2, byte b3, int loc){
        bytearrpow2[loc] = new byte[]{b1, b2, b3};
    }
    public static Color GetColorOfLoc(int loc){
        return(new Color(bytearrpow2[loc][0]+128, bytearrpow2[loc][1]+128, bytearrpow2[loc][2]+128));
    }
    public static void RandomStuffGo(){
        for(int i=0; i<250001; i++){
            addbytearralt((byte)rand.nextInt(127),(byte)rand.nextInt(127), (byte)rand.nextInt(127),i);
        }
    }
    public static void RenderByteArr(byte[][] arr, Window w){
        w.bytearrpow2 = arr;
        //w.setVisible(false);
        //w.setVisible(true);
        SwingUtilities.updateComponentTreeUI(w.fr);
    }

    public static void main(String[] args) throws InterruptedException {
        Window bebra = new Window();
        bebra.MakeWindow();
        //addbytearralt((byte)100, (byte)100, (byte)(100), 1);
        //System.out.println(GetColorOfLoc(1));
        RandomStuffGo();
        System.out.println("a");
        RenderByteArr(bytearrpow2, bebra);
        System.out.println("a");
        //bebra.paint(bebra.pn.getGraphics());
        bebra.MakeVisible();
        bebra.repaint();
        while(true){
            long startTime = System.nanoTime();


            RandomStuffGo();
            RenderByteArr(bytearrpow2, bebra);


            long endTime = System.nanoTime();
            long executionTime
                    = (endTime - startTime) / 1000;

            System.out.println("Rendering takes "
                    + executionTime + "ns" + " | " + 1000000/executionTime + " FPS");

            //TimeUnit.SECONDS.sleep(1);
            //bebra.repaint();
        }
        //bebra.setVisible(true);
    }//0110 0100 & 0011 1001 -> 0010 0000 -> 32
}