package evanGame;

import java.awt.Graphics;
import java.util.Random;



public class DoubleEnemy extends GameObject{




Random random = new Random();
int speed = random.nextInt(20)+20;
	public DoubleEnemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
		
	}
	
	public void update()	{
		super.update();
		x -= speed;
	}
	
		
	
	public void draw(Graphics g) {

	
	g.drawImage(GamePanel.doubleEnemyImg, x, y,width,height, null);
	}
		
	}

