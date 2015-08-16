package org.enginetest;

import java.awt.Color;
import java.awt.Dimension;

<<<<<<< HEAD
import org.atlasengine.*;

public class Game {
	public static void main(String[] args) {
		Window w = new Window("Engine Test Game", new Dimension(800, 800));
		
		BuildPanel mainPanel = new BuildPanel();
		mainPanel.setSize(w.getWidth(), w.getHeight());
		//mainPanel.setBackgroundImage("C:\\Users\\Nicola\\Documents\\Documenti_raffa\\Esperimenti java\\Numeri casuali\\Linear_congruential.png");
		mainPanel.setBackground(Color.BLUE);
		
		BuildPanel red = new BuildPanel(30, 30, 100, 300);
		red.setBackground(Color.RED);
		
		BuildPanel yellow = new BuildPanel(60, 200, 200, 50);
		yellow.setBackground(Color.YELLOW);
		
		BuildPanel green = new BuildPanel(40, 40, 300, 100);
		green.setBackground(Color.GREEN);
		
		mainPanel.add(yellow);
		mainPanel.add(red);
		mainPanel.add(green);
		
		mainPanel.setHierarchy(yellow, 0);
		mainPanel.setHierarchy(red, 1);
		mainPanel.setHierarchy(green, 2);
		
		
		w.add(mainPanel);
		
		w.setVisible(true);
=======
import org.atlasengine.GamePanel;
import org.atlasengine.MenuPanel;
import org.atlasengine.States;
import org.atlasengine.Window;

public class Game {
	
	public static void main(String[] args) {	
		Game g = new Game();
		g.start();
	}
	
	private int WIDTH = 800;
	private int HEIGHT = 600;
	
	private Window frame;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	
	// This variable is used to determine which Panel to show
	private States gameState;
	private boolean gameOver, isRunning;
	
	public Game() {
		// Create a frame and some panels
		frame = new Window("Atlas Project - Game Engine Test", new Dimension(WIDTH, HEIGHT));
		menuPanel = new MenuPanel();
		gamePanel = new GamePanel();
		
		// Add the panels to the CardLayout
		frame.addMenuPanel(menuPanel);
		frame.addGamePanel(gamePanel);
		
		// Show the window
		frame.showWindow();
		// Start the game
		this.isRunning = true;
		this.gameOver = false;
		this.gameState = States.MENU;
	}
	
	public void start() {
		// Program's mainloop
		while (this.isRunning) {
			
			if (this.gameState == States.MENU) {
				// Menu Screen
				frame.showScreen(States.GAMEPANEL);		
			} else if (this.gameState == States.GAME) {
				
				long sleepTime;
				sleepTime = 10;
				
				// Game's mainloop
				while (this.gameOver) {
					
					try {
						Thread.sleep(sleepTime);				
					} catch (InterruptedException e) {
						e.printStackTrace(); 
					}
				}
			}
		}
>>>>>>> origin/master
	}
}

