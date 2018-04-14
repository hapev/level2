package evanGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Spike extends GameObject{
Random random = new Random();
int speed = random.nextInt(40)+20;
	public Spike(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
		
	}
	
	public void update()	{
		super.update();
		x -= speed;
	}
	
		
	
	public void draw(Graphics g) {
	g.setColor(Color.RED);
	
	g.fillRect(x, y, width, height);
	
	}
		
	}

