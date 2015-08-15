package org.atlasengine;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	public int width, height;
	private String currentPanel;
	
	public Window(String title, Dimension d) {
		this.setTitle(title);
		this.setSize(d.width, d.height);
	}

	public void addPanel(BuildPanel p) {
		this.add(p);
	}
}
