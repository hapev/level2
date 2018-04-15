package evanGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class BigEnemy extends GameObject{



Rectangle landingPad;
Random random = new Random();
int speed = 30;
	public BigEnemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		landingPad = new Rectangle(x,y-1,width,1);
		
		
	}
	
	public void update()	{
		super.update();
		x -= speed;
		landingPad.setBounds(x, y-1, width, 1);
	}
	
		
	
	public void draw(Graphics g) {

	
	g.drawImage(gamePanel.normalEnemyImg, x, y,width,height, null);
	}
		
	}

