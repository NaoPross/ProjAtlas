package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;

public class Elettrone extends Panel {
	
	Color giallo;

	public Elettrone() {
		
		super(200, 300, 30, 30);
		giallo = new Color(255, 255, 0);
		zLevel = 2;
	}
	
	@Override
	public void paintComp(Graphics2D g) {
		
		g.setColor(giallo);
		g.fillOval(x, y, width / 2, height / 2);
	}
}
