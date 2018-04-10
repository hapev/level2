package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;

public class ObjectManager {

	Rocketship rocketship;
	long enemyTimer = 0;
	int enemySpawnTime = 500;
	public int score = 0;
	boolean killed = false;

	ArrayList<Projectile> ProjectileList = new ArrayList<Projectile>();

	ArrayList<Alien> AlienList = new ArrayList<Alien>();

	public ObjectManager(Rocketship rocket) {
		this.rocketship = rocket;

	}

	public void update() {
		rocketship.update();
		for (int x = 0; x < ProjectileList.size(); x++) {
			ProjectileList.get(x).update();

		}
		for (int x = 0; x < AlienList.size(); x++) {

			AlienList.get(x).update();
			if (AlienList.get(x).kill()==true) {
				killed = true;
				
			}

		}
		manageEnemies();
<<<<<<< HEAD
		for (int x = 0; x < AlienList.size(); x++) {


			

		}
=======
		
		
	}
	public boolean kill2() {
		return killed;
		
		
		
>>>>>>> 18fb9175f21344e80de6a48ddcf849200aefe27a
	}
	public void draw(Graphics g) {
		rocketship.draw(g);

		for (int x = 0; x < ProjectileList.size(); x++) {

			ProjectileList.get(x).draw(g);

		}

		for (int x = 0; x < AlienList.size(); x++) {
			g.setColor(Color.BLUE);
			AlienList.get(x).draw(g);

		}
	}

	public void addProjectile(Projectile p) {
		ProjectileList.add(p);
	}

	public void addAlien(Alien a) {
		AlienList.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(Runner.gameWidth), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int x = 0; x < ProjectileList.size(); x++) {
			if (ProjectileList.get(x).isAlive == false) {
				ProjectileList.remove(ProjectileList.get(x));

			}

		}
		for (int x = 0; x < AlienList.size(); x++) {
			if (AlienList.get(x).isAlive == false) {
				AlienList.remove(AlienList.get(x));

			}

		}
	}

	public void checkCollision() {
		for (int x = 0; x < AlienList.size(); x++) {

			if (rocketship.collisionBox.intersects(AlienList.get(x).collisionBox)) {

				rocketship.isAlive = false;

			}
			for (int a = 0; a < ProjectileList.size(); a++) {
			if(ProjectileList.get(a).collisionBox.intersects(AlienList.get(x).collisionBox)) {
				ProjectileList.get(a).isAlive = false;
				AlienList.get(x).isAlive = false;
				score++;
				
			}
			}
		}

		
	}
}