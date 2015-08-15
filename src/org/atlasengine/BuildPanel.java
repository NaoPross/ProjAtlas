package org.atlasengine;

import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BuildPanel extends JPanel {
	
	public int hierarchy, objects;
	public String name;
	
	public BuildPanel() {
		
		setLayout(null);
		setBorder(null);
		super.setBackground(null);
		hierarchy = 0;
	}
	
	public void addSprite(Sprite sprite, int x, int y) {
		
		sprite.setLocation(x, y);
		add(sprite);
	}
	
	public void addSprite(Sprite sprite) {
		
		add(sprite);
		objects ++;
	}
	
	public void setBackground(Image img) {
		
		setBackgroundImage(img);
		objects ++;
	}
	
	public int getObjectNumber() {
		
		return objects;
	}
	
	@Override
	public void remove(Component comp) {
		
		super.remove(comp);
		objects --;
	}

}
