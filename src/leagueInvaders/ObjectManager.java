package leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	Rocketship rocketship;

	ArrayList<Projectile> ProjectileList = new ArrayList<Projectile>();

	public ObjectManager(Rocketship rocket) {
		this.rocketship = rocket;

	}

	public void update() {
		rocketship.update();

	}

	public void draw(Graphics g) {
		rocketship.draw(g);

	}

}
