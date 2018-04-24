package evanGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;







public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font normalFont;
	Font bigFont;
	int score;
	Clip clip;
	Clip clip2;


		Survivor man = new Survivor(40,670,50,50);

	ObjectManager manager = new ObjectManager(man);

	 public static BufferedImage normalEnemyImg;
	 public static BufferedImage survivorImg;
	 public static BufferedImage backgroundImg;
	 public static BufferedImage doubleEnemyImg;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	
		titleFont = new Font("Arial", Font.PLAIN, 48);
		normalFont = new Font("Arial", Font.PLAIN, 24);
		bigFont = new Font("Arial", Font.PLAIN, 400);
	   
		  try {



	            normalEnemyImg = ImageIO.read(this.getClass().getResourceAsStream("NormalEnemy.png"));
	            survivorImg = ImageIO.read(this.getClass().getResourceAsStream("Survivor.png"));
	            backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("Background.png"));
	            doubleEnemyImg = ImageIO.read(this.getClass().getResourceAsStream("DoubleEnemy.png"));
	           
	    } catch (IOException e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	    }

	}

	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
		repaint();

	}
	
	


	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	public void startGame() {

		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) 
		{
			if (currentState == END_STATE) {
				man =  new Survivor(40, 670, 50, 50);
				manager = new ObjectManager(man);
				score = 0;
			}
			currentState++;
			if (currentState>END_STATE) {
				currentState=MENU_STATE;
			}
		
		}
	

			
			
	
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		man.jump();
		}
		
		
		}
	

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		
		manager.update();
		if (man.isAlive==false) {
			currentState = END_STATE;
		}
		score +=	1 ;
			}
		
	
	public void updateEndState() {
	
	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.fillRect(0, 0, EvanGame.gameWidth, EvanGame.gameHeight);
		g.setColor(Color.BLACK);
		g.drawString("PirateJump", 75, 200);
		g.setFont(normalFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start ", 100, 400);
	}

	public void drawGameState(Graphics g) {
		g.drawImage(backgroundImg,0,0,EvanGame.gameWidth,EvanGame.gameHeight,null);
		manager.draw(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(45, 25, 115,30 );
		g.setColor(Color.BLUE);
		g.setFont(normalFont);
		g.drawString("SCORE:"+score/60, 50, 50);
		


	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, EvanGame.gameWidth, EvanGame.gameHeight);
		g.setColor(Color.CYAN);
		g.setFont(bigFont);
		g.drawString("GAME", 0, 400);
		g.setFont(normalFont);
		g.drawString("over",1000,420);
		g.drawString("Your score was only "+score/60, 600, 600);
		
		
	}
}
