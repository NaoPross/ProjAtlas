package org.atlasengine;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	// Window Size
	public int width, height;
	// This layout allow to stack up panels on top of each other
	private CardLayout cardLayout;
	
	public Window(String title, Dimension d) {

		cardLayout = new CardLayout(0, 0);
		
		this.setTitle(title);
		this.setSize(d);
		this.setLayout(cardLayout);
		this.setVisible(true);
	}
}
