package raffa.test;

import java.awt.Color;
import java.awt.Graphics2D;

import raffa.atlasengine.*;

public class Protone extends AccessPanel {
	
	Color blu;
	public Label text;

	public Protone() {
		
		super(400, 300, 100, 100);
		blu = new Color(0, 0, 255);
		zLevel = 1;
		
		text = new Label("Protone");
		text.setLocation(10, 50);
		text.setSize(17);
		add(text);
		
	}
	
	@Override
	public void paintIn(Graphics2D g) {
		
		g.setColor(blu);
		g.fillOval(0, 0, width, height);
		
	}
}
