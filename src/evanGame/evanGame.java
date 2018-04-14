package evanGame;

import java.awt.Dimension;

import javax.swing.JFrame;

 



public class evanGame {
	gamePanel panel;
	JFrame frame;
	final static int gameWidth = 1280;
	final static int gameHeight = 720;

	public static void main(String[] args) {
		
	evanGame runner = new evanGame();
	runner.setup();
	
	}
	
	public evanGame() {
		frame = new JFrame();
		panel = new gamePanel();
		frame.addKeyListener(panel);
		
	}
	
	public void setup() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.getContentPane().setPreferredSize(new Dimension(gameWidth, gameHeight));
		frame.pack();
		panel.startGame();

	}
	
	
	
	
	
	
}
