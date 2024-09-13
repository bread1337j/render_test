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
    public static void AddBytesLoc(int[] loc1, int x, int y){
    	for(int j : loc1){
		byte[] tmp = bytearrpow2[j];
		bytearrpow2[j+(x%500)+(y%500)*500] = tmp;
		bytearrpow2[j] = new byte[3];
	}
    }
    public static void SetBytesLoc(int[] loc1, int[] loc2){
    	for(int i=0; i<loc1.length;i++){
		bytearrpow2[loc2[i]]=bytearrpow2[loc1[i]];
		bytearrpow2[loc2[i]]=new byte[3];
	}
    }



    public static Color GetColorOfLoc(int loc){
        return(new Color(bytearrpow2[loc][0]+128, bytearrpow2[loc][1]+128, bytearrpow2[loc][2]+128));
    }
    public static void RandomStuffGo(){
        for(int i=0; i<250001; i++){
            addbytearralt((byte)rand.nextInt(127),(byte) (byte)rand.nextInt(127),(byte) (byte)rand.nextInt(127),i);
        }
    }
    public static void FillScreen(byte[] clr){
        for (int y = 0; y <= 500; y++) {
            for (int x = 0; x <= 500; x++) {
                addbytearr(clr, x+y*500);
            }
        }
    }
    public static void AddLineHorizontal(int x1, int x2, int y, byte[] clr){
        int h = y * 500;
        for(int i=x1; i<=x2; i++){
            addbytearr(clr, h+i);

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


    public static void SyncByteArr(byte[][] arr, Window w){
        w.bytearrpow2 = arr;
    }
    static int[] TextureMap = new int[] {2, 4, 502, 504, 1003, 1503, 2001, 2002, 2003, 2004, 2005, 2503, 3003, 3002, 3004, 3505, 3501, 4005, 4001, 4505, 4501, 5002, 5003, 5004};
        static byte[][] Texture = new byte[][] {BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK}; //only here for testing purposes, ideally I can make it so that this will read images for sprites later on.
    



    
     





    public static void main(String[] args) throws InterruptedException {
        Window bebra = new Window();
        bebra.MakeWindow();
        final Runnable doRender = new Runnable() {
         public void run() {
             bebra.pn.repaint();
         }
         };

         Thread RenderThread = new Thread() {
             public void run() {
                 try {
                     SwingUtilities.invokeAndWait(doRender);
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                 System.out.print("Finished on " + Thread.currentThread() + " | ");
             }
         };
         RenderThread.start();

        SyncByteArr(bytearrpow2, bebra);

        bebra.MakeVisible();
        bebra.repaint();


        Sprite sigma = new Sprite();
        sigma.TextureMap = TextureMap;
        sigma.Texture = Texture;
    	int[] intlisttemplate = new int[1001];
    	for(int i=0; i<=1000; i++){
    		intlisttemplate[i] = i;
    	}
    	int[] zerointlist = new int[1001];
    	for(int i=0; i<= 1000; i++){
    		zerointlist[i]=0;
    	}



    	int ticks = 0;
        while(true){
            long Time1 = System.nanoTime();
            ticks += 1;

            //RandomStuffGo();


            sigma.SetupSizes();
            sigma.Move(2, 0, bebra);





            SyncByteArr(bytearrpow2, bebra);


            sigma.Draw(bebra);
            long Time2 = System.nanoTime();
            long executionTime
                    = (Time2 - Time1);
            System.out.print(ticks + " | Generating takes "
                    + executionTime + "t" + " | ");





	        RenderThread.run();



            long Time3 = System.nanoTime();
            long executionTime2
                    = (Time3 - Time2) / 100;
            System.out.println("Rendering takes "
                    + executionTime2 + "t" + " | " + 10000000/executionTime2 + " FPS");

        }
    }
}
