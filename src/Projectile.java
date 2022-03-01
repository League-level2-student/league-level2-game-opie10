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
			System.out.println("@loadimage");
			loadImage("lazer.png");
		}
	}

	public void update() {
		if (direction == North) {
System.out.println("Proj facing north");
			projY -= speed;
			return;
		}
		if (direction == East) {
			System.out.println("Proj facing east");
			projX += speed;
			return;
		}
		if (direction == South) {
			System.out.println("Proj facing south");
			projY += speed;
			return;
		}

		if (direction == West) {
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
