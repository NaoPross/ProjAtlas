package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;

public class Protone extends AccessPanel {
	
	Color blu;

	public Protone() {
		
		super(400, 300, 100, 100);
		blu = new Color(0, 0, 255);
		zLevel = 1;
		paint();
		Label text = new Label("Protone");
		text.setLocation(50, 50);
		text.setSize(2);
		add(text);
	}
	
	public void paint() {
		
		g.setColor(blu);
		g.fillOval(0, 0, width, height);
	}
}
