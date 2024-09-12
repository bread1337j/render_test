public class Sprite{
	int[] TextureMap;
    byte[][] Texture;
    int x = 0;
    int y = 0;
    public static void addbytearr(byte[] b, int loc, Window w){
        w.bytearrpow2[loc] = b;
    }
    public void Move(int x, int y){
	    for(int j : loc1){
			byte[] tmp = bytearrpow2[j];
			bytearrpow2[j+(x%500)+(y%500)*500] = tmp;
			bytearrpow2[j] = new byte[3];
		}
    }
    public void Draw(Window w){
    	for(int i=0; i<TextureMap.length; i++){
			addbytearr(Texture[i], TextureMap[i]+x+y*500, w);
		}
    }




}	
