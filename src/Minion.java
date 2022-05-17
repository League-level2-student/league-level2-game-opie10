import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Minion extends GameObject {


	public static BufferedImage gorillaIM;
	public static BufferedImage SnakeIM;
	public static BufferedImage largeIM;
	public BufferedImage CurrentMinionType;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean gorillaHits = false;
int Mtype;
	Minion(int x, int y, int width, int height, int type) {
		
		super(x, y, width, height);
		
		Mtype =type;
		collisionBox.x = CharX;
		collisionBox.y = CharY;
		if (needImage) {
			loadImages();
		}
		if (type == 0) {
		CurrentMinionType = gorillaIM;
		}
		else if (type == 1) {
			CurrentMinionType = SnakeIM;
			}
		else if (type == 2) {
			CurrentMinionType = largeIM;
			}
	}

	void draw(Graphics g) {
		if (gotImage) {
			if (GamePanel.hbs == 1) {
				
			
			g.setColor(Color.BLUE);
g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
			}		
			

				g.drawImage(CurrentMinionType, collisionBox.x, collisionBox.y, CharWidth, CharHeight, null);

			
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
				largeIM = ImageIO.read(this.getClass().getResourceAsStream("Level 1/gorilla.png"));
				gotImage = true;
			} catch (Exception e) {
				System.out.println("Error unable to load file");
				e.printStackTrace();
			}
			needImage = false;
		}
	}

}
