import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	
	public static BufferedImage imageN;
	public static BufferedImage imageE;
	public static BufferedImage imageS;
	public static BufferedImage imageW;
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
    	 if (direction==North) {
    		 g.drawImage(imageN, CharX, CharY, CharWidth, CharHeight, null);
		}
    	 if (direction==East) {
    		 g.drawImage(imageE, CharX, CharY, CharWidth, CharHeight, null);
		}
    	 if (direction==South) {
    		 g.drawImage(imageS, CharX, CharY, CharWidth, CharHeight, null);
		}
    	 if (direction==West) {
    		 g.drawImage(imageW, CharX, CharY, CharWidth, CharHeight, null);
		}
    		
    	
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
	if (direction == North) {
    	XSpeed=-5;
    	
	}
    if (direction == East) {
    	YSpeed =-5;
    	
	}
    if (direction == South) {
    	XSpeed =5;;
    	
	}
    if (direction == West) {
    	YSpeed =5;
    	
	}
	
    super.update();
}
public void foward() {
	if (direction == North) {
    	YSpeed=-5;
    	
	}
    if (direction == East) {
    	XSpeed =5;
    	
	}
    if (direction == South) {
    	YSpeed =5;;
    	
	}
    if (direction == West) {
    	XSpeed =-5;
    	
	}
	
    super.update();
}
public void back() {
	if (direction == North) {
    	YSpeed=5;
    	
	}
    if (direction == East) {
    	XSpeed =-5;
    	
	}
    if (direction == South) {
    	YSpeed =-5;;
    	
	}
    if (direction == West) {
    	XSpeed =5;
    	
	}
	
   super.update();
   
}
public void rotateleft() {
	if (direction ==North) {
		direction = West;
		System.out.println("North--> West");
	}
	if (direction ==East) {
		direction = North;
		System.out.println("East--> North");
	}
	if (direction ==South) {
		direction = East;
		System.out.println("South--> East");
	}
	if (direction ==West) {
		direction = South;
		System.out.println("West--> South");
	}
}
public void rotateright() {
	if (direction ==North) {
		direction = East;
		System.out.println("North--> East");
	}
	
	else if (direction ==East) {
		direction = South;
		System.out.println("East--> South");
	}
	else if (direction ==South) {
		direction = West;
		System.out.println("South--> West");
	}
	else if (direction ==West) {
		direction = North;
		System.out.println("West--> North");
	}
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
            imageN = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            imageE = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            imageS = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            imageW = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            
	    gotImage = true;
        } catch (Exception e) {
            System.out.println("Error unable to load file");
            e.printStackTrace();
        }
        needImage = false;
    }
}
}
