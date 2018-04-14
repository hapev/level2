package evanGame;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import javafx.scene.input.KeyCode;



public class gamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font normalFont;
	Font bigFont;

	

	ObjectManager manager = new ObjectManager(man);

	public gamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		normalFont = new Font("Arial", Font.PLAIN, 24);
		bigFont = new Font("Arial", Font.PLAIN, 400);
	   


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
			
			currentState++;
			if (currentState>END_STATE) {
				currentState=MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END_STATE) {
				man =  new survivor(250, 700, 50, 50);
				manager = new ObjectManager(man);
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
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.fillRect(0, 0, evanGame.gameWidth, evanGame.gameHeight);
		g.setColor(Color.BLACK);
		g.drawString("EvanSurvivor", 75, 200);
		g.setFont(normalFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start ", 100, 400);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, evanGame.gameWidth, evanGame.gameHeight);
		manager.draw(g);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, evanGame.gameWidth, evanGame.gameHeight);
		g.setColor(Color.CYAN);
		g.setFont(bigFont);
		g.drawString("GAME", 0, 400);
		g.setFont(normalFont);
		g.drawString("over",1000,420);
		
	}
}
