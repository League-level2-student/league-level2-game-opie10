import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	JFrame frame;
	Font titleFont = new Font("Arial", Font.BOLD, 29);
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	Hero Hero;
	int currentState = MENU;
	LevelManager LevelManager = new LevelManager(this);
	Timer frameDraw;
	ObjectManager ObjMan = new ObjectManager(Hero);
GamePanel(JFrame jf){
	frame = jf;
	jf.addMouseListener(LevelManager);
	 frameDraw = new Timer(1000 / 60, this);
	
}
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
		frameDraw.start();
		}



		}
		if (currentState == GAME) {
			
		
			if (e.getKeyCode()== KeyEvent.VK_W) {
				Hero.foward();
			}
			if (e.getKeyCode()== KeyEvent.VK_A) {
				Hero.left();
			}
			if (e.getKeyCode()== KeyEvent.VK_S) {
				Hero.back();
			}
			if (e.getKeyCode()== KeyEvent.VK_D) {
				Hero.right();
			}
			
			if (LevelManager.getLevel() == LevelManager.Storyline) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
					LevelManager.changeLevel(1);
					
				}
			}
			
			
			
		}
		
			
	}

	public void JFrameDimen(int w,int h) {
		frame.setPreferredSize(new Dimension(w,h));
		frame.pack();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LevelManager.update();
		repaint();
	}
	

}
