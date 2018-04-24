package evanGame;

import java.awt.Graphics;
import java.util.Random;



public class NormalEnemy extends GameObject{




Random random = new Random();
int speed = random.nextInt(30)+20;
	public NormalEnemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
		
	}
	
	public void update()	{
		super.update();
		x -= speed;
	}
	
		
	
	public void draw(Graphics g) {

	
	g.drawImage(GamePanel.normalEnemyImg, x, y,width,height, null);
	}
		
	}

