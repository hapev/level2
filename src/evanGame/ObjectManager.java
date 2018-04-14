package evanGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;

import leagueInvaders.Alien;
import leagueInvaders.Runner;

public class ObjectManager {
	ArrayList<NormalEnemy> NormalList = new ArrayList<NormalEnemy>();
	survivor man;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(survivor s) {
		this.man = s;
	}

	public void update() {
		man.update();
		
		
		
		for (int x = 0; x < NormalList.size(); x++) {
			NormalList.get(x).update();

		}
		checkCollision();
		manageEnemies();
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addSpike(new NormalEnemy(1280, 670, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}
	public void draw(Graphics g) {
		man.draw(g);
		for (int x = 0; x < NormalList.size(); x++) {

			NormalList.get(x).draw(g);

		}

	}
	public void addSpike(NormalEnemy s) {
		NormalList.add(s);
	}
	public void checkCollision() {
		for (int x = 0; x < NormalList.size(); x++) {

			if (man.collisionBox.intersects(NormalList.get(x).collisionBox)) {

				man.isAlive = false;

			
			}
		}

		
	}
}
