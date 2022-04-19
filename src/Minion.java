import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Minion extends GameObject {


	public static BufferedImage gorillaIM;
	public static BufferedImage SnakeIM;
	public BufferedImage CurrentMinionType;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Minion(int x, int y, int width, int height, int type) {
		super(x, y, width, height);
		if (needImage) {
			loadImages();
		}
		if (type == 0) {
		CurrentMinionType = gorillaIM;
		}
		else if (type == 1) {
			CurrentMinionType = SnakeIM;
			}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.setColor(Color.BLUE);
g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
			
			

				g.drawImage(CurrentMinionType, CharX, CharY, CharWidth, CharHeight, null);

			
		}
	}

	public void update() {

	}
	// TODO Auto-generated constructor stub

	void loadImages() {
		if (needImage) {
			
			try {
				gorillaIM = ImageIO.read(this.getClass().getResourceAsStream("Level 1/monkey.png"));
				SnakeIM = ImageIO.read(this.getClass().getResourceAsStream("Level 1/snake.png"));
				
				gotImage = true;
			} catch (Exception e) {
				System.out.println("Error unable to load file");
				e.printStackTrace();
			}
			needImage = false;
		}
	}

}
