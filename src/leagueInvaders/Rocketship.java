package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	
	}
	public void update() {
		
	}
	public void moveLeft() {
		x = x-speed;
		}
	public void moveRight() {
		x = x+speed;
		}
	public void moveDown() {
		y = y+speed;
		}
	public void moveUp() {
		y = y-speed;
		}
	
	public void draw(Graphics g) {

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);


		
		
	}
	
}