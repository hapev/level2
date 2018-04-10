package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed = 10;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void update() {
		super.update();

		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}

	}

	public void draw(Graphics g) {
		 g.drawImage(gamePanel.bulletImg, x, y, width, height, null);

	}
}
