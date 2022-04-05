
import java.awt.Rectangle;

public class GameObject {
	int CharX = 525;
	int CharY = 700;
	int CharWidth = 20;
	int CharHeight = 20;
	int HX;
	int HY;
	Hero h;
	int projdirection;
	int speed = 10;
	boolean isAlive;
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height) {
		isAlive = true;
		this.CharX = x;
		this.CharY = y;
		this.CharWidth = width;
		this.CharHeight = height;
		collisionBox = new Rectangle(x, y, width, height);
	}

	public void update() {
		collisionBox.setBounds(CharX, CharY, CharWidth, CharHeight);

	}

}
