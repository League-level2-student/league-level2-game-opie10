import java.awt.Graphics;
import java.util.ArrayList;

public class LevelManager {
	ArrayList<Level> Levels = new ArrayList<>();
	private Level CurrentLevel;
	Level Storyline = new Level(0);
	Level Home = new Level(1);
	Level o1 = new Level(2);
	Level o2 = new Level(3);
	Level o3 = new Level(4);
	Level Trade = new Level(5);
	GamePanel gamePanel ;

	LevelManager(GamePanel GP) {
gamePanel =  GP;
		Levels.add(o1);
		Levels.add(o2);
		Levels.add(o3);
		Levels.add(Trade);
		Levels.add(Home);
		Levels.add(Storyline);
		changeLevel(0);
	}

	public void draw(Graphics g) {
System.out.println("Drawing level");
		CurrentLevel.draw(g);
	}

	public void update() {
		CurrentLevel.update();

	}

	public void changeLevel(int newLevel) {
		System.out.println(newLevel);
		if (newLevel == 0) {
		CurrentLevel= Storyline;
		
		}
			
		else if (newLevel == 1) {
			CurrentLevel = Home;
			gamePanel.JFrameDimen(Level.plntss.getWidth(), Level.plntss.getHeight());
		}
		
		 else if (newLevel == 2) {
			CurrentLevel = o1;
		} else if (newLevel == 3) {
			CurrentLevel = o2;
		} else if (newLevel == 4) {
			CurrentLevel = o3;
		}
		else if (newLevel == 5) {
			CurrentLevel = Trade;
		}

	}
	public Level getLevel() {
	return CurrentLevel;
	}
}
