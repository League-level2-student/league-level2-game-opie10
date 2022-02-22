import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Minions {
	public static BufferedImage gorilla;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	void draw(){
		
	}
	public void update() {
			
		}
		// TODO Auto-generated constructor stub
	









	
	


		
	     
	     


	
	
	
	
	
	
   	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            gorilla = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}









	public static void Spawn1() {
		// TODO Auto-generated method stub
		
		
	}
	
}
