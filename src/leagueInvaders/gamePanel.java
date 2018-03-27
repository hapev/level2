package leagueInvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	Rocketship rocketship = new Rocketship(250,700,50,50);
	ObjectManager manager = new ObjectManager(rocketship);
	
	public gamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		normalFont = new Font("Arial",Font.PLAIN,24);
		bigFont = new Font("Arial",Font.PLAIN,100);

	}

	public void actionPerformed(ActionEvent e) {
        if(currentState == MENU_STATE){

            updateMenuState();

    }else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

            updateEndState();

    }
		repaint();


	}

	public void paintComponent(Graphics g) {
		   if(currentState == MENU_STATE){

               drawMenuState(g);

       }else if(currentState == GAME_STATE){

               drawGameState(g);

       }else if(currentState == END_STATE){

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
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.moveLeft();
			}	
	
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rocketship.moveRight();
	}	
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		rocketship.moveDown();
	}	
	if (e.getKeyCode() == KeyEvent.VK_UP) {
		rocketship.moveUp();
	}	

	
	
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
currentState++;
System.out.println(currentState);
if(currentState > END_STATE){

                currentState = MENU_STATE;

        }


			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}
	public void updateMenuState() {

	}
	public void updateGameState() {
		manager.update();

	}
	public void updateEndState() {
		
	}
public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
		g.setColor(Color.BLACK);
		g.drawString("League Invaders", 75, 200);
		g.setFont(normalFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start ", 100, 400);
		g.drawString("Press SPACE for help ", 100, 600);
}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
		manager.draw(g);
		
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
		g.setFont(bigFont);
		g.setColor(Color.GREEN);
		g.drawString("GAME", 100, 400);
		g.setFont(bigFont);
		g.setColor(Color.ORANGE);
		g.drawString("over", 100, 460);
	
	
	
	}
}
