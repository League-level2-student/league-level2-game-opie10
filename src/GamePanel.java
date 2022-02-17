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
	Hero Character = new Hero(525, 700, 150, 150) ;
	int currentState = MENU;
	LevelManager LevelManager = new LevelManager(this);
	Timer frameDraw;
	ObjectManager ObjMan = new ObjectManager(Character);
	 int cheat1 ;
	 int cheat2 ;
	 int cheat3;
	 boolean giveall =false;
	 boolean invincible = false;
	 boolean pm = false;
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
	JOptionPane.showMessageDialog(null, "-WASD to move\n" + "-Click to use weapon and open chests\n" + "-Enter to restart\n"+"-Movement relates to direction\n"+"  -Ex: If you rotate the character left,(Cont.)\n"+"  -(Cont.) W will take you (From your perspective) right.","Instructions",JOptionPane.INFORMATION_MESSAGE);
	
}if (e.getKeyCode()== KeyEvent.VK_ENTER) {
		currentState = GAME;
		repaint();
		System.out.println(currentState);
		frameDraw.start();
		LevelManager.changeLevel(6);
		}



		}
		if (LevelManager.getLevel() == LevelManager.Storyline) {
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				LevelManager.changeLevel(1);
			}
		}
		if (currentState == GAME) {
			
			
			int cheatsE = cheat1+cheat2+cheat3;
			if (e.getKeyCode()== KeyEvent.VK_Q) {
				Character.rotateleft();
				System.out.println(Character.direction);
			}
			if (e.getKeyCode()== KeyEvent.VK_E) {
				Character.rotateright();
				System.out.println(Character.direction);
			}
			if (e.getKeyCode()== KeyEvent.VK_W) {
				Character.foward();
			}
			if (e.getKeyCode()== KeyEvent.VK_A) {
				Character.left();
			}
			if (e.getKeyCode()== KeyEvent.VK_S) {
				Character.back();
			}
			if (e.getKeyCode()== KeyEvent.VK_D) {
				Character.right();
			}
			if (e.getKeyCode()== KeyEvent.VK_H) {
				JOptionPane.showMessageDialog(null, "-WASD to move\n" + "-Click to use weapon and open chests\n" + "-Enter to restart\n"+"-Movement relates to direction\n"+"  -Ex: If you rotate the character left,(Cont.)\n"+"  -(Cont.) W will take you (From your perspective) right.","Instructions",JOptionPane.INFORMATION_MESSAGE);
			}
				if (e.getKeyCode()==KeyEvent.VK_C) {
					cheat1 = 1;
					
				}
				if (e.getKeyCode()==KeyEvent.VK_V) {
					cheat2 = 2;
				}
				if (e.getKeyCode()==KeyEvent.VK_1) {
					cheat3 = 3;
					
				}
				if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					if (cheatsE==6) {
						JOptionPane.showMessageDialog(null, "Cheats Enabled");
					}
				}
				if (LevelManager.getLevel()==LevelManager.o1||LevelManager.getLevel()==LevelManager.o2||LevelManager.getLevel()==LevelManager.o3) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER) {
						LevelManager.changeLevel(1);
						
					}
				}
				if (cheatsE ==6) {
					if (e.getKeyCode()==KeyEvent.VK_H) {
						JOptionPane.showMessageDialog(null, "Cheat Controls:\n"+"(-) to activate invincibility\n"+"(=) to get all weapons & items\n"+"(.) to activate pacifist mode","Cheat Controls",JOptionPane.INFORMATION_MESSAGE);
						
					}
					if (e.getKeyCode()==KeyEvent.VK_EQUALS) {
						JOptionPane.showMessageDialog(null, "All Weapons have been given");
						giveall= true;
					}
				
					if (e.getKeyCode()==KeyEvent.VK_PERIOD) {
					
						
					}
				
					if (e.getKeyCode()==KeyEvent.VK_MINUS) {
					
							JOptionPane.showMessageDialog(null, "Invincibilty Active");
							invincible = true;
						
						
						
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
Character.XSpeed = 0;
Character.YSpeed= 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LevelManager.update();
		
		repaint();
	}
	

}
