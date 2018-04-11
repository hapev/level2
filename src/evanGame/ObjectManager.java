package evanGame;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;

public class ObjectManager {

	survivor man;

	public ObjectManager(survivor s) {
		this.man = s;
	}

	public void update() {
		man.update();
		

	
		
	}
	
	public void draw(Graphics g) {
		man.draw(g);

	}
	}
