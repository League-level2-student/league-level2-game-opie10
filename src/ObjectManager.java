import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
public class ObjectManager implements ActionListener {
	ArrayList<Projectile> projectile = new ArrayList<>();
	ArrayList<Minions> Minion = new ArrayList<>();
	Random rand = new Random();
	
	int score = 0;
	Boolean isInvincible = false;
	Hero h;
	ObjectManager(Hero Hero) {
		h = Hero;
	}





	

	

	public void addProjectile(Projectile pow) {
		if (pow.shootright=true) {
			pow.projX = pow.CharX +28;
			projectile.add(pow);
			pow.shootright = false;
		} 
		
		else if (pow.shootright=false) {
			pow.projX = pow.CharX -28;
			projectile.add(pow);
			pow.shootright = true;
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
