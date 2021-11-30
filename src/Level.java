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
			g.drawString("Starting Level 1", 400, 100);
	}
		
	
	 

}
 public void update() {
	

}
}
