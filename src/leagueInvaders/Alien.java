package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void update() {
		super.update();
		y++;
<<<<<<< HEAD
		if (y > Runner.gameHeight) {
			isAlive = false;
		
			
	
			
		}
		if (y > Runner.gameHeight) {
			isAlive = false;
			
			
			
			
	
			
		}

	}

	
=======
			

	}

	public void draw(Graphics g) {

		g.drawImage(gamePanel.alienImg, x, y, width, height, null);
>>>>>>> 18fb9175f21344e80de6a48ddcf849200aefe27a

	public void draw(Graphics g) {
		 g.drawImage(gamePanel.alienImg, x, y, width, height, null);
	}
	public boolean kill() {
		if (y > Runner.gameHeight) {
			return true;

<<<<<<< HEAD
	
=======
		}
		return false;
		
	}
>>>>>>> 18fb9175f21344e80de6a48ddcf849200aefe27a
}
