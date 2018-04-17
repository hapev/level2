package evanGame;
	import java.awt.Color;
	import java.awt.Graphics;
public class Survivor extends GameObject {


	
		int speed;
		float yVelocity = 0;
		float gravity = 5;
		boolean isTouching = true;
	

		public Survivor(int x, int y, int width, int height) {
			super(x, y, width, height);

		
		}
		public void update() {
			super.update();
		
				if (isTouching == true) {
				yVelocity = 0;
			}
		else {
				yVelocity+= gravity;
				
			}
			y += yVelocity;
			
			if (y>=670) {
				isTouching = true;
			}
			
		
			
			
			
			
		}
		
		public void draw(Graphics g) {
		g.drawImage(GamePanel.survivorImg,x,y,width,height,null);
		}
		public void jump() {
			if (isTouching == true) {
			isTouching = false;
			yVelocity = -60;
			}
			
		}
	}


