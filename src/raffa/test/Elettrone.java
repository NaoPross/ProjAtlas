package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;
import raffa.atlasengine.sprite.Sprite;

public class Elettrone extends Sprite {
	
	Color giallo;

	public Elettrone() {
		
		super(200, 300, 30, 30);
		giallo = new Color(255, 255, 0);
		zLevel = 2;
	}
	
	@Override
	public void paintIn(Graphics2D g) {
		
		g.setColor(giallo);
		g.fillOval(0, 0, width, height);
		
	}
}
