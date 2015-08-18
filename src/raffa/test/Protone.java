package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;

public class Protone extends Panel {
	
	Color blu;

	public Protone() {
		
		super(400, 300, 100, 100);
		blu = new Color(0, 0, 255);
		zLevel = 1;
	}
	
	@Override
	public void paintComp(Graphics2D g, MainPanel observer) {
		
		g.setColor(blu);
		g.fillOval(x, y, width / 2, height / 2);
	}
}
