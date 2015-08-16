package org.atlasengine;

/***
 * @author NaoPross
 * Create a JFrame and manage JPanels
 */

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {
	// Window Size
	public int width, height;
	// This layout allow to stack up panels on top of each other
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	// Panels Instances
	public MenuPanel menuPanel;
	public GamePanel gamePanel;
	
	public Window(String title, Dimension d) {
		// Create the CardLayout with 0 px of space on both sides
		cardLayout = new CardLayout(0, 0);
		cardPanel = new JPanel();
		
		this.setTitle(title);
		this.setSize(d);
<<<<<<< HEAD
		this.setLayout(cardLayout);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
=======
	}
	
	// Add an instance of MenuPanel in this class
	// And add it to the frame
	public void addMenuPanel(MenuPanel p) {
		this.menuPanel = p;
		cardLayout.addLayoutComponent(menuPanel, States.MENUPANEL.toString());
	}
	
	// Add an instance of GamePanel in this class
	// And add it to the frame
	public void addGamePanel(GamePanel p) {
		this.gamePanel = p;
		cardLayout.addLayoutComponent(gamePanel, States.GAMEPANEL.toString());
	}
	
	// Switch between screens 
	public void showScreen(States p) {	
		cardLayout.show(cardPanel, p.toString());
	}
	
	// Check few things and show the window
	public void showWindow() {
		// Check if everything is Initialized
		if ((menuPanel == null) || (gamePanel == null)) {
			throw new NullPointerException("menuPanel or gamePanel is not initialized");
		} else {
			// show the window
			cardPanel.setLayout(cardLayout);
			this.add(cardPanel);
			this.setVisible(true);
		}
>>>>>>> origin/master
	}
}
