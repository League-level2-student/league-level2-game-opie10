import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	ArrayList<Projectile> projectile = new ArrayList<>();
	ArrayList<Minion> Minions = new ArrayList<>();
	Projectile proj;
	boolean shootright = false;

	int score = 0;
	Boolean isInvincible = false;
	Hero h;

	ObjectManager(Hero Hero) {
		h = Hero;
		
	}

	public void addProjectile(Projectile pow) {
		
		if (shootright == true) {
			
			
			if (h.direction == h.North) {
				pow.CharX = h.CharX + 28;
				projectile.add(pow);
				shootright = false;
				return;
			}
			if (h.direction == h.East) {
				pow.projX = h.CharX + 110;
				pow.CharY = h.CharY + 107;
				projectile.add(pow);
				shootright = false;
				return;
			}
			if (h.direction == h.South) {
				pow.CharX = h.CharX + 110;
				pow.projY = h.CharY +105;
				projectile.add(pow);
				shootright = false;
				return;
			}
			if (h.direction == h.West) {
				pow.projX= h.CharX+25;
				pow.CharY = h.CharY + 107;
				projectile.add(pow);
				shootright = false;
				return;
			}

		}

		if (shootright == false) {
			if (h.direction == h.North) {
				pow.CharX = h.CharX +105;
				projectile.add(pow);
				shootright = true;
				return;
			}
			if (h.direction == h.East) {
				pow.CharY = h.CharY + 28;
				pow.projX = h.CharX + 115;
				projectile.add(pow);
				shootright = true;
				return;
			}
			if (h.direction == h.South) {
				pow.projY = h.CharY + 110;
				pow.CharX = h.CharX + 34;
				projectile.add(pow);
				shootright = true;
				return;
			}
			if (h.direction == h.West) {
				pow.CharY = h.CharY + 34;
				pow.projX = h.CharX + 25;
				projectile.add(pow);
				shootright = true;
				return;
			}

		}

	}

	public void update() {
		
		for (int i = 0; i < Minions.size(); i++) {
			if (Minions.get(i).Mtype==0) {
				if (Minions.get(i).collisionBox.x>=h.CharX) {
					Minions.get(i).collisionBox.x -=1;
				}
				if (Minions.get(i).collisionBox.x<=h.CharX) {
					Minions.get(i).collisionBox.x +=1;
				}
				if (Minions.get(i).collisionBox.y>=h.CharY) {
					Minions.get(i).collisionBox.y -=1;
				}
				if (Minions.get(i).collisionBox.y<=h.CharY) {
					Minions.get(i).collisionBox.y +=1;
				}
				
			}
			if (Minions.get(i).Mtype==1) {
				if (Minions.get(i).collisionBox.x>=h.CharX) {
					Minions.get(i).collisionBox.x -=2;
				}
				if (Minions.get(i).collisionBox.x<=h.CharX) {
					Minions.get(i).collisionBox.x +=2;
				}
				if (Minions.get(i).collisionBox.y>=h.CharY) {
					Minions.get(i).collisionBox.y -=2;
				}
				if (Minions.get(i).collisionBox.y<=h.CharY) {
					Minions.get(i).collisionBox.y +=2;
				}
			}
		}
		System.out.println("the amnt of minions is "+Minions.size());
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).update();

			
				if(projectile.get(i).projY>OrbAttacker.height) {
			
			projectile.get(i).isAlive = false;
				}
				if (projectile.get(i).projY<0) {
					projectile.get(i).isAlive = false;
				}
				if (projectile.get(i).projX>OrbAttacker.width) {
					projectile.get(i).isAlive = false;
				}
				if (projectile.get(i).projX<0) {
					projectile.get(i).isAlive = false;
				}
				
		
			
		}
		for (int i = 0; i < Minions.size(); i++) {
			Minions.get(i).update();
			 checkcollision();

			
	}

	 
	 purgeObjects();
	 scoreTrack();

	}

	public void draw(Graphics g) {

		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).draw(g);
		}
	}

	public void resetMinions() {
		
		while (Minions.size()>0) {
		Minions.remove(0);	
		}
			
	}
	public void purgeObjects() {

		for (int i = 0; i < Minions.size(); i++) {
			Minions.get(i);
			if (Minions.get(i).isAlive == false) {
			 Minions.remove(i);
			 }
		}
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i);
			if (projectile.get(i).isAlive == false) {
			 projectile.remove(i);
			 }
		}
		
		

	}

	public void checkcollision() {
		
		
		for (int i = 0; i < Minions.size(); i++) {
			
			Rectangle Minionc = Minions.get(i).collisionBox;
			Rectangle Charc = h.collisionBox;
			
				if (Minionc.intersects(Charc)) {
					h.isAlive = false;
				
					GamePanel.currentState=GamePanel.RESET;
						
					
			}
			for (int p = 0; p < projectile.size(); p++) {
				Rectangle rt = projectile.get(p).collisionBox;
		
				
				if (rt.intersects(Minionc)) {
					projectile.get(p).isAlive = false;
					Minions.get(i).isAlive = false;
					score += 1;
					
				}
				
		}
			
		}
		

	}

	public int scoreTrack() {

		return score;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void getMinions() {

	}
}
