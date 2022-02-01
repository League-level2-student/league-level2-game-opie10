import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Hero extends GameObject{
	
	
	static int XSpeed;
	static int YSpeed;
	static final int North = 1;
	static final int East= 2;
	static final int South = 3;
	static final int West = 4;
	int direction = North;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
Hero(int CharX, int CharY, int CharWidth, int CharHeight) {
	
	super(CharX, CharY, CharWidth, CharHeight);
	// TODO Auto-generated constructor stub
	if (needImage) {
	    loadImage ("Level 1/hero.png");
	}

	

	
}
void draw(Graphics g)
{
	
     if (gotImage) {
    		g.drawImage(image, CharX, CharY, CharWidth, CharHeight, null);
    	
    	} 


}


public void right() {
    if (direction == North) {
    	XSpeed=5;
    	
	}
    if (direction == East) {
    	YSpeed =5;
    	
	}
    if (direction == South) {
    	XSpeed =-5;;
    	
	}
    if (direction == West) {
    	YSpeed =-5;
    	
	}
	
    super.update();
}
public void left() {
    XSpeed=-5;
    super.update();
}
public void foward() {
    YSpeed=-5;
    super.update();
}
public void back() {
   YSpeed=5;
   super.update();
   
}
public void rotateleft() {
	
}
public void rotateright() {
	
}
public void update () {

	if (CharX + XSpeed > 0 && CharX+CharWidth+XSpeed<OrbAttacker.width) {
		CharX += XSpeed ;
	}
	if (CharY+YSpeed> 0 && CharY+CharHeight+YSpeed<OrbAttacker.height) {
		CharY += YSpeed ;
	}
	
	super.update();
}
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            System.out.println("Error unable to load file");
            e.printStackTrace();
        }
        needImage = false;
    }
}
}
