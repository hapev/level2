package evanGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;

import leagueInvaders.Alien;
import leagueInvaders.Runner;

public class ObjectManager {
	ArrayList<Spike> SpikeList = new ArrayList<Spike>();
	survivor man;
	long enemyTimer = 0;
	int enemySpawnTime = 700;

	public ObjectManager(survivor s) {
		this.man = s;
	}

	public void update() {
		man.update();
		
		
		
		for (int x = 0; x < SpikeList.size(); x++) {
			SpikeList.get(x).update();

		}
		checkCollision();
		manageEnemies();
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addSpike(new Spike(1280, 670, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}
	public void draw(Graphics g) {
		man.draw(g);
		for (int x = 0; x < SpikeList.size(); x++) {

			SpikeList.get(x).draw(g);

		}

	}
	public void addSpike(Spike s) {
		SpikeList.add(s);
	}
	public void checkCollision() {
		for (int x = 0; x < SpikeList.size(); x++) {

			if (man.collisionBox.intersects(SpikeList.get(x).collisionBox)) {

				man.isAlive = false;

			
			}
		}

		
	}
}
