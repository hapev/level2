package evanGame;

import java.awt.Dimension;

import javax.swing.JFrame;

 


public class EvanGame {
	GamePanel panel;
	JFrame frame;
	final static int gameWidth = 1280;
	final static int gameHeight = 720;

	public static void main(String[] args) {
		
	EvanGame runner = new EvanGame();
	runner.setup();
	
	}
	
	public EvanGame() {
		frame = new JFrame();
		panel = new GamePanel();
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
