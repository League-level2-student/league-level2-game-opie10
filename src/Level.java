import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level {
	int LevelNumber = 0;
	static BufferedImage lvlobg;
	static BufferedImage lvltwbg;
	static BufferedImage lvlthbg;
	static BufferedImage plntss;
	int window = 0;
	ObjectManager obj;
	LevelManager LM;
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	Level(ObjectManager obj){
		
	}
Level(LevelManager LeMan){
		
	}
	Level(int LevelNumber){
		this.LevelNumber=LevelNumber;
		try {
			lvlobg = ImageIO.read(this.getClass().getResourceAsStream("Level 1/background.png"));
			lvltwbg = ImageIO.read(this.getClass().getResourceAsStream("Level 2/backgroundtw.png"));
			lvlthbg = ImageIO.read(this.getClass().getResourceAsStream("Level 3/backgroundth.png"));
			plntss = ImageIO.read(this.getClass().getResourceAsStream("Level 1/planets.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
 public void draw(Graphics g) {
	if (LevelNumber==0) {
		 g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("[Insert story here]", 400, 100);
			
	}
	else if (LevelNumber ==1) {
		g.drawImage(plntss, 0, 0, plntss.getWidth(), plntss.getHeight(), null);
			
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Welcome to the planet selection screen.", 400, 100);
			
	}
	else if (LevelNumber ==2) {
		g.drawImage(lvlobg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);
			
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 1", 400, 100);
			if (window ==0) {
				for (int i = 0; i < obj.Minion.size(); i++) {
					obj.Minion.add(new Minion(500,100,100,100,0));
					System.out.println("add minion");
				}
			}
			
	}
	else if (LevelNumber ==3) {
		g.drawImage(lvltwbg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);
		 	g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 2", 400, 100);
	}
	else if (LevelNumber ==4) {
		g.drawImage(lvlthbg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);
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
