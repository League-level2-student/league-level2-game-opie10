import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Font titleFont = new Font("Arial", Font.BOLD, 29);
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	int currentState = MENU;

	public void updateGameState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("WELCOME TO THE FƎRZUƆ IMPERIUM'S SHIP; THE F.I.S DRAGONFLY", 10, 100);
		g.setFont(menuFont);
		g.setColor(Color.YELLOW);

	}

	public void drawGameState(Graphics g) {

	}

	public void drawEndState(Graphics g) {

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {

		}
		if (currentState == GAME) {

		}
		if (currentState == END) {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
