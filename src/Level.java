import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;


public class Level {
	int LevelNumber = 0;
	static BufferedImage lvlobg;
	static BufferedImage lvltwbg;
	static BufferedImage lvlthbg;
	static BufferedImage plntss;
	static BufferedImage tradeIMG;
	int window = 0;
	boolean minionspawned = false;
	
	Hero character;
	
	
	
	
	Font menuFont = new Font("Arial", Font.ITALIC, 20);
	Font TitleFont = new Font("Arial", Font.BOLD, 22);
	ArrayList<Minion> Minions = new ArrayList<>();

	Level(int LevelNumber, Hero character) {
		this.character = character;
		this.LevelNumber = LevelNumber;
		try {
			lvlobg = ImageIO.read(this.getClass().getResourceAsStream("Level 1/background.png"));
			lvltwbg = ImageIO.read(this.getClass().getResourceAsStream("Level 2/backgroundtw.png"));
			lvlthbg = ImageIO.read(this.getClass().getResourceAsStream("Level 3/backgroundth.png"));
			plntss = ImageIO.read(this.getClass().getResourceAsStream("Level 1/planets.png"));
			tradeIMG = ImageIO.read(this.getClass().getResourceAsStream("Level 1/trade.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void draw(Graphics g) {
		
		if (LevelNumber == 0) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, OrbAttacker.width, OrbAttacker.height);
			g.setFont(TitleFont);
			g.setColor(Color.YELLOW);
			g.drawString("Not very long ago at all, in fact, quite far in the future, in a galaxy quite close to us,", 200, 100);
			g.drawString("You are preparing for your first mission for our new Supreme Almighty Leaders, the FƎRZUƆ IMPERIUM.", 50, 150);
			g.drawString("They have tasked you to survey the system you are currently in, to find a suitable planet for advanced operations.", 25, 200);
			g.drawString("You must clear all of the planets of initial dangers, before the surveyors and terraformers arrive.", 100, 250);
			g.drawString("Your ship, the F.I.S dragonfly is equipped with highly advanced teleport beams,", 150, 300);
			g.drawString("Which will transport you to and from the planets.", 300, 350);
			g.drawString("Proceed now to the planet selection screen, and begin your mission.", 225, 400);
			
			g.drawString("(ESC to Continue)", 950,850);
			
													
		} else if (LevelNumber == 1) {
			g.drawImage(plntss, 0, 0, plntss.getWidth(), plntss.getHeight(), null);

			g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Welcome to the planet selection screen.", 400, 25);

		} else if (LevelNumber == 2) {
			
			g.drawImage(lvlobg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);

			
			if (window == 0) {
				if (!minionspawned) {

					for (int i = 0; i < 5; i++) {
						Random randx = new Random();
						int randnumx = randx.nextInt(1200);
						Random randy = new Random();
						int randnumy = randy.nextInt(300);
						
						Minions.add(new Minion(randnumx, randnumy, 100, 100, 0));

					}
					for (int i = 0; i < 10; i++) {
						Random randx = new Random();
						int randnumx = randx.nextInt(1200);
						Random randy = new Random();
						int randnumy = randy.nextInt(400);
						
						Minions.add(new Minion(randnumx, randnumy, 100, 100, 1));

					}
					minionspawned=true;
					
				}
				
				
				if (character.CharX >530 && character.CharY <35 && character.CharX< 685 && character.CharY >0 ) {
				newscreen();
			}
			}
			if (window == 1) {
				
					if (!minionspawned) {
character.CharX=525;
character.CharY = 700;
character.direction = character.North;
						for (int i = 0; i < 25; i++) {
							Random randx = new Random();
							int randnumx = randx.nextInt(1200);
							Random randy = new Random();
							int randnumy = randy.nextInt(300);
							
							Minions.add(new Minion(randnumx, randnumy, 100, 100, 0));

						}
						for (int i = 0; i < 5; i++) {
							Random randx = new Random();
							int randnumx = randx.nextInt(1200);
							Random randy = new Random();
							int randnumy = randy.nextInt(400);
							
							Minions.add(new Minion(randnumx, randnumy, 100, 100, 1));

						}
						for (int i = 0; i < 3; i++) {
							Random randx = new Random();
							int randnumx = randx.nextInt(1200);
							Random randy = new Random();
							int randnumy = randy.nextInt(200);
							
							Minions.add(new Minion(randnumx, randnumy, 100, 100, 2));

						}
						minionspawned=true;
					}
					if (character.CharX >530 && character.CharY <35 && character.CharX< 685 && character.CharY >0 ) {
						newscreen();
						
			}
			}
			if (window == 2) {
				
				if (!minionspawned) {

					for (int i = 0; i < 30; i++) {
						Random randx = new Random();
						int randnumx = randx.nextInt(1180);
						Random randy = new Random();
						int randnumy = randy.nextInt(300);
						
						Minions.add(new Minion(randnumx, randnumy, 100, 100, 0));

					}
					for (int i = 0; i < 5; i++) {
						Random randx = new Random();
						int randnumx = randx.nextInt(1180);
						Random randy = new Random();
						int randnumy = randy.nextInt(400);
						
						Minions.add(new Minion(randnumx, randnumy, 100, 100, 1));

					}
					for (int i = 0; i < 8; i++) {
						Random randx = new Random();
						int randnumx = randx.nextInt(1180);
						Random randy = new Random();
						int randnumy = randy.nextInt(200);
						
						Minions.add(new Minion(randnumx, randnumy, 100, 100, 2));

					}
					minionspawned=true;
				}
				if (character.CharX >530 && character.CharY <35 && character.CharX< 685 && character.CharY >0 ) {
					newscreen();
					
		}
			}
if (window == 3) {
				
				if (!minionspawned) {
					
					//add boss
					minionspawned=true;
				}
				
}

		 else if (LevelNumber == 3) {
			g.drawImage(lvltwbg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);
			g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 2", 400, 100);
		} else if (LevelNumber == 4) {
			g.drawImage(lvlthbg, 0, 0, OrbAttacker.width, OrbAttacker.height, null);
			g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Level 3", 400, 100);
		} else if (LevelNumber == 5) {
			g.drawImage(tradeIMG, 0, 0, tradeIMG.getWidth(), tradeIMG.getHeight(), null);

			g.setFont(menuFont);
			g.setColor(Color.YELLOW);
			g.drawString("Welcome to the trading post", 200, 50);
		}

			
		}
	}

	public void addMinions(ArrayList<Minion> al) {
		for (int i = 0; i < al.size(); i++) {
			Minions.add(al.get(i));
		}
	}

	public void update() {

	}
	public void newscreen() {
		
			while(Minions.size()>0) {
				Minions.remove(0);
			}
			window = window+1;
			character.CharX=525;
			character.CharY = 700;
			character.direction = character.North;
			
			minionspawned = false;
			System.out.println("Window "+ window);
		}
	
	
	
	
}
