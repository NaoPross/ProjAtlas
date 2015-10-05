package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;
import raffa.atlasengine.sprite.Sprite;

public class Protone extends Sprite {
	
	Color blu;

	public Protone() {
		
		super(400, 300, 100, 100);
		blu = new Color(0, 0, 255);
		zLevel = 1;
	}
	
	@Override
	public void paintIn(Graphics2D g) {
		
		g.setColor(blu);
		g.fillOval(0, 0, width, height);
		//g.setColor(Color.black);
		//g.drawString("Boomber", width / 3, height / 2);
	}
}
