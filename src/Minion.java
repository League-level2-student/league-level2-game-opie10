import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Minion extends GameObject{
	int type;
	
	public static BufferedImage gorillaIM;
	public static BufferedImage SnakeIM;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	Minion(int x, int y, int width, int height, int type){
		 super(x,y,width,height);
		
	}


	void draw(Graphics g){
		
	if (type == 0) {
		System.out.println("draw minion");
		if (gotImage) {
			g.drawImage(gorillaIM, CharX, CharY, CharWidth, CharHeight, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(CharX, CharY, CharWidth, CharHeight);
		}
	}
	else if (type == 1) {
		if (gotImage) {
			g.drawImage(SnakeIM, CharX, CharY, CharWidth, CharHeight, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(CharX, CharY, CharWidth, CharHeight);
		}
	}
	}
	public void update() {
			
		}
		// TODO Auto-generated constructor stub

	
	
   	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            gorillaIM = ImageIO.read(this.getClass().getResourceAsStream("Level 1/monkey.png"));
	          SnakeIM = ImageIO.read(this.getClass().getResourceAsStream("Level 1/snake.png"));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}









	
}
