package leagueInvaders;

import java.awt.Color;
import java.awt.Dimension;
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

	public gamePanel() {
		timer = new Timer(1000 / 60, this);

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

	}

	public void startGame() {

		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
currentState++;
if(currentState > END_STATE){

                currentState = MENU_STATE;

        }


			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("released");
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		
	}
	public void updateEndState() {
		
	}
public void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);

	g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
		
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, Runner.gameWidth, Runner.gameHeight);    
	}
}
