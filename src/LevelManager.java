import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LevelManager implements MouseListener {
	
	ArrayList<Level> Levels = new ArrayList<>();

	private Level CurrentLevel;
	boolean ingame = false;
	Level Storyline = new Level(0);
	Level Home = new Level(1);
	Level o1 = new Level(2);
	Level o2 = new Level(3);
	Level o3 = new Level(4);
	Level Trade = new Level(5);
	GamePanel gamePanel;
	World one;
	World two;
	World three;
	World Trader;
	ObjectManager ObjM;
ArrayList<Minion> Minions;
	
	LevelManager(GamePanel GP, ObjectManager Obj) {
		this.ObjM = Obj;
		this.Minions =Obj.Minions;
		one = new World(191, 221, 154);
		two = new World(598, 244, 154);
		three = new World(1007, 226, 154);
		Trader = new World(1255,40,35);

		gamePanel = GP;
		Levels.add(o1);
		Levels.add(o2);
		Levels.add(o3);
		Levels.add(Trade);
		Levels.add(Home);
		Levels.add(Storyline);
		changeLevel(0);
	}
	
	public void draw(Graphics g) {
		CurrentLevel.draw(g);
		if (CurrentLevel == o1 ||CurrentLevel == o2 ||CurrentLevel == o3 ) {
			ingame = true;
			
			if (gamePanel.Character != null) {
				
			
			gamePanel.Character.draw(g);
			}
			System.out.println(Minions.size());
			if (Minions != null) {
				
			
			for (int i = 0; i < ObjM.Minions.size(); i++) {
				ObjM.Minions.get(i).draw(g);
				System.out.println("drawing");
			}
			}
			for (int i = 0; i < gamePanel.ObjMan.projectile.size(); i++) {
				gamePanel.ObjMan.projectile.get(i).draw(g);
				gamePanel.ObjMan.projectile.get(i).update();
			}
					}
		
	}

	public void update() {
		CurrentLevel.update();
gamePanel.Character.update();

	}

	public void changeLevel(int newLevel) {
		
		if (newLevel == 0) {
			CurrentLevel = Storyline;

		}

		else if (newLevel == 1) {
			CurrentLevel = Home;
			
			gamePanel.JFrameDimen(Level.plntss.getWidth(), Level.plntss.getHeight());
		
		}
		

		else if (newLevel == 2) {
			CurrentLevel = o1;
			gamePanel.Character.CharX=525;
			gamePanel.Character.CharY=700;
			gamePanel.Character.direction=gamePanel.Character.North;
				gamePanel.JFrameDimen(OrbAttacker.width, OrbAttacker.height);
				
		
			
			
		} else if (newLevel == 3) {
			CurrentLevel = o2;
			gamePanel.Character.CharX=525;
			gamePanel.Character.CharY=700;
			gamePanel.Character.direction=gamePanel.Character.North;
			gamePanel.JFrameDimen(OrbAttacker.width, OrbAttacker.height);
		} else if (newLevel == 4) {
			gamePanel.Character.CharX=525;
			gamePanel.Character.CharY=700;
			gamePanel.Character.direction=gamePanel.Character.North;
			
			gamePanel.JFrameDimen(OrbAttacker.width, OrbAttacker.height);
			CurrentLevel = o3;
		} else if (newLevel == 5) {
			CurrentLevel = Trade;
			gamePanel.JFrameDimen(Level.tradeIMG.getWidth(), Level.tradeIMG.getHeight());
		}

	}

	

	public Level getLevel() {
		return CurrentLevel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (CurrentLevel == Home) {
			if (one.checkInside(e.getX(), e.getY())) {
				changeLevel(2);
			} else if (two.checkInside(e.getX(), e.getY())) {
				changeLevel(3);
			}

			else if (three.checkInside(e.getX(), e.getY())) {
				changeLevel(4);
			}
			else if (Trader.checkInside(e.getX(), e.getY())) {
				changeLevel(5);

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class World {
		int centerx;
		int centery;
		int radius;

		World(int x, int y, int r) {
			centerx = x;
			centery = y;
			radius = r;

		}

		public boolean checkInside(int Mousex, int Mousey) {
			int a = centerx - Mousex;
			int b = centery - Mousey;
			int c = (int) Math.sqrt((a * a) + (b * b));
			if (radius - c > 0) {
				return true;
			}
			return false;
		}
	}

}
