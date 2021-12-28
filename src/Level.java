import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Level {
	int LevelNumber = 0;
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	Level(int LevelNumber){
		this.LevelNumber=LevelNumber;
		
		
	}
 public void draw(Graphics g) {
	if (LevelNumber ==0) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("[Insert story here]", 400, 100);
	}
	else if (LevelNumber ==1) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Welcome to the planet selection screen.", 400, 100);
	}
	else if (LevelNumber ==2) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 1", 400, 100);
	}
	else if (LevelNumber ==3) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 2", 400, 100);
	}
	else if (LevelNumber ==4) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 3", 400, 100);
	}
	else if (LevelNumber ==5) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Trading Post", 400, 100);
	}
	
	
	 

}
 public void update() {
	

}
}
