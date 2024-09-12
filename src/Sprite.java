public class Sprite{
		int[] TextureMap;
    byte[][] Texture;
    int x = 0;
    int y = 0;
		int sizex = 1;
		int sizey = 1;
		public void SetupSizes(){//auto-generated sizes
			int largestx = 0;
			int largesty = 0;
			for(int i : TextureMap){
				if (i%500>largestx){
					largestx = i%500;
				}
				if ((int)(i/500)>largesty){
					largesty = (int)(i/500);
				}
			}
			sizex = largestx;
			sizey = largesty;
		}

    public static void addbytearr(byte[] b, int loc, Window w){
        w.bytearrpow2[loc] = b;
    }
    public void Move(int xshift, int yshift, Window w){
				if (x+(sizex*3)+(xshift)<=490&&(y+sizey*3+yshift)<=270){
					for(int j : TextureMap){
						w.bytearrpow2[j+x+y*500] = new byte[3];
					}
			    for(int j=0;j<TextureMap.length;j++){
						w.bytearrpow2[TextureMap[j]+x+xshift+(y+yshift)*500] = Texture[j];

					}
					x+=xshift;
					y+=yshift;
	    }
		}
	    public void Draw(Window w){
		    for(int i=0; i<TextureMap.length; i++){
					addbytearr(Texture[i], TextureMap[i]+x+y*500, w);
				}
	    }
}
