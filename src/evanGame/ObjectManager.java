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
	ArrayList<DoubleEnemy> DoubleList = new ArrayList<DoubleEnemy>();
	survivor man;
	Random r = new Random();
	long enemyTimer = 0;
	long enemyTimer2 = System.currentTimeMillis();
	int enemySpawnTime = 800;
	int enemySpawnTimeDouble = r.nextInt(1000)+3200;
	public ObjectManager(survivor s) {
		this.man = s;
	}

	public void update() {
		man.update();
		
		
		
		for (int x = 0; x < NormalList.size(); x++) {
			NormalList.get(x).update();

		}
		for (int x = 0; x < DoubleList.size(); x++) {
			DoubleList.get(x).update();

		}
		checkCollision();
		manageEnemies();
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addNormalEnemy(new NormalEnemy(1280, 670, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - enemyTimer2 >= enemySpawnTimeDouble) {
			addDoubleEnemy(new DoubleEnemy(1280, 570, 50, 150));

			enemyTimer2 = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g) {
		man.draw(g);
		for (int x = 0; x < NormalList.size(); x++) {

			NormalList.get(x).draw(g);

		}
		for (int x = 0; x < DoubleList.size(); x++) {

			DoubleList.get(x).draw(g);

		}
	}
	public void addNormalEnemy(NormalEnemy s) {
		NormalList.add(s);
	}
	public void addDoubleEnemy(DoubleEnemy s) {
		DoubleList.add(s);
	}
	public void checkCollision() {
		for (int x = 0; x < NormalList.size(); x++) {

			if (man.collisionBox.intersects(NormalList.get(x).collisionBox)) {

				man.isAlive = false;
				
			
			}
			for (int x1 = 0; x1 < DoubleList.size(); x1++) {

				if (man.collisionBox.intersects(DoubleList.get(x1).collisionBox)) {

					man.isAlive = false;
					
				
				}
		

		
		}

		
	}
	}}
