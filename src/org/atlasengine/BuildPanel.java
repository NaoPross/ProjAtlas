package org.atlasengine;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BuildPanel extends JPanel {
	
	public int objects, x, y, width, height, hierarchy;
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
	
	private void sortHier() {
		
		BuildPanel[] comps_prov = new BuildPanel[comps.length];
		for (int i = 0; i < comps.length; i++)
			comps_prov[i] = comps[i];
		
		comps = new BuildPanel[comps_prov.length];
		int i = 0;
		int j = 0;
		
		while (j < comps.length) {
			if (comps_prov[j].hierarchy == i) {
				comps[j] = comps_prov[j];
				j++;
				i = 0;
			} else {
				i++;
			}
		}
		
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
	
	public void setBackgroundImage(String file_path) {
		
		if(file_path == null) {
		} else {
			try {
				BufferedImage img = ImageIO.read(new File(file_path));
				Graphics2D g = (Graphics2D) getGraphics();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			} catch (IOException e) {
				System.out.println("File " + file_path + " could not found.");
			}
		}
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
			this.add(panel);
			setHierarchy(panel, index);
		}
		sortHier();
		int adapt = comps[comps.length - 1].hierarchy - index;
		try {
			setComponentZOrder(panel, adapt);
		} catch (IllegalArgumentException e) {
			adapt = comps[comps.length - 2].hierarchy + 1 - index;
			System.out.println("La gerarchia è stat impostata a " + (adapt + index));
			setComponentZOrder(panel, adapt);
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
	
	public void update() {
		
		sortHier();
		repaint();
	}

}
