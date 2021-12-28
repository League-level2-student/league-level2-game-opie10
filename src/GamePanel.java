import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	
	Font titleFont = new Font("Arial", Font.BOLD, 29);
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	int currentState = MENU;
	LevelManager LevelManager = new LevelManager();
	public void updateGameState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("WELCOME TO THE FƎRZUƆ IMPERIUM'S SHIP: THE F.I.S DRAGONFLY", 100, 100);
		g.setFont(menuFont);
		g.setColor(Color.YELLOW);
		g.drawString("You will be briefed on your mission on the way to your dropoff point.", 300, 400);
		g.setFont(menuFont);
		g.setColor(Color.YELLOW);
		g.drawString("Space for Instructions", 500, 800);
		//blinking font below? do-able but for end
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("Enter to Begin", 500, 600);

	}

	public void drawGameState(Graphics g) {
	LevelManager.draw(g);	

	}

	public void drawEndState(Graphics g) {

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
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
if (e.getKeyCode()== KeyEvent.VK_SPACE) {
	JOptionPane.showMessageDialog(null, "WASD to move\n" + "Click to use weapon and open chests\n" + "Enter to restart\n","Instructions",JOptionPane.INFORMATION_MESSAGE);
	
}if (e.getKeyCode()== KeyEvent.VK_ENTER) {
		currentState = GAME;
		repaint();
		System.out.println(currentState);
		System.out.println(LevelManager.CurrentLevel.LevelNumber);
		LevelManager.CurrentLevel = LevelManager.Home;
		}



		}
		if (currentState == GAME) {
			
			if (e.getKeyCode()== KeyEvent.VK_W) {}
			if (e.getKeyCode()== KeyEvent.VK_A) {}
			if (e.getKeyCode()== KeyEvent.VK_S) {}
			if (e.getKeyCode()== KeyEvent.VK_D) {}
			if (e.getKeyCode()== KeyEvent.VK_ENTER) {}
			
		}
		
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
