package org.atlasengine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BuildPanel extends JPanel {
	
	public int x, y, width, height, hierarchy;
	private BuildPanel[] comps;
	
	public BuildPanel() {
		
		this.setLocation(0, 0);
		this.setSize(200, 200);
		setLayout(null);
		setBorder(null);
		super.setBackground(null);
		hierarchy = 0;
		comps = new BuildPanel[0];
	}
	
	public BuildPanel(int x, int y, int width, int height) {
		
		this.setLocation(x, y);
		this.setSize(width, height);
		setLayout(null);
		setBorder(null);
		super.setBackground(null);
		hierarchy = 0;
		comps = new BuildPanel[0];
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
	
	private BuildPanel getMaxHier(BuildPanel[] comps) {
		BuildPanel panel = new BuildPanel();
		panel.hierarchy = 0;
		for (int i = 0; i < comps.length; i++) {
			try {
				if (panel.hierarchy < comps[i].hierarchy) {
					panel = comps[i];
					//System.out.println(panel.hierarchy);
				}
			} catch (Exception e) {}
		}
		return panel;
	}
	
	public void add(BuildPanel panel, int x, int y) {
		
		addToHier(panel);
		panel.setLocation(x, y);
		super.add(panel);
	}
	
	public void add(BuildPanel panel) {
		
		addToHier(panel);
		super.add(panel);
	}
	
	public void add(BuildPanel panel, int hierarchy) {
		
		panel.hierarchy = hierarchy;
		addToHier(panel);
		super.add(panel);
	}
	
	public void setHierarchy(BuildPanel panel, int index) {
		
		panel.hierarchy = index;
		if (this.isAncestorOf(panel) == true) {
			for (int i = 0; i < comps.length; i++) {
				if(comps[i] == panel) {
					comps[i].hierarchy = index;
				}
			}
		} else {
			this.add(panel, index);
		}
		
		int adapt = getMaxHier(comps).hierarchy - index;
		this.setComponentZOrder(panel, adapt);
	}
	
	private void setComponentZOrder(BuildPanel panel, int adapt) {
		
		try {
			super.setComponentZOrder(panel, adapt);
		} catch (IllegalArgumentException e) {
			adapt--;
			System.out.println("La gerarchia è stata impostata a " + (adapt + panel.hierarchy));
			this.setComponentZOrder(panel, adapt);
		}
	}
	
	@Override
	public void setLocation(int x, int y) {
		
		super.setLocation(x,  y);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void setSize(int width, int height) {
		
		super.setSize(width, height);
		this.width = width;
		this.height = height;
	}

}
