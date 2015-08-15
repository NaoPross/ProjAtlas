package org.atlasengine;

import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;

public class BuildPanel extends JPanel {
	
	public int hierarchy, objects;
	BuildPanel[] comps;
	public String name;
	
	public BuildPanel() {
		
		setLayout(null);
		setBorder(null);
		super.setBackground(null);
		hierarchy = 0;
	}
	
	private void addToHier(BuildPanel panel) {
		
		BuildPanel[] comps_prov = new BuildPanel[comps.length + 1];
		for (int i = 0; i < comps.length; i++)
			comps_prov[i] = comps[i];
		comps_prov[comps.length] = panel;
		
		comps = new BuildPanel[comps_prov.length];
		for (int i = 0; i < comps.length; i++)
			comps[i] = comps_prov[i];
	}
	
	private void sortHier() {
		
		BuildPanel[] comps_prov = new BuildPanel[comps.length];
		for (int i = 0; i < comps.length; i++)
			comps_prov[i] = comps[i];
		
		comps = new BuildPanel[comps_prov.length];
		for (int i = 0; i < comps.length; i++) {
			for (int j = 0; j < comps.length; j++) {
				if (comps_prov[j].hierarchy == i) {
					comps[i] = comps_prov[i];
				}
			}
		}
	}
	
	public void addSprite(Sprite sprite, int x, int y) {
		
		addToHier(sprite);
		sortHier();
		
		sprite.setLocation(x, y);
		add(sprite);
	}
	
	public void addSprite(Sprite sprite) {
		
		add(sprite);
		objects ++;
	}
	
	public void setBackground(Image img) {
		
		setBackground(img);
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
	
	public void update() {
		
		
	}

}
