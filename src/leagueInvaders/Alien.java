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
		if (y > Runner.gameHeight) {
			isAlive = false;
		
			
	
			
		}
		if (y > Runner.gameHeight) {
			isAlive = false;
			
			
			
			
	
			
		}

	}

	

	public void draw(Graphics g) {
		 g.drawImage(gamePanel.alienImg, x, y, width, height, null);
	}

	
}
