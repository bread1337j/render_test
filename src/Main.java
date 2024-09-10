import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    static SplittableRandom rand = new SplittableRandom();
    static byte[][] bytearrpow2 = new byte[255511][3];
    static byte[] BLACK = new byte[]{(byte)-128, (byte)-128, (byte)-128};
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
            //int randint = (byte)rand.nextInt(127);
            //addbytearralt((byte) (randint+20),(byte) (randint-20),(byte) randint,i);
            addbytearralt((byte)rand.nextInt(127),(byte) (byte)rand.nextInt(127),(byte) (byte)rand.nextInt(127),i);
        }
    }
    public static void FillScreen(byte[] clr){
        for (int y = 0; y <= 500; y++) {
            for (int x = 0; x <= 500; x++) {
                addbytearr(clr, x+y*500);
            }
            //System.out.println(y);
        }
    }
    public static void AddLineHorizontal(int x1, int x2, int y, byte[] clr){
        int h = y * 500;
        for(int i=x1; i<=x2; i++){
            addbytearr(clr, h+i);
            //System.out.println("x coords: " + i + " y coords: " + h + " || loc: " + (i + h));

        }

    }
    public static void AddLineVertical(int y1, int y2, int x, byte[] clr){
        for(int i=y1; i<=y2; i++){
            addbytearr(clr, i*500+x);
        }
    }
    public static void AddRect(int x1,int y1,int x2,int y2, byte[] clr){
        for(int j=y1; j<=y2; j++){
            //System.out.println(j);
            AddLineHorizontal(x1, x2, j, clr);
        }
    }

    public static void AddSprite(int[] TextureMap, byte[][] Texture, int x, int y){
	for(int i=0; i<TextureMap.length; i++){
		addbytearr(Texture[i], TextureMap[i]+x+y*500);
	}
    }

    static int[] TextureMap = new int[] {150, 250, 350, 450, 550, 650, 750, 850, 950, 1050, 1150};
    static byte[][] Texture = new byte[][] {BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK};
    public static void RenderByteArr(byte[][] arr, Window w){
        w.bytearrpow2 = arr;
        //w.setVisible(false);
        //w.setVisible(true);
        //SwingUtilities.updateComponentTreeUI(w.fr);
    }

    public static void main(String[] args) throws InterruptedException {
        Window bebra = new Window();
        bebra.MakeWindow();

        //System.out.println(GetColorOfLoc(1));
        //RandomStuffGo();
        System.out.println("a");
        RenderByteArr(bytearrpow2, bebra);
        System.out.println("a");
        //bebra.paint(bebra.pn.getGraphics());
        bebra.MakeVisible();
        bebra.repaint();
        AddLineHorizontal(100,200, 200, new byte[]{00,00,100});
        int ticks = 0;
        while(true){
            long Time1 = System.nanoTime();
            ticks += 1;

            //RandomStuffGo();
            FillScreen(new byte[]{100,100,100});
            //AddLineHorizontal(100,200, ticks%100, BLACK);
	    AddSprite(TextureMap, Texture, 100, ticks%100); 
	    
	    TimeUnit.MILLISECONDS.sleep(5);

            long Time2 = System.nanoTime();
            long executionTime
                    = (Time2 - Time1) / 1000;
            System.out.print(ticks + " | Generating takes "
                    + executionTime + "ns" + " | ");



            RenderByteArr(bytearrpow2, bebra);
            //System.out.println("Rendered.");
            //TimeUnit.MILLISECONDS.sleep(5);
            //bebra.fr.getContentPane().repaint();
            bebra.pn.repaint();
            //System.out.println("Displayed.");
            //TimeUnit.SECONDS.sleep(1);
            //SwingUtilities.updateComponentTreeUI(bebra.fr);
            //TimeUnit.SECONDS.sleep(1);


            long Time3 = System.nanoTime();
            long executionTime2
                    = (Time3 - Time2) / 100;
            System.out.println("Rendering takes "
                    + executionTime2 + "t" + " | " + 10000000/executionTime2 + " FPS");

            //TimeUnit.SECONDS.sleep(1);
            //bebra.repaint();
        }
        //bebra.setVisible(true);
    }//0110 0100 & 0011 1001 -> 0010 0000 -> 32
}
