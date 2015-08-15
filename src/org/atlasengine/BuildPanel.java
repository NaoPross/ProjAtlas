package org.atlasengine;

import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;

public class BuildPanel extends JPanel {
	
	public int hierarchy, objects;
	private BuildPanel[] comps;
	
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
			for (int j = 0; j < comps.length; i++) {
				if (comps_prov[j].hierarchy == i) {
					comps[i] = comps_prov[j];
					comps_prov[j] = null;
					break;
				}
			}
		}
		
	}
	
	public void addComponent(BuildPanel panel, int x, int y) {
		
		addToHier(panel);
		sortHier();
		
		panel.setLocation(x, y);
		add(panel);
		update();
	}
	
	public void setBackground(Image img) {
		
		setBackground(img);
	}
	
	public int getObjectNumber() {
		
		return objects;
	}
	
	@Override
	public void remove(Component comp) {
		
		super.remove(comp);
		objects --;
	}
	
	@Override
	public Component add(Component comp) {
		
		super.add(comp);
		objects ++;
		return comp;
	}
	
	public void update() {
		
		for (int i = 0; i < comps.length; i++)
			comps[i].setVisible(true);
		repaint();
	}

}