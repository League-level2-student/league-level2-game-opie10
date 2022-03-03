import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends Hero {
	int projY = CharY;
	int projX = CharX + 28;
	GameObject GO;

	public static BufferedImage image;

	public static boolean needImage = true;
	public static boolean gotImage = false;

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;

		if (needImage) {
			
			loadImage("lazer.png");
		}
	}

	public void update() {
		if (direction == North) {
		//projY = CharY;
			//projX=CharX+28;
			System.out.println("Proj facing north");
		projY =	projY-speed;
			return;
	}
		else if (direction == East) {
			projY = CharY+10;
			projX=CharX-15;
			System.out.println("Proj facing east");
			projX = projX + speed;
			return;
		}
		else if (direction == South) {
			projY = CharY+23;
			projX=CharX;
			System.out.println("Proj facing south");
			projY += speed;
			return;
		}

		else if (direction == West) {
			projY = CharY+10;
			projX=CharX - 13;
			System.out.println("Proj facing west");
			projX -= speed;
			return;

		}

		super.update();
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, projX, projY, 10, 10, null);

		} else {
			g.setColor(Color.BLUE);
			g.fillRect(projX, projY, 10, 10);
		}
	}

	void loadImage(String imageFile) {

		if (needImage = true) {

			try {
				image = ImageIO.read(this.getClass().getResourceAsStream("Level 1/lazer.png"));

				gotImage = true;
			} catch (Exception e) {
			}
			needImage = false;

		}
	}
}
