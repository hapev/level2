package leagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	final static int gameWidth = 500;
	final static int gameHeight = 800;
	gamePanel panel;

	public Runner() {
		frame = new JFrame();
		panel = new gamePanel();
		frame.addKeyListener(panel);
		

	}

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.getContentPane().setPreferredSize(new Dimension(500, 800));
		frame.pack();
		panel.startGame();
	}

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.setup();
	}

}
