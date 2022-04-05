import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {
	int projY = CharY;
	int projX = CharX + 28;
	GameObject GO;

	public static BufferedImage imageNS;
	public static BufferedImage imageEW;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Projectile(int x, int y, int width, int height, int direction) {
		super(x, y, width, height);
		projdirection = direction;
		// TODO Auto-generated constructor stub
		speed = 6;

		if (needImage) {

			loadImage("lazer.png");
		}

	}

	public void update() {
		if (projdirection == 1) {

			projY = projY - speed;
			return;
		} else if (projdirection == 2) {

			projX = projX + speed;
			return;
		} else if (projdirection == 3) {

			projY += speed;
			return;
		}

		else if (projdirection == 4) {

			projX -= speed;
			return;

		}

		super.update();
	}

	public void draw(Graphics g) {
		if (gotImage) {
			if (projdirection == 1) {
				g.drawImage(imageNS, projX, projY, 10, 10, null);
			} else if (projdirection == 3) {
				g.drawImage(imageNS, projX, projY, 10, 10, null);
			} else if (projdirection == 2) {
				g.drawImage(imageEW, projX, projY, 10, 10, null);
			} else if (projdirection == 4) {
				g.drawImage(imageEW, projX, projY, 10, 10, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(projX, projY, 10, 10);
			}
		}
	}

	void loadImage(String imageFile) {

		if (needImage = true) {

			try {
				imageNS = ImageIO.read(this.getClass().getResourceAsStream("Level 1/lazerNS.png"));
				imageEW = ImageIO.read(this.getClass().getResourceAsStream("Level 1/lazerEW.png"));
				gotImage = true;
			} catch (Exception e) {
			}
			needImage = false;

		}
	}
}
