import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
public class ObjectManager implements ActionListener {
	ArrayList<Projectile> projectile = new ArrayList<>();
	ArrayList<Minions> Minion = new ArrayList<>();
Projectile proj;
	boolean shootright = false;
	
	int score = 0;
	Boolean isInvincible = false;
	Hero h;
	ObjectManager(Hero Hero) {
		h = Hero;
	}





	

	

	public void addProjectile(Projectile pow) {
		
	
		if (shootright==true) {
			if (h.direction==h.North) {
				pow.projX = pow.CharX +28;
				projectile.add(pow);
			    shootright = false;
			    return;	
			}
			if (h.direction==h.East) {
				pow.projX = pow.CharX+35;
				pow.projY = pow.CharY +107 ;
				projectile.add(pow);
			    shootright = false;
			    return;	
			}
			if (h.direction==h.South) {
				pow.projX = pow.CharX-41;
				pow.projY = pow.CharY +110;
				projectile.add(pow);
			    shootright = false;
			    return;	
			}
			if (h.direction==h.West) {
				pow.projX = pow.CharX-50;
				pow.projY = pow.CharY +107;
				projectile.add(pow);
			    shootright = false;
			    return;	
			}
			
		} 
		 
	 if (shootright==false) {
		 if (h.direction==h.North) {
			 pow.projX = pow.CharX -45;
				projectile.add(pow);
				shootright =true;
				return;
			}
		 if (h.direction==h.East) {
			 pow.projY = pow.CharY +28;
			 pow.projX = pow.CharX +35;
				projectile.add(pow);
				shootright =true;
				return;
			}
		 if (h.direction==h.South) {
			 pow.projY = pow.CharY +110;
			 pow.projX = pow.CharX +34;
				projectile.add(pow);
				shootright =true;
				return;
			}
		if (h.direction==h.West) {
			pow.projY = pow.CharY +34   ;
			 pow.projX = pow.CharX -50;
				projectile.add(pow);
				shootright =true;
				return;
		}
			
			
			
	 }
		
	}


	public void update() {

		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).update();

			if (projectile.get(i).projY < OrbAttacker.height) {
				projectile.get(i).isAlive = false;
			}
		}
	for (int i = 0; i < Minion.size(); i++) {
			Minion.get(i).update();

			if (Minion.get(i).MinionY > OrbAttacker.height) {
				//Minion.get(i).isAlive = false;
			}
		}

		checkCollision();
		purgeObjects();
		scoreTrack();
		

	}

	public void draw(Graphics g) {
		
		for (int i = 0; i < Minion.size(); i++) {
			Minion.get(i).draw(g);
		}
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).draw(g);
		}
	}

	

	public void purgeObjects() {

		for (int i = 0; i < Minion.size(); i++) {
			Minion.get(i);
			//if (Minion.get(i).isAlive == false) {
			//	Minion.remove(i);
			//}
		}

	}

	public void checkCollision() {

	}

	public int scoreTrack() {

		return score;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
